/**
 * nasru
 * ReasonDao.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.Reason;

/**
 * @author nasru
 *
 */
public interface ReasonDao {

	/**
	 * @param reason
	 */
	void saveReason(Reason reason);

	/**
	 * @return
	 */
	List<Reason> getReasons();

	/**
	 * @param reasonId
	 * @return
	 */
	Reason editReason(Integer reasonId);

	/**
	 * @param editReason
	 */
	void deleteReason(Reason editReason);

}
