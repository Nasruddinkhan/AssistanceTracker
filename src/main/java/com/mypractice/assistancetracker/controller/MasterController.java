/**
 * nasru
 * MasterController.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.ALL_MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.DROPDOWN_BEAN;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypractice.assistancetracker.model.MstCode;
import com.mypractice.assistancetracker.service.MstCodeService;
/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class MasterController {
	@Autowired
	private MstCodeService mstCodeService;
	@GetMapping(ALL_MASTER)
	public String allMasters(ModelMap model) {
		model.addAttribute(DROPDOWN_BEAN, new MstCode());
		model.addAttribute(MASTER, mstCodeService.getAllMaster());
		return MASTER;
	}

	@PostMapping(ALL_MASTER)
	public String showMasterJsp(@ModelAttribute(DROPDOWN_BEAN) MstCode mstCode) {
		return RIDIRECT.concat(COLON).concat(mstCode.getCodeID().toLowerCase()).concat(URL_ACTION);
	}
	
}
