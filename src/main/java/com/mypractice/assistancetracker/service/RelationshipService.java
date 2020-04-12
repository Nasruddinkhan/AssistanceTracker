/**
 * nasru
 * RelationshipService.java
 * Apr 12, 2020
 */
package com.mypractice.assistancetracker.service;

import java.util.List;

import com.mypractice.assistancetracker.dto.RelationshipDto;

/**
 * @author nasru
 *
 */
public interface RelationshipService {

	/**
	 * @param relationshipDto
	 * @throws Exception 
	 */
	void saveRelationship(RelationshipDto relationshipDto) throws Exception;

	/**
	 * @return
	 * @throws Exception 
	 */
	List<RelationshipDto> findAll();

	/**
	 * @param relationshipId
	 * @return
	 * @throws Exception 
	 */
	RelationshipDto editRelationship(String relationshipId) throws Exception;

	/**
	 * @param paymentModeId
	 */
	void deleteRelationship(String relationshipId);

}
