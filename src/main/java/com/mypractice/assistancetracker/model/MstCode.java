/**
 * nasru
 * MstCode.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_CODE_APPLICATION;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_CODE_TYPE;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_CODE_NAME;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_CODE_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_15;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_50;
import static com.mypractice.assistancetracker.util.CommonUtils.MST_LEN_20;
/**
 * @author nasru
 *
 */
@Entity
@Table(name = MST_CODE_APPLICATION)
public class MstCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1228221670147727187L;
	@Id
	@Column(name = MST_CODE_ID, length = MST_LEN_20)
	private String codeID;
	@Column(name = MST_CODE_NAME, length = MST_LEN_50)
	private String codeName;
	@Column(name = MST_CODE_TYPE, length = MST_LEN_15)
	private String codeType;
	/**
	 * @return the codeID
	 */
	public String getCodeID() {
		return codeID;
	}
	/**
	 * @return the codeName
	 */
	public String getCodeName() {
		return codeName;
	}
	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * @param codeID the codeID to set
	 */
	public void setCodeID(String codeID) {
		this.codeID = codeID;
	}
	/**
	 * @param codeName the codeName to set
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
}
