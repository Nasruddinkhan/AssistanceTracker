/**
 * nasru
 * NeedyRefferedDao.java
 * Apr 18, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.NeedyReffered;

/**
 * @author nasru
 *
 */
public interface NeedyRefferedDao {

	/**
	 * @param needyReffered
	 */
	void saveNeedyRefferer(NeedyReffered needyReffered);

	/**
	 * @return
	 */
	List<NeedyReffered> findAllRefferer();

	/**
	 * @param needyReferId
	 * @return
	 */
	NeedyReffered editNeedyRefferer(Integer needyReferId);

	/**
	 * @param editNeedyRefferer
	 */
	void deleteNeedyRefferer(NeedyReffered editNeedyRefferer);

}
