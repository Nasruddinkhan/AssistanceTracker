/**
 * nasru
 * MasterController.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(Comm)
public class MasterController {
	@GetMapping("/allmaster")
	public String allMasters() {
		return "master";
	}
}
