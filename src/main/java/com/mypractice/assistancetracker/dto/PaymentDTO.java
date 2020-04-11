/**
 * nasru
 * PaymentDTO.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.dto;

import static com.mypractice.assistancetracker.util.CommonUtils.FIELD_INVALID;
import static com.mypractice.assistancetracker.util.CommonUtils.INVALID_FIELD_SIZE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_6;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_ALLOW;
import static com.mypractice.assistancetracker.util.CommonUtils.ONLY_CHAR_PATTERN;
import static com.mypractice.assistancetracker.util.CommonUtils.START_DOLLAR;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author nasru
 *
 */
public class PaymentDTO {

	private String paymentModeId;
	@Pattern(regexp = ONLY_CHAR_PATTERN + START_DOLLAR, message = ONLY_CHAR_ALLOW)
	@Size(max =MST_LEN_100 , min =LEN_6 , message = INVALID_FIELD_SIZE)
	@NotBlank(message = FIELD_INVALID)
	//@Unique(service = PaymentModeService.class, fieldName = "paymentModeName", message = "{field.unique.violation}")
	private String paymentModeName;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;
	public String isNew;
	
	/**
	 * @return the isNew
	 */
	public String getIsNew() {
		return isNew;
	}
	/**
	 * @param isNew the isNew to set
	 */
	public void setIsNew(String isNew) {
		this.isNew = isNew;
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
	 * 
	 */
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param paymentModeId
	 * @param paymentModeName
	 */
	public PaymentDTO(String paymentModeId, String paymentModeName) {
		super();
		this.paymentModeId = paymentModeId;
		this.paymentModeName = paymentModeName;
	}

	/**
	 * @return the paymentModeId
	 */
	public String getPaymentModeId() {
		return paymentModeId;
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
	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(String paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentModeId=" + paymentModeId + ", PaymentModeName=" + paymentModeName + "]";
	}

}
