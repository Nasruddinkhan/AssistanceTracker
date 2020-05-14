/**
 * nasru
 * CommonAjaxCall.java
 * Apr 19, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COMMON;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.GET;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.CITY_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.STATE_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.MemberDTO;
import com.mypractice.assistancetracker.service.CommonService;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping(SLASH + COMMON)
public class CommonAjaxCall {
	@Autowired
	private CommonService commonService;
	@GetMapping(SLASH+GET+ SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+COUNTRY_URL)
	public ResponseEntity<List<CommonDropDown>> getAllStates(@PathVariable(URL_ID) String countryId){
		return new ResponseEntity<List<CommonDropDown>>(commonService.getStates(countryId), HttpStatus.OK);
	}
	@GetMapping(SLASH+GET+ SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+STATE_URL)
	public ResponseEntity<List<CommonDropDown>> getAllCities(@PathVariable(URL_ID) String stateId){
		return new ResponseEntity<List<CommonDropDown>>(commonService.getCities(stateId), HttpStatus.OK);
	}
	@GetMapping(SLASH+GET+ SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+CITY_URL)
	public ResponseEntity<String> getPincode(@PathVariable(URL_ID) String cityId){
		return new ResponseEntity<String>(commonService.getPincode(cityId), HttpStatus.OK);
	}

	@GetMapping(SLASH+GET+ SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+MEMBER)
	public ResponseEntity<MemberDTO> getMembers(@PathVariable(URL_ID) String memberID){
		return new ResponseEntity<MemberDTO>(commonService.getMember(memberID), HttpStatus.OK);
	}
}
