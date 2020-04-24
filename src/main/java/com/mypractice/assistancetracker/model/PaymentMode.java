/**
 * nasru
 * PaymentMode.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENT_MODE;
import static com.mypractice.assistancetracker.util.CommonUtils.PAYMENT_MODE_PREFIX;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.SequenceId_Generator;
import static com.mypractice.assistancetracker.util.CommonUtils.TEN_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.mypractice.assistancetracker.service.PaymentModeService;
import com.mypractice.assistancetracker.validation.Unique;
/**
 * @author nasru
 *
 */
@Table(name =PAYMENT_MODE )
@Entity
public class PaymentMode {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  PAYMENT_MODE_PREFIX+SEQ)
	@GenericGenerator(
			name = PAYMENT_MODE_PREFIX+SEQ, 
			strategy =SequenceId_Generator, 
			parameters = {
					@Parameter(name = INCREMENT_PARAM, value =LEN_1),
					@Parameter(name = VALUE_PREFIX_PARAMETER, value = PAYMENT_MODE_PREFIX),
					@Parameter(name = NUMBER_FORMAT_PARAMETER, value = TEN_DIGIT) })
	//@SequenceGenerator(name=PAYMENT_MODE_PREFIX+SEQ, sequenceName = PAYMENT_MODE_PREFIX+NAME+SEQ)
	@Column(name = PAYMENT_MODE_PREFIX+URL_ID, length = MST_LEN_50)
	private String paymentModeId;
	@Column(name = PAYMENT_MODE_PREFIX+NAME, length = MST_LEN_100)
	@Unique(service = PaymentModeService.class, fieldName = "paymentModeName", message = "{field.unique.violation}")
	private String paymentModeName;
	@Column(name=ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name=EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	/**
	 * @return the paymentModeId
	 */
	public String getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @return the createDateTime
	 */
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	/**
	 * @return the updateDateTime
	 */
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(String paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the paymentModeName
	 */
	public String getPaymentModeName() {
		return paymentModeName;
	}

	/**
	 * @param paymentModeName the paymentModeName to set
	 */
	public void setPaymentModeName(String paymentModeName) {
		this.paymentModeName = paymentModeName;
	}

}
