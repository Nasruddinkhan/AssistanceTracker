/**
 * nasru
 * PaymentModeServiceImpl.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.PaymentDao;
import com.mypractice.assistancetracker.dto.PaymentDTO;
import com.mypractice.assistancetracker.model.PaymentMode;
import com.mypractice.assistancetracker.service.PaymentModeService;

/**
 * @author nasru
 *
 */
@Service("paymentModeService")
@Transactional
public class PaymentModeServiceImpl implements PaymentModeService {
	@Autowired
	private PaymentDao paymentDao;
	@Override
	public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return Objects.isNull(paymentDao.exitsByPaymentModeName(value.toString()));
	}
	@Override
	public void savePaymentMode(PaymentDTO paymentDTO) throws Exception {
		// TODO Auto-generated method stub
		PaymentMode mode = new PaymentMode();
		BeanUtils.copyProperties(mode,paymentDTO);
		paymentDao.savePaymentMode(mode);
	}
	@Override
	public List<PaymentDTO> findAllPayment() {
		 List<PaymentDTO> dtos=null;
		// TODO Auto-generated method stub
		List<PaymentMode>  paymentMode = paymentDao.findAllPayment();
		dtos =paymentMode.stream().map((Function<? super PaymentMode, ? extends PaymentDTO>)obj->{
			PaymentDTO dto = new PaymentDTO();
			dto.setPaymentModeId(obj.getPaymentModeId());
			dto.setPaymentModeName(obj.getPaymentModeName());
			dto.setCreateDateTime(obj.getCreateDateTime());
			dto.setUpdateDateTime(obj.getUpdateDateTime());
			return dto;
		}).collect(Collectors.toList());
		return dtos;
	}
	@Override
	public PaymentDTO editPaymentMode(String paymentModeId) throws Exception {
		// TODO Auto-generated method stub
		PaymentDTO dto = new PaymentDTO();
		PaymentMode paymentMode =  paymentDao.editPaymentMode(paymentModeId);
				BeanUtils.copyProperties(dto,paymentMode);
		return dto;
	}
	@Override
	public void deletePaymentMode(String paymentModeId) {
		// TODO Auto-generated method stub
		PaymentMode paymentMode =  paymentDao.editPaymentMode(paymentModeId);
		paymentDao.deletePaymentMode(paymentMode);
	}
}
