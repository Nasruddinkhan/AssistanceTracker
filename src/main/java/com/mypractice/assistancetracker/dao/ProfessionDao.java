/**
 * nasru
 * ProfessionDao.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.Profession;

/**
 * @author nasru
 *
 */
public interface ProfessionDao {

	/**
	 * @param profession
	 */
	void saveProfession(Profession profession);

	/**
	 * @return
	 */
	List<Profession> getProfession();

	/**
	 * @param professionId
	 * @return
	 */
	Profession editProfession(Integer professionId);

	/**
	 * @param editProfession
	 */
	void deleteProfession(Profession deleteProfession);

}
