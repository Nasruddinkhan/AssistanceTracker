/**
 * nasru
 * NeedyRefferedController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFERED;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFERED_URL;

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
public class NeedyRefferedController {
	@GetMapping(NEEDY_REFERED_URL)
	public String showProfession(ModelMap model) {
		return NEEDY_REFERED;
	}
}
