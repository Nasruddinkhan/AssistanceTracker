/**
 * nasru
 * ResonServiceImpl.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.ReasonDao;
import com.mypractice.assistancetracker.dto.ReasonDto;
import com.mypractice.assistancetracker.model.Reason;
import com.mypractice.assistancetracker.service.ReasonService;

/**
 * @author nasru
 *
 */
@Service("reasonService")
@Transactional
public class ResonServiceImpl implements ReasonService {
@Autowired
private ReasonDao reasonDao;
	@Override
	public void saveReason(ReasonDto resoDto) {
		// TODO Auto-generated method stub
		Reason reason = new Reason();
		reason.setCreateDateTime(resoDto.getCreateDateTime());
		reason.setUpdateDateTime(resoDto.getUpdateDateTime());
		reason.setReasonName(resoDto.getReasonName());
		reason.setReasonId(resoDto.getReasonId());
		reasonDao.saveReason(reason);
	}
	@Override
	public List<ReasonDto> getReasons() {
		// TODO Auto-generated method stub
		List<ReasonDto>  dtos = null;
		dtos= reasonDao.getReasons().stream().map((Function<? super Reason, ? extends ReasonDto>)obj->{
			ReasonDto dto = new  ReasonDto();
			dto.setCreateDateTime(obj.getCreateDateTime());
			dto.setUpdateDateTime(obj.getUpdateDateTime());
			dto.setReasonName(obj.getReasonName());
			dto.setReasonId(obj.getReasonId());
			return dto;
			
		}).collect(Collectors.toList());
		return dtos;
	}
	@Override
	public ReasonDto editReason(Integer reasonId) throws Exception {
		// TODO Auto-generated method stub
		ReasonDto reasonDto = new ReasonDto();
		Reason reason = reasonDao.editReason(reasonId);
		BeanUtils.copyProperties(reasonDto, reason);
		return reasonDto;
	}
	@Override
	public void deleteReason(Integer reasonId) {
		// TODO Auto-generated method stub
		reasonDao.deleteReason(reasonDao.editReason(reasonId));
	}

}
