/**
 * nasru
 * ProfessionController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSIONS;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION_URL;
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

import com.mypractice.assistancetracker.dto.ProfessionDTO;
import com.mypractice.assistancetracker.service.ProfessionService;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class ProfessionController {
	@Autowired
	private ProfessionService professionService;
	private void onLoads(ModelMap model){
		model.addAttribute(PROFESSIONS, professionService.getProfession());
	}
	@GetMapping(PROFESSION_URL)
	public String showProfession(ModelMap model) {
		onLoads(model);
		model.addAttribute(PROFESSION, new ProfessionDTO());
		return PROFESSION;
	}
	
	@PostMapping(SLASH + SAVE + PROFESSION)
	public String saveProfession(@ModelAttribute(PROFESSION) @Valid ProfessionDTO professionDTO, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("ProfessionController.saveRelationship()"+professionDTO);
		if (result.hasErrors()) {
			onLoads(model);
			return PROFESSION;
		}
		professionService.saveProfession(professionDTO);
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(professionDTO.getIsNew()));
		return RIDIRECT.concat(COLON).concat(PROFESSION).concat(URL_ACTION);

	}
	
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PROFESSION)
	public String editProfession(@PathVariable(URL_ID) Integer professionId,ModelMap model) throws Exception {
		onLoads(model);						
		ProfessionDTO professionDto =  professionService.editProfession( professionId);
		model.addAttribute(PROFESSION, professionDto);
		return PROFESSION;
	}
	
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PROFESSION)
	public String  deleteProfession(@PathVariable(URL_ID) Integer professionId,ModelMap model) {
		professionService.deleteProfession(professionId);
		onLoads(model);
		model.addAttribute(PROFESSION, new  ProfessionDTO());
		return PROFESSION;
	}
}
