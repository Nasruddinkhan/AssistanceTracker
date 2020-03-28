/**
 * nasru
 * MstCodeDao.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.dao;
import java.util.List;
import com.mypractice.assistancetracker.model.MstCode;
/**
 * @author nasru
 *
 */
public interface MstCodeDao {
	List<MstCode> getAllMaster(String codeType);
}
