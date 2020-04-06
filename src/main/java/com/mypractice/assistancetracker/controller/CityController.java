/**
 * nasru
 * CityController.java
 * Apr 5, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CITY;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypractice.assistancetracker.dto.CityDTO;
import com.mypractice.assistancetracker.service.CityService;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class CityController {
	@Autowired
	private CityService cityService;

	public void onLoad(ModelMap model) {
		model.addAttribute(STATE, cityService.getState());
	}

	@GetMapping(CITY_URL)
	public String showCity(ModelMap model) {
		System.out.println("CountryController.showCity() @@@@@@@@@@@");
		onLoad(model);
		model.addAttribute(CITY, new CityDTO());
		return CITY;
	}

	@PostMapping(SLASH + SAVE + CITY)
	public String saveCity(@ModelAttribute(CITY) @Valid CityDTO cityDto, BindingResult result, ModelMap model) {
		System.out.println(cityDto);
		if (result.hasErrors()) {
			return CITY;
		}
		return RIDIRECT.concat(COLON).concat(CITY).concat(URL_ACTION);

	}
}
