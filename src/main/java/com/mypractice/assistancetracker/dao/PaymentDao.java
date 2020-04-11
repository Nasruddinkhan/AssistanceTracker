/**
 * nasru
 * PaymentDao.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.dto.PaymentDTO;
import com.mypractice.assistancetracker.model.PaymentMode;

/**
 * @author nasru
 *
 */
public interface PaymentDao {

	/**
	 * @param string
	 * @return
	 */
	PaymentMode exitsByPaymentModeName(String payementModeName);

	/**
	 * @param mode
	 */
	void savePaymentMode(PaymentMode mode);

	/**
	 * @return
	 */
	List<PaymentMode> findAllPayment();

	/**
	 * @param paymentModeId
	 * @return
	 */
	PaymentMode editPaymentMode(String paymentModeId);

	/**
	 * @param paymentMode
	 */
	void deletePaymentMode(PaymentMode paymentMode);

}
