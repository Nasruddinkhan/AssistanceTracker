/**
 * nasru
 * MstCodeDaoImpl.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.MstCodeDao;
import com.mypractice.assistancetracker.model.MstCode;
import com.mypractice.assistancetracker.util.CommonUtils;
import com.mypractice.assistancetracker.util.QueryConstant;

/**
 * @author nasru
 *
 */
@Repository("mstCodeDao")
public class MstCodeDaoImpl implements MstCodeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstCode> getAllMaster(String codeType) {
		// TODO Auto-generated method stub 
		return sessionFactory.getCurrentSession()
							 .createQuery(QueryConstant.MST_COMMON_DROPDOWN.concat(CommonUtils.MST_CODE_TYPE), MstCode.class)
							 .setParameter(CommonUtils.MST_CODE_TYPE, codeType).getResultList();
	}

}
