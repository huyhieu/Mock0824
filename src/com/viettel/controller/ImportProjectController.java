package com.viettel.controller;

import globaldefine.GlobalConst;
import globaldefine.GlobalKeyMessage;
import globaldefine.GlobalPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.viettel.data.dao.MockApiBodyDAO;
import com.viettel.data.dao.MockApiDAO;
import com.viettel.data.dao.MockApiHeaderDAO;
import com.viettel.data.dao.MockApiUriDAO;
import com.viettel.data.json.entity.HtmlParse;
import com.viettel.data.json.entity.JsonParser;
import com.viettel.data.json.entity.MockAPI;
import com.viettel.data.json.entity.NodeParse;
import com.viettel.data.json.entity.NodeType;
import com.viettel.data.model.entity.MockApi;
import com.viettel.data.model.entity.MockApiBody;
import com.viettel.data.model.entity.MockApiHeader;
import com.viettel.data.model.entity.MockApiUri;
import com.viettel.data.model.form.ExportForm;
import com.viettel.data.model.form.ImportForm;
import com.viettel.util.FileFilter;
import com.viettel.util.HibernateUtil;
import com.viettel.util.LogUtils;

/**
 * @author hieunq5
 * 
 */
@Controller
public class ImportProjectController {
	private static final String TAG = ImportProjectController.class.getSimpleName();

	/**
	 * Convert json format to html format
	 * 
	 * 1. Read json text from file
	 * 
	 * 2. Convert json to html
	 * 
	 * 3. Return text with html format(jstree format)
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/extractFile", method = RequestMethod.POST)
	public @ResponseBody
	String extractFile(MultipartHttpServletRequest request, HttpSession session) {

		// 1. Get the files's name from the request object
		Iterator<String> itr = request.getFileNames();
		// 2. Get first file with name
		String fileKey = itr.next();
		MultipartFile mpf = request.getFile(fileKey);
		String fileName = mpf.getOriginalFilename();
		LogUtils.d(TAG, "FileName: " + fileName);

		// 3. Validates data
		// Validate length
		if (mpf.isEmpty()) {
			return GlobalPage.NOT_EXIST;
		}
		// Validate Format
		if (!FileFilter.accept(fileName)) {
			return GlobalPage.WRONG_FORMAT;
		}

		String jsonTxt = "";
		try {
			// 4. Get data
			LogUtils.d(TAG, "Get Data");
			byte[] jsonByte = mpf.getBytes();
			// 5. Convert to Json Text
			jsonTxt = new String(jsonByte);
			LogUtils.d(TAG, "Json: " + jsonTxt);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 6. Validates data
		if (("").equals(jsonTxt)) {
			return GlobalPage.WRONG_FORMAT;
		}
		MockAPI msapi = JsonParser.toObjectFromJsonText(jsonTxt);
		if (msapi == null || (msapi.getVersion() == null && msapi.getNodes() == null)) {
			return GlobalPage.WRONG_FORMAT;
		}

		// Save This List API into Session

		// 7. To Html format
		String html = convertListNodeToHtml(msapi.getNodes());

		// 8. Save this JSON TEXT into session
		session.setAttribute(GlobalKeyMessage.KEY_JSON_TEXT, jsonTxt);
		session.setAttribute(GlobalKeyMessage.KEY_IMPORTED_DATA, msapi);

		return html;
	}

	/**
	 * Import list project and list request into a our server,
	 * 
	 * Prerequisite: File must be formated in our rule(same format with exported
	 * file's format)
	 * 
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/importProject", method = RequestMethod.POST)
	public @ResponseBody
	String importProject(@ModelAttribute ImportForm form, ModelMap modelMap, HttpSession session) {
		LogUtils.d(TAG, "importProject()");

		// Validate data
		if (form == null || form.getSelectedAction() == null) {
			return GlobalPage.ERROR;
		}

		if ((long) form.getSelectedAction() != GlobalConst.UPDATE && (long) form.getSelectedAction() != GlobalConst.OVERRIDE) {
			return GlobalPage.ERROR;
		}

		Long userId = HibernateUtil.getLong(session, GlobalKeyMessage.KEY_USER_ID);
		if (userId == null) {
			return GlobalPage.ERROR;
		}

		// Get data from session
		MockAPI mockAPI = (MockAPI) HibernateUtil.getObject(session, GlobalKeyMessage.KEY_IMPORTED_DATA);
		if (mockAPI == null) {
			return GlobalPage.ERROR;
		}

		saveMockAPI(userId, mockAPI, form.getSelectedAction());

		return GlobalPage.SUCCESS;
	}

	/**
	 * @param userId
	 * @param node
	 * @param type
	 * @return
	 */
	public static MockApi getApiByNode(Long userId, Long parentId, NodeParse node, long type) {
		MockApi api = MockApiDAO.getInstance().getMockApiByName(userId, parentId, node.getApi().getName(), type);
		return api;
	}

	/**
	 * @param userId
	 * @param mockAPI
	 * @param actionType
	 */
	private void saveMockAPI(Long userId, MockAPI mockAPI, long actionType) {
		List<NodeParse> htmlParses = JsonParser.convertToNodeParse(mockAPI.getNodes());
		for (NodeParse project : htmlParses) {
			MockApi newProject = getApiByNode(userId, -1L, project, 1);
			if (newProject != null) {
				for (NodeParse service : project.getListApi()) {
					// Check whether existed this serice or not
					MockApi newService = getApiByNode(userId, newProject.getApiId(), service, 2);
					if (newService != null) {
						for (NodeParse request : service.getListApi()) {
							MockApi newRequest = getApiByNode(userId, newService.getApiId(), request, 3);
							if (newRequest == null) {
								// Add this request into service
								newRequest = createMockApi(userId, service.getApi());
								newRequest.setParentId(newService.getApiId());

								// Create and add body
								MockApiBody body = createBody(request.getApi().getBody());
								if (body != null) {
									body.setMockId(newRequest.getApiId());
									newRequest.setBody(body);
								}

								// Create and add uri
								MockApiUri uri = createUri(request.getApi().getUri());
								if (uri != null) {
									uri.setMockId(newRequest.getApiId());
									newRequest.setUri(uri);
								}

								// Create and add headers
								if (request.getApi().getHeaders() != null) {
									for (MockApiHeader header : request.getApi().getHeaders()) {
										header.setHeaderId(MockApiHeaderDAO.getInstance().getNextIndex());
									}
									newRequest.setHeaders(request.getApi().getHeaders());
								}

								// Add this newRequest into DB
								MockApiDAO.getInstance().addMockApi(newRequest);

							} else {
								if (actionType == GlobalConst.OVERRIDE) {
									// Update body
									MockApiBody body = createBody(request.getApi().getBody());
									if (body != null) {
										body.setBodyId(newRequest.getBody().getBodyId());
										body.setMockId(newRequest.getApiId());
										newRequest.setBody(body);
									}
									// Update Uri
									MockApiUri uri = createUri(request.getApi().getUri());
									if (uri != null) {
										uri.setUriId(newRequest.getUri().getUriId());
										uri.setMockId(newRequest.getApiId());
										newRequest.setUri(uri);
									}

									// Update headers:
									// 1. remove existed headers
									// 2. Add new headers
									MockApiHeaderDAO.getInstance().deleteApiHeaderByMockId(newRequest.getApiId());
									if (request.getApi().getHeaders() != null) {
										for (MockApiHeader header : request.getApi().getHeaders()) {
											header.setHeaderId(MockApiHeaderDAO.getInstance().getNextIndex());
											header.setMockId(newRequest.getApiId());
										}
										newRequest.setHeaders(request.getApi().getHeaders());
									}

									MockApiDAO.getInstance().saveOrUpdate(newRequest);
								}
							}
						}
					} else {
						// Not existed Service, then add this service and
						// its child into DB
						// 1. Add this service into DB
						newService = createMockApi(userId, service.getApi());
						// Save this newService into DB
						MockApiDAO.getInstance().addMockApi(newService);

						// 2. Add children(list request) into dB
						for (NodeParse request : service.getListApi()) {
							// Add this request into service
							MockApi newRequest = createMockApi(userId, request.getApi());
							// Add this newRequest into DB
							MockApiDAO.getInstance().addMockApi(newRequest);
						}
					}
				}
			} else {
				// Not existed Project, then do as follows:
				// 1. Create and add new project into dB
				// 2. Create and add all Service into DB
				// 3. Create and add all Request into DB

				// 1. Create and add new project into dB
				newProject = createMockApi(userId, project.getApi());
				// Save this new Project into DB
				MockApiDAO.getInstance().addMockApi(newProject);

				// 2. Create and add all Service into DB
				for (NodeParse service : project.getListApi()) {
					// 2.1 Create new service
					MockApi newService = createMockApi(userId, service.getApi());
					newService.setParentId(newProject.getApiId());
					// 2.2 Save to db
					MockApiDAO.getInstance().addMockApi(newService);

					// 3. Create and add all Request into DB
					for (NodeParse request : service.getListApi()) {
						// 3.1 Create new request
						MockApi newRequest = createMockApi(userId, request.getApi());
						newRequest.setParentId(newService.getApiId());

						// Create and add body
						MockApiBody body = createBody(request.getApi().getBody());
						if (body != null) {
							body.setBodyId(MockApiBodyDAO.getInstance().getNextIndex());
							body.setMockId(newRequest.getApiId());
							newRequest.setBody(body);
						}

						// Create and add uri
						MockApiUri uri = createUri(request.getApi().getUri());
						if (uri != null) {
							uri.setUriId(MockApiUriDAO.getInstance().getNextIndex());
							uri.setMockId(newRequest.getApiId());
							newRequest.setUri(uri);
						}

						// Create and add headers
						if (request.getApi().getHeaders() != null) {
							for (MockApiHeader header : request.getApi().getHeaders()) {
								header.setHeaderId(MockApiHeaderDAO.getInstance().getNextIndex());
								header.setMockId(newRequest.getApiId());
							}
							newRequest.setHeaders(request.getApi().getHeaders());
						}

						// 3.2 Save to db
						MockApiDAO.getInstance().addMockApi(newRequest);
					}
				}
			}
		}
	}

	private MockApi createMockApi(Long userId, MockApi api) {
		api.setApiId(MockApiDAO.getInstance().getNextIndex());
		try {
			api.setLastModified(HibernateUtil.getSysdate());
		} catch (Exception e) {
		}
		api.setUserId(userId);

		return api;
	}

	private MockApiBody createBody(MockApiBody body) {
		MockApiBody newBody = null;
		if (body != null) {
			newBody = new MockApiBody();
			newBody.setBodyAutoLength(body.getBodyAutoLength());
			newBody.setBodyInput(body.getBodyInput());
			newBody.setBodyType(body.getBodyType());
			newBody.setBodyOutput(body.getBodyOutput());
		}
		return newBody;
	}

	private MockApiUri createUri(MockApiUri uri) {
		MockApiUri newUri = null;
		if (uri != null) {
			newUri = new MockApiUri();
			newUri.setLink(uri.getLink());
			newUri.setSchemeName(uri.getSchemeName());
			newUri.setSchemeVersion(uri.getSchemeVersion());
		}
		return newUri;
	}

	/**
	 * Export list project and list request into a file,
	 * 
	 * This file could be used for importing in another Server
	 * 
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/exportProject", method = RequestMethod.POST)
	public ModelAndView exportProject(@ModelAttribute ExportForm form, ModelMap modelMap, HttpSession session) {
		if (form == null || ("").equals(form.getFileName()) || ("").equals(form.getSelectedIds())) {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}

		Long userId = HibernateUtil.getLong(session, GlobalKeyMessage.KEY_USER_ID);
		if (userId == null) {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}

		List<MockApi> listApi = MockApiDAO.getInstance().getMockApiByUserId(userId);
		// Get data from DB
		if (listApi == null) {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}

		MockAPI mockApi = new MockAPI(listApi);
		// Remove all node is not selected
		// 1. Find and remove all Request are not selected
		// 2. Find and remove all Service are not selected
		// 3. Find and remove all Project are not selected

		// 1. Find and remove all Request are not selected
		String[] selectedIds = form.getSelectedIds().split(",");
		List<MockApi> removeNode = new ArrayList<MockApi>();
		for (MockApi request : mockApi.getNodes()) {
			if (NodeType.REQUEST_NODE == (long) request.getMockType()) {
				// This is Request
				boolean selected = false;
				for (String nodeId : selectedIds) {
					if (nodeId.trim().equals(request.getApiId() + "")) {
						selected = true;
						break;
					}
				}
				if (!selected) {
					// Remove this node from list.
					removeNode.add(request);
				}
			}
		}
		mockApi.getNodes().removeAll(removeNode);

		// 2. Find and remove all Service are not selected
		removeNode.clear();
		for (MockApi service : mockApi.getNodes()) {
			if (NodeType.SERVICE_NODE == (long) service.getMockType()) {
				// This is Service
				boolean existed = false;
				for (MockApi request : mockApi.getNodes()) {
					if (NodeType.REQUEST_NODE == (long) request.getMockType() && (long) request.getParentId() == (long) service.getApiId()) {
						existed = true;
						break;
					}
				}
				if (!existed) {
					removeNode.add(service);
				}
			}
		}
		mockApi.getNodes().removeAll(removeNode);

		// 3. Find and remove all Project are not selected
		removeNode.clear();
		for (MockApi project : mockApi.getNodes()) {
			if (NodeType.PROJECT_NODE == (long) project.getMockType()) {
				// This is Service
				boolean existed = false;
				for (MockApi service : mockApi.getNodes()) {
					if (NodeType.SERVICE_NODE == (long) service.getMockType() && (long) service.getParentId() == (long) project.getApiId()) {
						existed = true;
						break;
					}
				}
				if (!existed) {
					removeNode.add(project);
				}
			}
		}
		mockApi.getNodes().removeAll(removeNode);

		boolean success = true;
		// Start to export data
		success = JsonParser.exportJson(mockApi, form.getFileName());

		// Check to return appropriate page
		if (success) {
			return new ModelAndView(GlobalPage.PAGE_SUCCESS);
		} else {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}
	}

	/**
	 * Export list project and list request into a file,
	 * 
	 * This file could be used for importing in another Server
	 * 
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getListRequest", method = RequestMethod.POST)
	public ModelAndView getListRequest(@ModelAttribute ExportForm form, ModelMap modelMap, HttpSession session) {
		// Get data saved in DB and put into object
		Long userId = HibernateUtil.getLong(session, GlobalKeyMessage.KEY_USER_ID);
		if ((long) userId != 1) {
			return new ModelAndView(GlobalPage.PAGE_LIST_REQUEST);
		}
		// Get List Api from server
		List<MockApi> listApi = MockApiDAO.getInstance().getMockApiByUserId(userId);

		// To Html format
		String html = convertListNodeToHtml(listApi);

		// Save this object into session
		session.setAttribute(GlobalKeyMessage.KEY_LIST_HTML_PARSE, html);

		// Check to return appropriate page
		return new ModelAndView(GlobalPage.PAGE_LIST_REQUEST);
	}

	/**
	 * Convert list MockApi to Html text, used to show in Client
	 * 
	 * @param listApi
	 * @return
	 */
	private String convertListNodeToHtml(List<MockApi> listApi) {
		// Start to export data
		List<HtmlParse> htmlParses = JsonParser.convertToHtmlNode(listApi);

		// Generate HTML with list object
		String html = "<ul>"; 
		if (htmlParses.size() > 0) {
			for (HtmlParse project : htmlParses) {
				// Project
				html += "<li id=\"" + project.getNodeID() + "\"" + GlobalConst.TREE_NODE_PROJECT + ">" + project.getName();
				if (project.getHtmlParses().size() > 0) {
					html += "<ul>";
				}
				for (HtmlParse service : project.getHtmlParses()) {
					html += "<li id=\"" + service.getNodeID() + "\"" + GlobalConst.TREE_NODE_SERVICE+ ">" + service.getName();
					if (service.getHtmlParses().size() > 0) {
						html += "<ul>";
					}
					for (HtmlParse request : service.getHtmlParses()) {
						html += "<li id=\"" + request.getNodeID() + "\"" + GlobalConst.TREE_NODE_REQUEST + ">" + request.getName();
						html += "</li>";
					}
					if (service.getHtmlParses().size() > 0) {
						html += "</ul>";
					}
					html += "</li>";
				}
				if (project.getHtmlParses().size() > 0) {
					html += "</ul>";
				}
				html += "</li>";
			}
		}
		html += "</ul>";
		return html;
	}
}
