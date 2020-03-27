/**
 * nasru
 * MstCode.java
 * Mar 28, 2020
 */
package com.mypractice.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.mypractice.spring.util.CommonUtils;
/**
 * @author nasru
 *
 */
@Entity
@Table(name = CommonUtils.MST_CODE_APPLICATION)
public class MstCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1228221670147727187L;
	@Id
	@Column(name = CommonUtils.MST_CODE_ID, length = CommonUtils.MST_LEN_20)
	private String codeID;
	@Column(name = CommonUtils.MST_CODE_NAME, length = CommonUtils.MST_LEN_50)
	private String codeName;
	@Column(name = CommonUtils.MST_CODE_TYPE, length = CommonUtils.MST_LEN_15)
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
