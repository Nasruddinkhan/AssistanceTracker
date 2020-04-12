/**
 * nasru
 * RelationshipDaoImpl.java
 * Apr 12, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.RelationshipDao;
import com.mypractice.assistancetracker.model.Relationship;

/**
 * @author nasru
 *
 */
@Repository("relationshipDao")
public class RelationshipDaoImpl implements RelationshipDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveRelationship(Relationship relationship) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(relationship);
	}
	@Override
	public List<Relationship> findAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Relationship> criteriaQuery = criteriaBuilder.createQuery(Relationship.class);
		Root<Relationship> root = criteriaQuery.from(Relationship.class);
		criteriaQuery.select(root);
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}
	@Override
	public Relationship editRelationship(String relationshipId) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().load(Relationship.class, relationshipId);
	}
	@Override
	public void deleteRelationship(Relationship editRelationship) {
		// TODO Auto-generated method stub
		  sessionFactory.getCurrentSession().delete(editRelationship);
	}
}
