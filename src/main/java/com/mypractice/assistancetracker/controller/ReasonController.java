/**
 * nasru
 * ReasonController.java
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
import static com.mypractice.assistancetracker.util.CommonUtils.REASON;
import static com.mypractice.assistancetracker.util.CommonUtils.REASON_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.REASONS;
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
import com.mypractice.assistancetracker.dto.ReasonDto;
import com.mypractice.assistancetracker.service.ReasonService;
/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class ReasonController {
	@Autowired
	private ReasonService reasonService;
	private void onLoads(ModelMap model){
		model.addAttribute(REASONS, reasonService.getReasons());
	}
	@GetMapping(REASON_URL)
	public String showReason(ModelMap model) {
		onLoads(model);
		model.addAttribute(REASON, new ReasonDto());
		return REASON;
	}
	@PostMapping(SLASH + SAVE + REASON)
	public String saveReason(@ModelAttribute(REASON) @Valid ReasonDto resoDto, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			onLoads(model);
			return REASON;
		}
		reasonService.saveReason(resoDto);
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(resoDto.getIsNew()));
		return RIDIRECT.concat(COLON).concat(REASON).concat(URL_ACTION);

	}
	
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+REASON)
	public String editReason(@PathVariable(URL_ID) Integer reasonId,ModelMap model) throws Exception {
		onLoads(model);						
		ReasonDto reasonDto =  reasonService.editReason( reasonId);
		model.addAttribute(REASON, reasonDto);
		return REASON;
	}
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+REASON)
	public String  deleteReason(@PathVariable(URL_ID) Integer reasonId,ModelMap model) {
		reasonService.deleteReason(reasonId);
		onLoads(model);
		model.addAttribute(REASON, new ReasonDto());
		return REASON;
	}
}
