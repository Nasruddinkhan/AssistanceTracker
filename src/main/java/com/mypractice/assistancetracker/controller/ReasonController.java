/**
 * nasru
 * ReasonController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.REASON;
import static com.mypractice.assistancetracker.util.CommonUtils.REASON_URL;
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
public class ReasonController {
	@GetMapping(REASON_URL)
	public String showReason(ModelMap model) {
		return REASON;
	}
}
