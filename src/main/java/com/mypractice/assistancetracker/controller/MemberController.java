/**
 * nasru
 * MemberController.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CITIES;
import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRIES;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER_PAGE;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.PAGINATION;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSIONS;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SHOW_ADD_MEMMBER_PEGE;
import static com.mypractice.assistancetracker.util.CommonUtils.SHOW_MEMBER_PAGE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.STATES;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.isEmptyString;
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

import com.mypractice.assistancetracker.dto.MemberDTO;
import com.mypractice.assistancetracker.service.CityService;
import com.mypractice.assistancetracker.service.MemberService;
import com.mypractice.assistancetracker.service.StateService;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MEMBER)
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;
	@GetMapping(SHOW_MEMBER_PAGE)
	public String showMemberPage(ModelMap model) {
		System.out.println("MemberController.showMemberPage()");
		findAllMember(model, 1);
		return MEMBER_PAGE;
	}
	private void findAllMember(ModelMap model, int pageNo){
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("pageCtn", memberService.getMemeberPageCount());
		model.addAttribute("memberList", memberService.findAllMember(pageNo));
	}
	@GetMapping(SHOW_MEMBER_PAGE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PAGINATION+URL_ACTION)
	public String paginationWithMemberDetails(@PathVariable(URL_ID) Integer pageNo,  ModelMap model) {
		findAllMember(model, pageNo);
		return MEMBER_PAGE;
	}
	@GetMapping(SLASH + SHOW_ADD_MEMMBER_PEGE)
	public String showAddMemberPage(ModelMap model) {
		model.addAttribute(SHOW_ADD_MEMMBER_PEGE, new MemberDTO());
		onLoads(model);
		return SHOW_ADD_MEMMBER_PEGE;
	}
	private void onLoads(ModelMap model) {
		model.addAttribute(COUNTRIES, stateService.getCountries());
		model.addAttribute(PROFESSIONS, memberService.getProfession());
	}
	@PostMapping(SLASH + SAVE + SHOW_ADD_MEMMBER_PEGE)
	public String saveMember(@ModelAttribute(SHOW_ADD_MEMMBER_PEGE) @Valid MemberDTO memberDTO, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			onLoads(model);
			model.addAttribute(STATES, 	isEmptyString(memberDTO.getCountry())?null:stateService.getStates(memberDTO.getCountry()));
			model.addAttribute(CITIES,  isEmptyString(memberDTO.getState())?null:cityService.getCities(memberDTO.getState()));
			return SHOW_ADD_MEMMBER_PEGE;
		}
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(memberDTO.getIsNew()));
		memberService.saveMember(memberDTO);
		return RIDIRECT.concat(COLON).concat( SLASH+MEMBER_PAGE + SHOW_MEMBER_PAGE).concat(URL_ACTION);
	}
}
