/**
 * nasru
 * ProfessionService.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.ProfessionDTO;

/**
 * @author nasru
 *
 */
public interface ProfessionService {

	/**
	 * @param professionDTO
	 * @throws Exception 
	 */
	public void saveProfession(ProfessionDTO professionDTO);

	/**
	 * @return
	 */
	public List<ProfessionDTO> getProfession();

	/**
	 * @param relationshipId
	 * @return
	 * @throws Exception 
	 */
	public ProfessionDTO editProfession(Integer professionId) throws Exception;

	/**
	 * @param professionId
	 */
	public void deleteProfession(Integer professionId); 

}
