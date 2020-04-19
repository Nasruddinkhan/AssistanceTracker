/**
 * nasru
 * StateController.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRIES;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE;
import static com.mypractice.assistancetracker.util.CommonUtils.STATES;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_URL;
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

import com.mypractice.assistancetracker.dto.StateDto;
import com.mypractice.assistancetracker.service.StateService;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class StateController {
	@Autowired
	private StateService stateService;
	public void onLoads(ModelMap model) {
		model.addAttribute(STATE, new StateDto());
		model.addAttribute(COUNTRIES, stateService.getCountries());
		model.addAttribute(STATES, stateService.getStates());
	}
	@GetMapping(STATE_URL)
	public String showState(ModelMap model) {
		onLoads(model);
		return STATE;
	}
	@PostMapping(SLASH+SAVE+STATE)
	public String saveCountry(@ModelAttribute(STATE) @Valid StateDto stateDto, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute(COUNTRIES, stateService.getCountries());
			model.addAttribute(STATES, stateService.getStates());
			return STATE;
		}
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(stateDto.getIsNew()));
		stateService.addSate(stateDto);
		return RIDIRECT.concat(COLON).concat(STATE).concat(URL_ACTION);
	}
	
//editstate
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+STATE)
	public String showEditState(@PathVariable(URL_ID) String stateCode,ModelMap model) {
		onLoads(model);
		System.out.println();
		StateDto stateDto =  stateService.findState(stateCode);
		model.addAttribute(STATE, stateDto);
		return STATE;
	}
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+STATE)
	public String  deleteCountry(@PathVariable(URL_ID) String stateCode,
			ModelMap model) {
		stateService.deleteState(stateCode);
		onLoads(model);
		return STATE;
	}
}
