/**
 * nasru
 * MemberServiceImpl.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

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
import com.mypractice.assistancetracker.model.User;
import com.mypractice.assistancetracker.service.MemberService;
import com.mypractice.assistancetracker.service.ProfessionService;
import com.mypractice.assistancetracker.util.CommonUtils;

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
	public void saveMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(memberDTO.getMemberId());
		user.setEmailId(memberDTO.getEmailId());
		user.setEnabled(true);
		Address address = new Address();
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
		Set<Authorities> authorities= user.getAuthorities();
		if(authorities2 == null) {
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
		memberDao.saveMember(user);
	}
	@Override
	public List<MemberDTO> findAllMember(int pageNo) {
		// TODO Auto-generated method stub
		List<MemberDTO> member= null;
		int startPos=0;
		startPos=(pageNo*CommonUtils.PAGE_SIZE)-CommonUtils.PAGE_SIZE;
		List<Object[]> user =  memberDao.findAllMember(startPos);
		member = user.stream().map((Function<? super Object[], ? extends MemberDTO>)obj->{
			MemberDTO   memberDTO= new MemberDTO();
			memberDTO.setMemberId(obj[0].toString());
			memberDTO.setEmailId(CommonUtils.checkListNullOrEmpty( obj[1]).toString());
			memberDTO.setFirstName(CommonUtils.checkListNullOrEmpty(obj[2]).toString());
			memberDTO.setLastName(CommonUtils.checkListNullOrEmpty(obj[3]).toString());
			memberDTO.setContactNo(CommonUtils.checkListNullOrEmpty(obj[4]).toString());
			memberDTO.setCantactNo1(CommonUtils.checkListNullOrEmpty(obj[5]).toString());
			return memberDTO;
		}).collect(Collectors.toList());
		return member;
	}
	@Override
	public int getMemeberPageCount() {
		// TODO Auto-generated method stub
		Long count=0l;
		int pageCoumypractice=0;
		try {
			count = memberDao.getMemeberPageCount();
			pageCoumypractice = (int) (count/(long) CommonUtils.PAGE_SIZE);
			if(count%CommonUtils.PAGE_SIZE!=0)
				pageCoumypractice++;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("MemberServiceImpl.getMemeberPageCount()");
		}
		return pageCoumypractice;
	}

}
