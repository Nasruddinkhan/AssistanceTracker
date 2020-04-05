/**
 * nasru
 * StateServiceImpl.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.CountryDao;
import com.mypractice.assistancetracker.dao.StateDao;
import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.StateDto;
import com.mypractice.assistancetracker.model.Country;
import com.mypractice.assistancetracker.model.State;
import com.mypractice.assistancetracker.service.StateService;
import static com.mypractice.assistancetracker.util.CommonUtils.checkListNullOrEmpty;
/**
 * @author nasru
 *
 */
@Service("stateService")
@Transactional
public class StateServiceImpl implements StateService {
	@Autowired
	private StateDao stateDao;
	@Autowired
	private CountryDao countryDao;
	@Override
	public List<CommonDropDown> getCountries() {
		// TODO Auto-generated method stub
		return countryDao.findAllCountry().stream().map((Function<? super Country, ? extends CommonDropDown>)obj->{
			CommonDropDown commonDropDown = new CommonDropDown();
			commonDropDown.setKey(obj.getCountryCode());
			commonDropDown.setValue(obj.getCountryName());
			return commonDropDown;
		}).collect(Collectors.toList());
	}
	@Override
	public void addSate(StateDto stateDto)  {
		State state = new State();
		state.setStateCode(stateDto.getStateCode());
		state.setStateName(stateDto.getStateName());
		state.setAlpha2Code(stateDto.getAlpha2Code());
		state.setCountry(countryDao.findByCountry(stateDto.getCountry()));
		stateDao.addSate(state);
	}
	@Override
	public List<StateDto> getStates() {
		// TODO Auto-generated method stub
		List<StateDto> stateDtos = null;
		List<State> states=	stateDao.getStates();
		if(!checkListNullOrEmpty(states)){
			stateDtos =	states.stream().map((Function<? super State, ? extends StateDto>) obj->{
				StateDto dto = new StateDto();
				dto.setAlpha2Code(obj.getAlpha2Code());
				dto.setStateName(obj.getStateName());
				dto.setStateCode(obj.getStateCode());
				dto.setCountry(obj.getCountry().getCountryCode());
				dto.setCountryName(obj.getCountry().getCountryName());
				return dto;
			}).collect(Collectors.toList());
		}
		return stateDtos;
	}
	@Override
	public StateDto findState(String stateCode) {
		// TODO Auto-generated method stub
		StateDto stateDto= null;
		State state =  stateDao.findState(stateCode);
		stateDto = new StateDto();
		stateDto.setStateCode(state.getStateCode());
		stateDto.setStateName(state.getStateName());
		stateDto.setCountry(state.getCountry().getCountryCode());
		stateDto.setAlpha2Code(state.getAlpha2Code());
		stateDto.setCountryName(state.getCountry().getCountryName());
		return stateDto;
	}

}
