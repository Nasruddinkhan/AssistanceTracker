/**
 * nasru
 * MemberServiceImpl.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.AuthoritiesDao;
import com.mypractice.assistancetracker.dao.CityDao;
import com.mypractice.assistancetracker.dao.CountryDao;
import com.mypractice.assistancetracker.dao.MemberDao;
import com.mypractice.assistancetracker.dao.PinCodeDao;
import com.mypractice.assistancetracker.dao.ProfessionDao;
import com.mypractice.assistancetracker.dao.StateDao;
import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.MemberDTO;
import com.mypractice.assistancetracker.dto.ProfessionDTO;
import com.mypractice.assistancetracker.model.Address;
import com.mypractice.assistancetracker.model.Authorities;
import com.mypractice.assistancetracker.model.City;
import com.mypractice.assistancetracker.model.Country;
import com.mypractice.assistancetracker.model.PinCode;
import com.mypractice.assistancetracker.model.Profession;
import com.mypractice.assistancetracker.model.State;
import com.mypractice.assistancetracker.model.User;
import com.mypractice.assistancetracker.service.MemberService;
import com.mypractice.assistancetracker.service.ProfessionService;
import static com.mypractice.assistancetracker.util.CommonUtils.PAGE_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.checkListNullOrEmpty;
import static com.mypractice.assistancetracker.util.CommonUtils.isEmptyObject;
/**
 * @author nasru
 *
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private ProfessionService professionService;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private StateDao stateDao;
	@Autowired
	private PinCodeDao pinCodeDao;
	@Autowired
	private ProfessionDao profesionDAO;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AuthoritiesDao authoriseDao;
	@Autowired
	@Override
	public List<CommonDropDown> getProfession() {
		// TODO Auto-generated method stub
		return professionService.getProfession().stream()
				.map((Function<? super ProfessionDTO, ? extends CommonDropDown>) obj -> {
					return new CommonDropDown(obj.getProfessionId().toString(), obj.getProfessionName());
				}).collect(Collectors.toList());
	}

	@Override
	public void saveMember(MemberDTO memberDTO,  String loginUser) {
		// TODO Auto-generated method stub
		System.out.println(memberDTO.getMemberId()+memberDTO.getAddressId());
		User user = new User();
		user.setUsername(memberDTO.getMemberId());
		user.setEmailId(memberDTO.getEmailId());
		user.setEnabled(true);
		Address address = new Address();
		address.setAddressId(memberDTO.getAddressId());
		address.setCountry(	countryDao.findByCountry(memberDTO.getCountry()));
		address.setCity(cityDao.findCity(memberDTO.getCity()));
		address.setState(stateDao.findState(memberDTO.getState()));
		address.setPinCode(pinCodeDao.findPinCode(memberDTO.getPinCode()));
		address.setAddress1(memberDTO.getAddress1());
		address.setAddress2(memberDTO.getAddress2());
		address.setStreet(memberDTO.getStreet());
		user.setAddress(address);
		user.setProfession(profesionDAO.editProfession(Integer.valueOf(memberDTO.getProfession())));
		Authorities authorities2 = authoriseDao.findRole("MEMBER_ROLE");
		Set<Authorities> authorities= new HashSet<>();
		if(isEmptyObject(authorities2)) { 
			authorities2 = new Authorities();
			authorities2.setAuthority("MEMBER_ROLE");
		} 
		authorities.add(authorities2);
		user.setAuthorities(authorities);
		user.setPassword( new BCryptPasswordEncoder().encode("Nasru@1992"));
		user.setFirstName(memberDTO.getFirstName());
		user.setLastName(memberDTO.getLastName());
		user.setContactNo(memberDTO.getContactNo());
		user.setCantactNo1(memberDTO.getCantactNo1());
		user.setNickName(memberDTO.getNickName());
		user.setActive(true);
		User loggedUser= memberDao.editMember(loginUser);
		user.setUsers(loggedUser);
		user.setCreateDateTime(memberDTO.getCreateDateTime());
		memberDao.saveMember(user);
	}
	@Override
	public List<MemberDTO> findAllMember(int pageNo, String logginUser) {
		// TODO Auto-generated method stub
		User logUser= memberDao.editMember(logginUser);
		List<MemberDTO> member= null;
		int startPos=0;
		startPos=(pageNo*PAGE_SIZE)-PAGE_SIZE;
		List<Object[]> user =  memberDao.findAllMember(startPos, logUser);
		member = user.stream().map((Function<? super Object[], ? extends MemberDTO>)obj->{
			MemberDTO   memberDTO= new MemberDTO();
			memberDTO.setMemberId(obj[0].toString());
			memberDTO.setEmailId(checkListNullOrEmpty( obj[1]).toString());
			memberDTO.setFirstName(checkListNullOrEmpty(obj[2]).toString());
			memberDTO.setLastName(checkListNullOrEmpty(obj[3]).toString());
			memberDTO.setContactNo(checkListNullOrEmpty(obj[4]).toString());
			memberDTO.setCantactNo1(checkListNullOrEmpty(obj[5]).toString());
			return memberDTO;
		}).collect(Collectors.toList());
		return member;
	}
	@Override
	public int getMemeberPageCount(String logginUser) {
		// TODO Auto-generated method stub
		User logUser= memberDao.editMember(logginUser);
		Long count=0l;
		int pageCoumypractice=0;
		try {
			count = memberDao.getMemeberPageCount(logUser);
			pageCoumypractice = (int) (count/(long) PAGE_SIZE);
			if(count%PAGE_SIZE!=0)
				pageCoumypractice++;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("MemberServiceImpl.getMemeberPageCount()");
		}
		return pageCoumypractice;
	}

	@Override
	public MemberDTO editMember(String userName) {
		// TODO Auto-generated method stub
		MemberDTO dto = new MemberDTO();
		User user = memberDao.editMember(userName);
		dto.setMemberId(user.getUsername());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setContactNo(user.getContactNo());
		dto.setCantactNo1(user.getCantactNo1());
		dto.setEmailId(user.getEmailId());
		Address address = user.getAddress();
		if(!isEmptyObject(address)) {
			dto.setAddressId(address.getAddressId());
			dto.setAddress1(address.getAddress1());
			dto.setAddress2(address.getAddress2());
			Country country = address.getCountry();
			dto.setCountry(country.getCountryCode());
			dto.setCountryName(country.getCountryName());
			City city = address.getCity();
			dto.setCity(city.getCityCode());
			dto.setCityName(city.getCityName());
			PinCode pincode = address.getPinCode();
			dto.setPinCode(pincode.getPinCode());
			State state = address.getState();
			dto.setState(state.getStateCode());
			dto.setStateName(state.getStateName());
			dto.setStreet(address.getStreet());
		}
		Profession profession =  user.getProfession();
		if(!isEmptyObject(profession)) {
			dto.setProfession(profession.getProfessionId().toString());
			dto.setProfessionName(profession.getProfessionName());
		}
		dto.setUpdateDateTime(user.getUpdateDateTime());
		dto.setCreateDateTime(user.getCreateDateTime());
		dto.setNickName(user.getNickName());
		return dto;
	}

	@Override
	public void deleteMember(String memberId) {
		// TODO Auto-generated method stub
	User user =	memberDao.editMember(memberId);
	user.setActive(false);
	memberDao.deleteMember(user);
	}

}
