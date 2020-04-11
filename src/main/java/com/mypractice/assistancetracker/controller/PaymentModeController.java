/**
 * nasru
 * PaymentModeController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENTS;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENT_MODE;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENT_MODE_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODE;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.STR_TRUE;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;

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

import com.mypractice.assistancetracker.dto.PaymentDTO;
import com.mypractice.assistancetracker.dto.PinCodeDTO;
import com.mypractice.assistancetracker.service.PaymentModeService;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class PaymentModeController {
	@Autowired
	private PaymentModeService modeService;
	public void onLoads(ModelMap model) {
		model.addAttribute(PAYMENTS, modeService.findAllPayment());
	}
	@GetMapping(PAYMENT_MODE_URL)
	public String showProfession(ModelMap model) {
		 onLoads(model);
		model.addAttribute(PAYMENT_MODE, new PaymentDTO());
		return PAYMENT_MODE;
	}
	@PostMapping(SLASH + SAVE + PAYMENT_MODE)
	public String savePaymentMode(@ModelAttribute(PAYMENT_MODE) @Valid PaymentDTO paymentDTO, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			onLoads(model);
			return PAYMENT_MODE;
		}
		modeService.savePaymentMode(paymentDTO);
		//redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		//redirectAttributes.addFlashAttribute(MSG, responseResult(pinCodeDTO.getIsNew()));
		return RIDIRECT.concat(COLON).concat(PAYMENT_MODE).concat(URL_ACTION);

	}
	
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PAYMENT_MODE)
	public String editPaymentMode(@PathVariable(URL_ID) String paymentModeId,ModelMap model) throws Exception {
		onLoads(model);						
		PaymentDTO paymentDTO =  modeService.editPaymentMode( paymentModeId);
		model.addAttribute(PAYMENT_MODE, paymentDTO);
		return PAYMENT_MODE;
	}
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PAYMENT_MODE)
	public String  deletePinCode(@PathVariable(URL_ID) String paymentModeId,
			ModelMap model) {
		modeService.deletePaymentMode(paymentModeId);
		onLoads(model);
		model.addAttribute(PAYMENT_MODE, new PaymentDTO());
		return PAYMENT_MODE;
	}
}
