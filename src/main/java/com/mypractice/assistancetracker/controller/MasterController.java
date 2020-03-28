/**
 * nasru
 * MasterController.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypractice.assistancetracker.dto.CountryDTO;
import com.mypractice.assistancetracker.model.MstCode;
import com.mypractice.assistancetracker.service.CountryService;
import com.mypractice.assistancetracker.service.MstCodeService;
import com.mypractice.assistancetracker.util.CommonUtils;

import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.ALL_MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.DROPDOWN_BEAN;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODE_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.PINCODE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRIES;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class MasterController {
	@Autowired
	private MstCodeService mstCodeService;
	@Autowired
	private CountryService countryService;
	@GetMapping(ALL_MASTER)
	public String allMasters(ModelMap model) {
		model.addAttribute(DROPDOWN_BEAN, new MstCode());
		model.addAttribute(MASTER, mstCodeService.getAllMaster());
		return CommonUtils.MASTER;
	}
	@PostMapping(ALL_MASTER)
	public String showMasterJsp(@ModelAttribute(DROPDOWN_BEAN) MstCode mstCode) {
		return RIDIRECT.concat(COLON).concat(mstCode.getCodeID().toLowerCase()).concat(URL_ACTION);
	}
	@GetMapping(STATE_URL)
	public String showState() {
		return STATE;
	}
	@GetMapping(COUNTRY_URL)
	public String showCountry(ModelMap model) {
		model.addAttribute(COUNTRY, new CountryDTO());
		model.addAttribute(COUNTRIES, countryService.findAllCountry());
		return COUNTRY;
	}
	@GetMapping(CITY_URL)
	public String showCity() {
		return CITY;
	}
	@GetMapping(PINCODE_URL)
	public String showPincode() {
		return PINCODE;
	}
}
