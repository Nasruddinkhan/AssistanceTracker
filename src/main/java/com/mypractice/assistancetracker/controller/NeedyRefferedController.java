/**
 * nasru
 * NeedyRefferedController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.DROPDOWN_BEAN;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFERED;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFEREDS;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFERED_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.responseResult;
import static com.mypractice.assistancetracker.util.ErrorConstant.SUCCESS;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mypractice.assistancetracker.dto.NeedyRefferedDto;
import com.mypractice.assistancetracker.service.NeedyRefferedSerive;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class NeedyRefferedController {
	@Autowired
	private NeedyRefferedSerive needyRefferedService;
	private void onLoads(ModelMap model){
		model.addAttribute(NEEDY_REFEREDS, needyRefferedService.findAllRefferer());
		model.addAttribute(DROPDOWN_BEAN,needyRefferedService.findAllRelationShip());
	}
	@GetMapping(NEEDY_REFERED_URL)
	public String showProfession(ModelMap model) {
		onLoads(model);
		model.addAttribute(NEEDY_REFERED, new NeedyRefferedDto());
		return NEEDY_REFERED;
	}
	
	@PostMapping(SLASH + SAVE + NEEDY_REFERED)
	public String saveNeedyRefferer(@ModelAttribute(NEEDY_REFERED) @Valid NeedyRefferedDto refferDto, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			onLoads(model);
			return NEEDY_REFERED;
		}
		needyRefferedService.saveNeedyRefferer(refferDto);
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(refferDto.getIsNew()));
		return RIDIRECT.concat(COLON).concat(NEEDY_REFERED).concat(URL_ACTION);

	}
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+NEEDY_REFERED)
	public String editNeedyRefferer(@PathVariable(URL_ID) Integer needyReferId,ModelMap model) throws Exception {
		onLoads(model);						
		model.addAttribute(NEEDY_REFERED, needyRefferedService.editNeedyRefferer( needyReferId));
		return NEEDY_REFERED;
	}
	
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+NEEDY_REFERED)
	public String  deleteNeedyRefferer(@PathVariable(URL_ID) Integer needyReferId,ModelMap model) {
		needyRefferedService.deleteNeedyRefferer(needyReferId);
		onLoads(model);
		model.addAttribute(NEEDY_REFERED, new NeedyRefferedDto());
		return NEEDY_REFERED;
	}
}
