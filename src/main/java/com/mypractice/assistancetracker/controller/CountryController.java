/**
 * nasru
 * CountryController.java
 * Mar 29, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRIES;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.ErrorConstant.SUCCESS;
import static com.mypractice.assistancetracker.util.CommonUtils.responseResult;
import static com.mypractice.assistancetracker.util.CommonUtils.EDI_COUNTRY_URL;
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
import com.mypractice.assistancetracker.dto.CountryDTO;
import com.mypractice.assistancetracker.service.CountryService;
/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	public void onLoads(ModelMap model) {
		model.addAttribute(COUNTRY, new CountryDTO());
		model.addAttribute(COUNTRIES, countryService.findAllCountry());
	}
	@GetMapping(COUNTRY_URL)
	public String showCountry(ModelMap model) {
		System.out.println("CountryController.showCountry() @@@@@@@@@@@");
		onLoads(model);
		return COUNTRY;
	}
	@GetMapping(COUNTRY_URL+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH)
	public String  deleteCountry(@PathVariable(URL_ID) String countryCode,
			ModelMap model) {
		countryService.deleteCountry(countryCode);
		onLoads(model);
		return COUNTRY;
	}
	@GetMapping(EDI_COUNTRY_URL+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH)
	public String  editCountry(@PathVariable(URL_ID) String countryCode,
			ModelMap model) throws Exception {
		onLoads(model);
		CountryDTO countryDTO =	countryService.findCountry(countryCode);
		model.addAttribute(COUNTRY, countryDTO);
		return COUNTRY;
	}
	@PostMapping(COUNTRY_URL)
	public String saveCountry(@ModelAttribute(COUNTRY) @Valid CountryDTO countryDTO, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute(COUNTRIES, countryService.findAllCountry());
			return COUNTRY;
		}
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(countryDTO.getIsNew()));
		countryService.addCountry(countryDTO);
		return RIDIRECT.concat(COLON).concat(COUNTRY).concat(URL_ACTION);
	}
}
