package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.MEMBER_MODE_PREFIX;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.SequenceId_Generator;
import static com.mypractice.assistancetracker.util.CommonUtils.FIFTEEN_DIGIT;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
}
