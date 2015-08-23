package com.viettel.controller;

import globaldefine.GlobalPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viettel.util.LogUtils;

/**
 * @author hieunq5
 * 
 */
@Controller
public class DialogController {
	private static final String TAG = DialogController.class.getSimpleName();

	/**
	 * Request to show dialog Add Project
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/showDialogAddProject", method = RequestMethod.POST)
	public ModelAndView showDialogAddProject() {
		LogUtils.d(TAG, "showDialogAddProject()");

		// Return a page
		return new ModelAndView(GlobalPage.DIALOG_ADD_PROJECT);
	}

	/**
	 * Request to show dialog export request list
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/showDialogExportProject", method = RequestMethod.POST)
	public ModelAndView showDialogExportProject() {
		LogUtils.d(TAG, "showDialogExportProject()");

		// Return a page
		return new ModelAndView(GlobalPage.DIALOG_EXPORT_PROJECT);
	}

	/**
	 * Request to show dialog export request list
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/showDialogImportProject", method = RequestMethod.POST)
	public ModelAndView showDialogImportProject() {
		LogUtils.d(TAG, "showDialogImportProject()");

		// Return a page
		return new ModelAndView(GlobalPage.DIALOG_IMPORT_PROJECT);
	}
}
