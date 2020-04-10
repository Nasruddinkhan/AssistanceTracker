/**
 * nasru
 * PaymentModeController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENT_MODE;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENT_MODE_URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class PaymentModeController {
	@GetMapping(PAYMENT_MODE_URL)
	public String showProfession(ModelMap model) {
		return PAYMENT_MODE;
	}
}
