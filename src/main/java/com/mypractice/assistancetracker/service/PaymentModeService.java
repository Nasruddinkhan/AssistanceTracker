/**
 * nasru
 * PaymentModeService.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.PaymentDTO;
import com.mypractice.assistancetracker.validation.FieldValueExists;

/**
 * @author nasru
 *
 */
public interface PaymentModeService extends FieldValueExists{

	/**
	 * @param paymentDTO
	 * @throws Exception 
	 */
	void savePaymentMode(PaymentDTO paymentDTO) throws Exception;
	/**
	 * @return
	 */
	List<PaymentDTO> findAllPayment();
	/**
	 * @param paymentModeId
	 * @return
	 * @throws Exception 
	 */
	PaymentDTO editPaymentMode(String paymentModeId) throws Exception;
	/**
	 * @param paymentModeId
	 */
	void deletePaymentMode(String paymentModeId);
}
