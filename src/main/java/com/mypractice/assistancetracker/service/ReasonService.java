/**
 * nasru
 * ReasonService.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.ReasonDto;

/**
 * @author nasru
 *
 */
public interface ReasonService {

	/**
	 * @param resoDto
	 */
	void saveReason(ReasonDto resoDto);

	/**
	 * @return
	 */
	List<ReasonDto> getReasons();

	/**
	 * @param reasonId
	 * @return
	 */
	ReasonDto editReason(Integer reasonId) throws Exception;

	/**
	 * @param reasonId
	 */
	void deleteReason(Integer reasonId);

}
