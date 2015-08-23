package com.viettel.controller;

import globaldefine.GlobalKeyMessage;
import globaldefine.GlobalPage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viettel.data.dao.MockApiDAO;
import com.viettel.data.json.entity.HtmlParse;
import com.viettel.data.json.entity.JsonParser;
import com.viettel.data.json.entity.NodeType;
import com.viettel.data.model.entity.MockApi;
import com.viettel.data.model.form.ProjectForm;
import com.viettel.util.HibernateUtil;
import com.viettel.util.LogUtils;

/**
 * @author hieunq5
 * 
 */
@Controller
public class ProjectController {
	private static final String TAG = ProjectController.class.getSimpleName();

	/**
	 * Get list project owned by this user(defined by userID), return a page
	 * contains list project
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getListProject", method = RequestMethod.POST)
	public ModelAndView getListProject(ModelMap modelMap, HttpSession session) {
		LogUtils.d(TAG, "getListProject()");
		Long userId = HibernateUtil.getLong(session, GlobalKeyMessage.KEY_USER_ID);
		if (userId != null) {
			// Get List Api from server
			List<MockApi> listApi = MockApiDAO.getInstance().getMockApiByUserId(userId);

			List<HtmlParse> htmlParses = JsonParser.convertToHtmlNode(listApi);
			modelMap.addAttribute(GlobalKeyMessage.KEY_LIST_API, htmlParses);
		}

		// Return a page
		return new ModelAndView(GlobalPage.PAGE_LIST_PROJECT);
	}

	/**
	 * Add new project.
	 * 
	 * If success then return a list project,
	 * 
	 * else return page error
	 * 
	 * @param form
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addNewProject", method = RequestMethod.POST)
	public ModelAndView addNewProject(@ModelAttribute ProjectForm projectForm, ModelMap modelMap, HttpSession session) {
		if (projectForm == null || ("").equals(projectForm.getProjectName())) {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}
		Long userId = HibernateUtil.getLong(session, GlobalKeyMessage.KEY_USER_ID);
		if (userId == null) {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}

		// Check whether this Api is existed or not
		MockApi api = MockApiDAO.getInstance().getMockApiByName(userId, -1L, projectForm.getProjectName().trim(), 1L);
		if (api != null) {
			return new ModelAndView(GlobalPage.PAGE_EXISTED);
		}

		// Start request to add new project into DB
		// Create new API
		api = new MockApi();
		api.setApiId(MockApiDAO.getInstance().getNextIndex());
		api.setMockType(NodeType.PROJECT_NODE);
		api.setName(projectForm.getProjectName());
		api.setUserId(userId);
		try {
			api.setLastModified(HibernateUtil.getSysdate());
		} catch (Exception e) {
		}

		// Insert into DB
		boolean added = MockApiDAO.getInstance().addMockApi(api);
		if (added) {
			return getListProject(modelMap, session);
		} else {
			return new ModelAndView(GlobalPage.PAGE_FAIL);
		}
	}
}
