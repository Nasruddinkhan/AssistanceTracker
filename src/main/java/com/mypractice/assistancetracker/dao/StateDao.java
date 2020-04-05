/**
 * nasru
 * StateDao.java
 * Apr 4, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.State;

/**
 * @author nasru
 *
 */
public interface StateDao {

	/**
	 * @param state
	 */
	void addSate(State state);

	/**
	 * @return
	 */
	List<State> getStates();

	/**
	 * @param stateCode
	 * @return
	 */
	State findState(String stateCode);

}
