/**
 * nasru
 * MstCodeServiceImpl.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import static com.mypractice.assistancetracker.util.CommonUtils.checkListNullOrEmpty;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mypractice.assistancetracker.dao.MstCodeDao;
import com.mypractice.assistancetracker.model.MstCode;
import com.mypractice.assistancetracker.service.MstCodeService;
import com.mypractice.assistancetracker.util.CommonUtils;
import com.mypractice.assistancetracker.util.ErrorConstant;
/**
 * @author nasru
 *
 */
@Service("mstCodeService")
@Transactional
public class MstCodeServiceImpl implements MstCodeService {
	@Autowired
	private MstCodeDao mstCodeDao;

	@Override
	public List<MstCode> getAllMaster() {
		// TODO Auto-generated method stub
		List<MstCode> mstDropDown = mstCodeDao.getAllMaster(CommonUtils.MASTER.toUpperCase());
		if(checkListNullOrEmpty(mstDropDown))
			throw new RuntimeException(ErrorConstant.HTTP_STATUS_404);
		return mstDropDown;
	}

}
