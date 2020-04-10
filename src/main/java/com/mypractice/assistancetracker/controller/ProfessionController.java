/**
 * nasru
 * ProfessionController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION;
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
public class ProfessionController {

	@GetMapping(PROFESSION_URL)
	public String showProfession(ModelMap model) {
		return PROFESSION;
	}
}
