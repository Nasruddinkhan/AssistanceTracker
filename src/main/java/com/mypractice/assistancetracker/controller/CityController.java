/**
 * nasru
 * CityController.java
 * Apr 5, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CITY;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.responseResult;
import static com.mypractice.assistancetracker.util.ErrorConstant.SUCCESS;
import static com.mypractice.assistancetracker.util.CommonUtils.CITIES;
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

import com.mypractice.assistancetracker.dto.CityDTO;
import com.mypractice.assistancetracker.dto.StateDto;
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
		model.addAttribute(CITIES, cityService.findAllCity());
	}

	@GetMapping(CITY_URL)
	public String showCity(ModelMap model) {
		System.out.println("CountryController.showCity() @@@@@@@@@@@");
		onLoad(model);
		model.addAttribute(CITY, new CityDTO());
		return CITY;
	}

	@PostMapping(SLASH + SAVE + CITY)
	public String saveCity(@ModelAttribute(CITY) @Valid CityDTO cityDto, BindingResult result, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		System.out.println(cityDto);
		if (result.hasErrors()) {
			onLoad(model);
			return CITY;
		}
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(cityDto.getIsNew()));
		cityService.saveCity(cityDto);
		return RIDIRECT.concat(COLON).concat(CITY).concat(URL_ACTION);

	}
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+CITY)
	public String showEditState(@PathVariable(URL_ID) String cityCode,ModelMap model) {
		onLoad(model);
		CityDTO cityDto =  cityService.findCity(cityCode);
		model.addAttribute(CITY, cityDto);
		return CITY;
	}
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+CITY)
	public String  deleteCountry(@PathVariable(URL_ID) String cityCode,
			ModelMap model) {
		cityService.deleteCity(cityCode);
		onLoad(model);
		model.addAttribute(CITY, new CityDTO());
		return CITY;
	}
}
