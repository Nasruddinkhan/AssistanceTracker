package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.AUTHORITIES;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.UNDER_LINE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = AUTHORITIES + SEQ)
	@SequenceGenerator(name = AUTHORITIES + SEQ, sequenceName = "AUTHORITIES_NAME"+UNDER_LINE + SEQ, allocationSize = MST_LEN_1,initialValue =  MST_LEN_1 )
	@Id
	@Column(name = "AUTHORITY_ID")
	private Integer authorityId;
	@Column(name = "AUTHORITY")
	private String authority;
	@ManyToMany(mappedBy = "authorities")
	private Set<User> user = new HashSet<>();
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * @return the authorityId
	 */
	public Integer getAuthorityId() {
		return authorityId;
	}

	/**
	 * @param authorityId the authorityId to set
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Set<User> user) {
		this.user = user;
	}

	

}
