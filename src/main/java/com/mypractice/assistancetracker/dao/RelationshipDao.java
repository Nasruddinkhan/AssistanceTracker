/**
 * nasru
 * RelationshipDao.java
 * Apr 12, 2020
 */
package com.mypractice.assistancetracker.dao;

import java.util.List;

import com.mypractice.assistancetracker.model.Relationship;

/**
 * @author nasru
 *
 */
public interface RelationshipDao {

	/**
	 * @param relationship
	 */
	void saveRelationship(Relationship relationship);

	/**
	 * @return
	 */
	List<Relationship> findAll();

	/**
	 * @param relationshipId
	 * @return
	 */
	Relationship editRelationship(String relationshipId);

	/**
	 * @param editRelationship
	 */
	void deleteRelationship(Relationship editRelationship);

}
