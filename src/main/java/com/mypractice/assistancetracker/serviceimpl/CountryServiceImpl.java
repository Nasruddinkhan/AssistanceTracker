/**
 * nasru
 * CountryServiceImpl.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import static com.mypractice.assistancetracker.util.CommonUtils.checkListNullOrEmpty;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.CountryDao;
import com.mypractice.assistancetracker.dto.CountryDTO;
import com.mypractice.assistancetracker.model.Country;
import com.mypractice.assistancetracker.service.CountryService;

/**
 * @author nasru
 *
 */
@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryDao countryDao;

	@Override
	public List<CountryDTO> findAllCountry() {
		// TODO Auto-generated method stub
		List<CountryDTO> countryList = null;
		List<Country> countryDAOList = countryDao.findAllCountry();
		if (!checkListNullOrEmpty(countryDAOList)) {
			countryList = countryDAOList.stream().map((Function<? super Country, ? extends CountryDTO>) obj -> {
				return new CountryDTO(obj.getCountryCode(), obj.getCountryName(), obj.getAlpha2Code(),
						String.valueOf(obj.getNumbericCode()));
			}).collect(Collectors.toList());
		}
		return countryList;
	}

	@Override
	public void addCountry(CountryDTO countryDto) throws Exception {
		// TODO Auto-generated method stub
		Country country = new Country();
		BeanUtils.copyProperties(country, countryDto);
		countryDao.addCountry(country);
	}

	@Override
	public Integer deleteCountry(String countryCode) {
		return countryDao.deleteCountryByCode(countryCode);
	}

	@Override
	public CountryDTO findCountry(String countryCode) throws Exception{
		// TODO Auto-generated method stub
		Country country = countryDao.findByCountry(countryCode);
		CountryDTO countryDTO = new  CountryDTO();
		BeanUtils.copyProperties(countryDTO, country);
		return countryDTO;
	}
}
