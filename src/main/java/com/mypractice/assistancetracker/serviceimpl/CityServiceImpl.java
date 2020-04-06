/**
 * nasru
 * CityServiceImpl.java
 * Apr 6, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import static com.mypractice.assistancetracker.util.CommonUtils.checkListNullOrEmpty;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.StateDto;
import com.mypractice.assistancetracker.service.CityService;
import com.mypractice.assistancetracker.service.StateService;

/**
 * @author nasru
 *
 */
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
	private StateService stateService;
	@Override
	public List<CommonDropDown> getState() {
		List<CommonDropDown> states = null;
		// TODO Auto-generated method stub
		List<StateDto> stateDto=	stateService.getStates();
		if(!checkListNullOrEmpty(stateDto)){
			states = stateDto.stream().map((Function<? super StateDto, ? extends CommonDropDown>)obj->{
				return new CommonDropDown(  obj.getStateCode(), obj.getStateName()+" "+obj.getCountryName() );
			}).collect(Collectors.toList());
		}
		return states;
	}

}
