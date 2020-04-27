/**
 * nasru
 * MemberService.java
 * Apr 20, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.MemberDTO;

/**
 * @author nasru
 *
 */
public interface MemberService {
	/**
	 * @return
	 */
	List<CommonDropDown> getProfession();

	/**
	 * @param memberDTO
	 * @param loginUser 
	 */
	void saveMember(MemberDTO memberDTO, String loginUser);

	/**
	 * @param pageNo
	 * @param logginUser 
	 * @return
	 */
	List<MemberDTO> findAllMember(int pageNo, String logginUser);

	/**
	 * @param logginUser 
	 * @return
	 */
	int getMemeberPageCount(String logginUser);

	/**
	 * @param userName
	 * @return
	 */
	MemberDTO editMember(String userName);

	/**
	 * @param memberId
	 */
	void deleteMember(String memberId);

}
