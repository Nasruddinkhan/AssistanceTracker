/**
 * nasru
 * NeedyReffered.java
 * Apr 18, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_10;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFERED;
import static com.mypractice.assistancetracker.util.CommonUtils.REFFERER;
import static com.mypractice.assistancetracker.util.CommonUtils.REFFERER_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.REFFERER_MOBILE_NUMBER;
import static com.mypractice.assistancetracker.util.CommonUtils.REFFERER_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.RELATIONSHIP_MODE_PREFIX;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author nasru
 *
 */
@Entity
@Table(name = NEEDY_REFERED+UNDER_LINE+MASTER)
public class NeedyReffered {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = REFFERER + SEQ)
	@SequenceGenerator(name = REFFERER + SEQ, sequenceName = REFFERER+UNDER_LINE + SEQ , allocationSize = MST_LEN_1,initialValue =  MST_LEN_1)
	@Column(name = REFFERER_ID)
	private Integer reffererId;
	@Column(name = REFFERER_NAME, length = MST_LEN_100)
	private String 	reffereName;
	@Column(name = REFFERER_MOBILE_NUMBER,  length = LEN_10)
	private String 	refrerMobileNumber;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = RELATIONSHIP_MODE_PREFIX + URL_ID)
	private Relationship relationship;
	@Column(name = ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	/**
	 * @return the reffererId
	 */
	public Integer getReffererId() {
		return reffererId;
	}
	/**
	 * @return the reffereName
	 */
	public String getReffereName() {
		return reffereName;
	}
	/**
	 * @return the refrerMobileNumber
	 */
	public String getRefrerMobileNumber() {
		return refrerMobileNumber;
	}
	/**
	 * @return the relationship
	 */
	public Relationship getRelationship() {
		return relationship;
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
	 * @param reffererId the reffererId to set
	 */
	public void setReffererId(Integer reffererId) {
		this.reffererId = reffererId;
	}
	/**
	 * @param reffereName the reffereName to set
	 */
	public void setReffereName(String reffereName) {
		this.reffereName = reffereName;
	}
	/**
	 * @param refrerMobileNumber the refrerMobileNumber to set
	 */
	public void setRefrerMobileNumber(String refrerMobileNumber) {
		this.refrerMobileNumber = refrerMobileNumber;
	}
	/**
	 * @param relationship the relationship to set
	 */
	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
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
	
}
