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

import com.mypractice.assistancetracker.dao.CityDao;
import com.mypractice.assistancetracker.dao.StateDao;
import com.mypractice.assistancetracker.dto.CityDTO;
import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.StateDto;
import com.mypractice.assistancetracker.model.City;
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
	@Autowired
	private StateDao stateDao;
	@Autowired
	private CityDao cityDao;

	@Override
	public List<CommonDropDown> getState() {
		List<CommonDropDown> states = null;
		// TODO Auto-generated method stub
		List<StateDto> stateDto = stateService.getStates();
		if (!checkListNullOrEmpty(stateDto)) {
			states = stateDto.stream().map((Function<? super StateDto, ? extends CommonDropDown>) obj -> {
				return new CommonDropDown(obj.getStateCode(), obj.getStateName() + " " + obj.getCountryName());
			}).collect(Collectors.toList());
		}
		return states;
	}

	@Override
	public void saveCity(CityDTO cityDto) {
		// TODO Auto-generated method stub
		City city = new City();
		city.setCityCode(cityDto.getCityCode());
		city.setCityName(cityDto.getCityName());
		city.setCityAlphaCOde(cityDto.getCityAlphaCOde());
		city.setState(stateDao.findState(cityDto.getState()));
		cityDao.saveCity(city);
	}

	@Override
	public List<CityDTO> findAllCity() {
		// TODO Auto-generated method stub
		List<CityDTO> cityDto = null;
		List<City> cityList = cityDao.findAllCity();
		if (!checkListNullOrEmpty(cityList)) {
			cityDto = cityList.stream().map((Function<? super City, ? extends CityDTO>) obj -> {
				CityDTO cityDTO = new CityDTO();
				cityDTO.setCityCode(obj.getCityCode());
				cityDTO.setCityName(obj.getCityName());
				cityDTO.setCityAlphaCOde(obj.getCityAlphaCOde());
				cityDTO.setState(obj.getState().getStateCode());
				cityDTO.setStateName(
						obj.getState().getStateName() + " - " + obj.getState().getCountry().getCountryName());
				return cityDTO;
			}).collect(Collectors.toList());
		}
		return cityDto;
	}

	@Override
	public CityDTO findCity(String cityCode) {
		// TODO Auto-generated method stub
		City city = cityDao.findCity(cityCode);
		CityDTO cityDTO = new CityDTO();
		cityDTO.setCityCode(city.getCityCode());
		cityDTO.setCityName(city.getCityName());
		cityDTO.setCityAlphaCOde(city.getCityAlphaCOde());
		cityDTO.setState(city.getState().getStateCode());
		return cityDTO;
	}

	@Override
	public void deleteCity(String cityCode) {
		// TODO Auto-generated method stub
		cityDao.deleteCity(cityDao.findCity(cityCode));
	}

}
