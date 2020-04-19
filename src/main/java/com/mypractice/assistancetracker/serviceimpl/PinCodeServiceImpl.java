/**
 * nasru
 * PinCodeServiceImpl.java
 * Apr 9, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;
import static com.mypractice.assistancetracker.util.CommonUtils.STR_FALSE;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.CityDao;
import com.mypractice.assistancetracker.dao.PinCodeDao;
import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.PinCodeDTO;
import com.mypractice.assistancetracker.model.City;
import com.mypractice.assistancetracker.model.PinCode;
import com.mypractice.assistancetracker.service.PinCodeService;

/**
 * @author nasru
 *
 */
@Service("pinCodeService")
@Transactional
public class PinCodeServiceImpl implements PinCodeService {
	@Autowired
	private CityDao cityDao;
	@Autowired
	private PinCodeDao pinCodeDao;
	@Override
	public List<CommonDropDown> getCity() {
		// TODO Auto-generated method stub
		List<CommonDropDown> list=null;
		list = cityDao.findAllCity().stream().map((Function<? super City, ? extends CommonDropDown>) obj->{
			return new CommonDropDown(obj.getCityCode(), obj.getCityName()+"-"+obj.getState().getStateName()+"-"+obj.getState().getCountry().getCountryName());
		}).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<PinCodeDTO> findPinCode() {
		// TODO Auto-generated method stub
		List<PinCodeDTO> pinCodeDTOs= null;
		List<PinCode> pinCodes=	pinCodeDao.findPinCode();
		pinCodeDTOs = pinCodes.stream().map((Function<? super PinCode, ? extends PinCodeDTO>)obj->{
			return new PinCodeDTO(obj.getPinCode(), obj.getCity().getCityCode(), null, obj.getCity().getCityName()+"-"+ obj.getCity().getState().getStateName());
		}).collect(Collectors.toList());
		return pinCodeDTOs;
	}

	@Override
	public void savePincode(PinCodeDTO pinCodeDTO) {
		// TODO Auto-generated method stub
		PinCode pinCode = new PinCode();
		pinCode.setPinCode(pinCodeDTO.getPinCode());
		pinCode.setCity(cityDao.findCity(pinCodeDTO.getCityName()));
		pinCodeDao.savePincode(pinCode);
	}

	@Override
	public PinCodeDTO findPinCode(String pinCode) {
		// TODO Auto-generated method stub
		PinCode pincode = pinCodeDao.findPinCode(pinCode);
		PinCodeDTO  codeDTO = new PinCodeDTO();
		codeDTO.setIsNew(STR_FALSE);
		codeDTO.setPinCode(pincode.getPinCode());
		codeDTO.setCityName(pincode.getCity().getCityCode());
		return codeDTO;
	}

	@Override
	public void deletePinCode(String pinCode) {
		// TODO Auto-generated method stub
		pinCodeDao.deletePinCode( pinCodeDao.findPinCode(pinCode));
	}

	@Override
	public String getPincode(String cityId) {
		// TODO Auto-generated method stub
		City city =  cityDao.findCity(cityId);
		try {
			return 	pinCodeDao.getPincode(city);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new EntityNotFoundException(e.getMessage());
		}
	}

}
