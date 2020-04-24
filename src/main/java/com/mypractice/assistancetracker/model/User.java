package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.ALTERNATE_NO;
import static com.mypractice.assistancetracker.util.CommonUtils.AUTHORITY_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.CONTACT_NO;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.EMAIL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.ENABLED;
import static com.mypractice.assistancetracker.util.CommonUtils.FIFTEEN_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.FIRST_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_10;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER_MODE_PREFIX;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_20;
import static com.mypractice.assistancetracker.util.CommonUtils.NICK_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.PASSWORD;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.SequenceId_Generator;
import static com.mypractice.assistancetracker.util.CommonUtils.USERNAME;
import static com.mypractice.assistancetracker.util.CommonUtils.USERS;
import static com.mypractice.assistancetracker.util.CommonUtils.USER_ROLE;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.mypractice.assistancetracker.util.CommonUtils;
@Entity
@Table(name = USERS)
public class User {
	@Id
	@Column(name =USERNAME, length = LEN_50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = MEMBER_MODE_PREFIX + SEQ)
	@GenericGenerator(name = MEMBER_MODE_PREFIX + SEQ, strategy = SequenceId_Generator, parameters = {
			@Parameter(name = MEMBER_MODE_PREFIX + SEQ, value = MEMBER_MODE_PREFIX + SEQ),
			@Parameter(name = INCREMENT_PARAM, value = LEN_1),
			@Parameter(name = VALUE_PREFIX_PARAMETER, value = MEMBER_MODE_PREFIX),
			@Parameter(name = NUMBER_FORMAT_PARAMETER, value = FIFTEEN_DIGIT) })
	private String username;
	@Column(name = PASSWORD, nullable = false)
	private String password;

	@Column(name = ENABLED, nullable = false)
	private boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = USER_ROLE, 
        joinColumns = { @JoinColumn(name =USERNAME) }, 
        inverseJoinColumns = { @JoinColumn(name = AUTHORITY_ID) }
    )
    Set<Authorities> authorities = null;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = CommonUtils.ADDRESS_ID)
	private Address address ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = PROFESSION_ID)
	private Profession profession;
	@Column(name = FIRST_NAME, length = LEN_50) 
	private String firstName; 
	@Column(name = CommonUtils.LAST_NAME,length =MST_LEN_20  ) 
	private String lastName;  
	@Column(name =NICK_NAME, length =MST_LEN_20  )
	private String nickName;  	
	@Column(name = CONTACT_NO, length =LEN_10)
	private String contactNo; 
	@Column(name =ALTERNATE_NO,  length =LEN_10 )
	private String cantactNo1; 
	@Column(name = EMAIL_ID, length = MST_LEN_100)
	private String emailId;
	
	@Column(name = ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	@Column(name = CommonUtils.IS_ACTIVE, columnDefinition = "boolean default true", nullable = false)
	private boolean isActive;
	
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the profession
	 */
	public Profession getProfession() {
		return profession;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @return the cantactNo1
	 */
	public String getCantactNo1() {
		return cantactNo1;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
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
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @param cantactNo1 the cantactNo1 to set
	 */
	public void setCantactNo1(String cantactNo1) {
		this.cantactNo1 = cantactNo1;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
