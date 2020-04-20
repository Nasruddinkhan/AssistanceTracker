package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.FIFTEEN_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER_MODE_PREFIX;
import static com.mypractice.assistancetracker.util.CommonUtils.PROFESSION_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.SequenceId_Generator;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.mypractice.assistancetracker.util.CommonUtils;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@Column(name = "USERNAME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = MEMBER_MODE_PREFIX + SEQ)
	@GenericGenerator(name = MEMBER_MODE_PREFIX + SEQ, strategy = SequenceId_Generator, parameters = {
			@Parameter(name = MEMBER_MODE_PREFIX + SEQ, value = MEMBER_MODE_PREFIX + SEQ),
			@Parameter(name = INCREMENT_PARAM, value = LEN_1),
			@Parameter(name = VALUE_PREFIX_PARAMETER, value = MEMBER_MODE_PREFIX),
			@Parameter(name = NUMBER_FORMAT_PARAMETER, value = FIFTEEN_DIGIT) })
	private String username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = CommonUtils.ADDRESS_ID)
	private Address address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = PROFESSION_ID)
	private Profession profession;
	@Column(name = CommonUtils.FIRST_NAME, length = CommonUtils.LEN_50)
	private String firstName; 
	@Column(name = CommonUtils.LAST_NAME,length =CommonUtils.MST_LEN_20  )
	private String lastName;  
	@Column(name =CommonUtils.NICK_NAME, length =CommonUtils.MST_LEN_20  )
	private String nickName;  	
	@Column(name = CommonUtils.CONTACT_NO, length = CommonUtils.LEN_10)
	private String contactNo; 
	@Column(name =CommonUtils.ALTERNATE_NO,  length = CommonUtils.LEN_10 )
	private String cantactNo1; 
	@Column(name = CommonUtils.EMAIL_ID, length = CommonUtils.MST_LEN_100)
	private String emailId;
	@Version
	@Column(name = CommonUtils.VERSION)
	private int version;
	@Column(name = ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
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
	 * @return the version
	 */
	public int getVersion() {
		return version;
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
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
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
