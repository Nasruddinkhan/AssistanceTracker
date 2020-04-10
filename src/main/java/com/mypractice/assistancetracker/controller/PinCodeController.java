package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CITY;
import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.STR_TRUE;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODE;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODES;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODE_URL;
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

import com.mypractice.assistancetracker.dto.PinCodeDTO;
import com.mypractice.assistancetracker.service.PinCodeService;

@Controller
@RequestMapping(MST)
public class PinCodeController {
	@Autowired
	private PinCodeService pinService;

	public void onLoad(ModelMap model) {
		model.addAttribute(PINCODES, pinService.findPinCode());
		model.addAttribute(CITY, pinService.getCity());
	}

	@GetMapping(PINCODE_URL)
	public String showPincode(ModelMap model) {
		onLoad(model);
		PinCodeDTO pincode= new PinCodeDTO();
		pincode.setIsNew(STR_TRUE);
		model.addAttribute(PINCODE, pincode);
		return PINCODE;
	}

	@PostMapping(SLASH + SAVE + PINCODE)
	public String savePincode(@ModelAttribute(PINCODE) @Valid PinCodeDTO pinCodeDTO, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			onLoad(model);
			return PINCODE;
		}
		pinService.savePincode(pinCodeDTO);
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(pinCodeDTO.getIsNew()));
		return RIDIRECT.concat(COLON).concat(PINCODE).concat(URL_ACTION);

	}
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PINCODE)
	public String showEditPinCode(@PathVariable(URL_ID) String pinCode,ModelMap model) {
		onLoad(model);
		PinCodeDTO pincode =  pinService.findPinCode( pinCode);
		model.addAttribute(PINCODE, pincode);
		return PINCODE;
	}
	
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PINCODE)
	public String  deletePinCode(@PathVariable(URL_ID) String pinCode,
			ModelMap model) {
		pinService.deletePinCode(pinCode);
		onLoad(model);
		PinCodeDTO pincode= new PinCodeDTO();
		pincode.setIsNew(STR_TRUE);
		model.addAttribute(PINCODE, pincode);
		return PINCODE;
	}
}
