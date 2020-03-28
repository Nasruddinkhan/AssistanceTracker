/**
 * nasru
 * MemberController.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypractice.assistancetracker.util.CommonUtils;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(CommonUtils.MEMBER)
public class MemberController {
	@GetMapping(CommonUtils.SHOW_MEMBER_PAGE)
	public String showMemberPage() {
		return CommonUtils.MEMBER_PAGE;
	}
}
