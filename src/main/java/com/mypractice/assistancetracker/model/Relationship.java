/**
 * nasru
 * Relationship.java
 * Apr 12, 2020
 */
package com.mypractice.assistancetracker.model;

import static com.mypractice.assistancetracker.util.CommonUtils.ADD_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT_DATE;
import static com.mypractice.assistancetracker.util.CommonUtils.LEN_1;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_100;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.NEEDY_REFERED;
import static com.mypractice.assistancetracker.util.CommonUtils.RELATIONSHIP_MODE_PREFIX;
import static com.mypractice.assistancetracker.util.CommonUtils.SEQ;
import static com.mypractice.assistancetracker.util.CommonUtils.SequenceId_Generator;
import static com.mypractice.assistancetracker.util.CommonUtils.TEN_DIGIT;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER;
import static com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;
import static com.mypractice.assistancetracker.util.CommonUtils.RELATIONSHIP;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author nasru
 *
 */
@Entity
@Table(name = RELATIONSHIP)
public class Relationship {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = RELATIONSHIP_MODE_PREFIX + SEQ)
	@GenericGenerator(name = RELATIONSHIP_MODE_PREFIX + SEQ, strategy = SequenceId_Generator, parameters = {
			@Parameter(name = RELATIONSHIP_MODE_PREFIX + SEQ, value = RELATIONSHIP_MODE_PREFIX + SEQ),
			@Parameter(name = INCREMENT_PARAM, value = LEN_1),
			@Parameter(name = VALUE_PREFIX_PARAMETER, value = RELATIONSHIP_MODE_PREFIX),
			@Parameter(name = NUMBER_FORMAT_PARAMETER, value = TEN_DIGIT) })
	@Column(name = RELATIONSHIP_MODE_PREFIX + URL_ID, length = MST_LEN_50)
	private String relationshipId;
	@Column(name = RELATIONSHIP_MODE_PREFIX + NAME, length = MST_LEN_100)
	private String relationshipName;
	@Column(name = ADD_DATE)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = EDIT_DATE)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	@OneToMany(mappedBy =RELATIONSHIP, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<NeedyReffered> needReffereds;
	
	/**
	 * @return the needReffereds
	 */
	public Set<NeedyReffered> getNeedReffereds() {
		return needReffereds;
	}

	/**
	 * @param needReffereds the needReffereds to set
	 */
	public void setNeedReffereds(Set<NeedyReffered> needReffereds) {
		this.needReffereds = needReffereds;
	}

	/**
	 * @return the relationshipId
	 */
	public String getRelationshipId() {
		return relationshipId;
	}

	/**
	 * @return the relationshipName
	 */
	public String getRelationshipName() {
		return relationshipName;
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
	 * @param relationshipId the relationshipId to set
	 */
	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}

	/**
	 * @param relationshipName the relationshipName to set
	 */
	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
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
