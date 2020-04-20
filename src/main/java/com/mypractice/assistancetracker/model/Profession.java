/**
 * nasru
 * Profession.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.COUNTRY;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.MASTER;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author nasru
 *
 */
@Entity
@Table(name =PROFESSION+UNDER_LINE+MASTER )
public class Profession {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PROFESSION + SEQ)
	@SequenceGenerator(name = PROFESSION + SEQ, sequenceName = PROFESSION_NAME+UNDER_LINE + SEQ, allocationSize = MST_LEN_1,initialValue =  MST_LEN_1 )
	@Column(name = PROFESSION_ID)
	private Integer professionId;
	@Column(name = PROFESSION_NAME, length = MST_LEN_100)
	private String professionName;
	@Column(name = ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy =PROFESSION, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	private List<User> users; 
	
	
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the professionId
	 */
	public Integer getProfessionId() {
		return professionId;
	}
	/**
	 * @return the professionName
	 */
	public String getProfessionName() {
		return professionName;
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
	 * @param professionId the professionId to set
	 */
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	/**
	 * @param professionName the professionName to set
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
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
