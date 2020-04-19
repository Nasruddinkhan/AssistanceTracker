/**
 * nasru
 * MemberController.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.controller;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRIES;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER_PAGE;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SHOW_ADD_MEMMBER_PEGE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.STATES;
import static com.mypractice.assistancetracker.util.CommonUtils.CITIES;
import static com.mypractice.assistancetracker.util.CommonUtils.responseResult;
import static com.mypractice.assistancetracker.util.ErrorConstant.SUCCESS;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mypractice.assistancetracker.dto.MemberDTO;
import com.mypractice.assistancetracker.service.CityService;
import com.mypractice.assistancetracker.service.StateService;
import com.mypractice.assistancetracker.util.CommonUtils;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(CommonUtils.MEMBER)
public class MemberController {
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;
	@GetMapping(CommonUtils.SHOW_MEMBER_PAGE)
	public String showMemberPage() {
		return MEMBER_PAGE;
	}
	@GetMapping(SLASH + SHOW_ADD_MEMMBER_PEGE)
	public String showAddMemberPage(Model model) {
		model.addAttribute(SHOW_ADD_MEMMBER_PEGE, new MemberDTO());
		model.addAttribute(COUNTRIES, stateService.getCountries());
		return SHOW_ADD_MEMMBER_PEGE;
	}
	@PostMapping(SLASH + SAVE + SHOW_ADD_MEMMBER_PEGE)
	public String saveMember(@ModelAttribute(SHOW_ADD_MEMMBER_PEGE) @Valid MemberDTO memberDTO, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			System.out.println("MemberController.saveMember() error occur");
			model.addAttribute(COUNTRIES, stateService.getCountries());
			model.addAttribute(STATES, stateService.getStates(memberDTO.getCountry()));
			model.addAttribute(CITIES, cityService.getCities(memberDTO.getState()));
				return SHOW_ADD_MEMMBER_PEGE;
		}
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(memberDTO.getIsNew()));
		return RIDIRECT.concat(COLON).concat(MEMBER_PAGE).concat(URL_ACTION);

	}
}
