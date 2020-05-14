/**
 * nasru
 * CommonServiceImpl.java
 * Apr 19, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.MemberDTO;
import com.mypractice.assistancetracker.service.CityService;
import com.mypractice.assistancetracker.service.CommonService;
import com.mypractice.assistancetracker.service.MemberService;
import com.mypractice.assistancetracker.service.PinCodeService;
import com.mypractice.assistancetracker.service.StateService;

/**
 * @author nasru
 *
 */
@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {
@Autowired
private StateService stateService;
@Autowired
private CityService cityService;
@Autowired
private PinCodeService pinCodeService;
@Autowired
private MemberService memberService;
	@Override
	public List<CommonDropDown> getStates(String countryId) {
		// TODO Auto-generated method stub
		List<CommonDropDown> stateDropDownBean =  stateService.getStates(countryId);
		return stateDropDownBean;
	}
	@Override
	public List<CommonDropDown> getCities(String stateId) {
		// TODO Auto-generated method stub
		List<CommonDropDown> citiesDropDownBean = cityService.getCities(stateId);
		return citiesDropDownBean;
	}
	@Override
	public String getPincode(String cityId) {
		// TODO Auto-generated method stub
		String pinCode = pinCodeService.getPincode(cityId);
		return pinCode;
	}
	@Override
	public MemberDTO getMember(String memberID) {
		// TODO Auto-generated method stub
		return memberService.editMember(memberID);
	}

}
