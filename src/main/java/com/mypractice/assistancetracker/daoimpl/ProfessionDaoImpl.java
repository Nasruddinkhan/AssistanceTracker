/**
 * nasru
 * ProfessionDaoImpl.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.ProfessionDao;
import com.mypractice.assistancetracker.model.Profession;

/**
 * @author nasru
 *
 */
@Repository("professionDao")
public class ProfessionDaoImpl implements ProfessionDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveProfession(Profession profession) {
		// TODO Auto-generated method stub
		System.out.println(	profession.getProfessionId()+" "+profession.getProfessionName());
		sessionFactory.getCurrentSession().saveOrUpdate(profession);
	}
	@Override
	public List<Profession> getProfession() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Profession> criteriaQuery = criteriaBuilder.createQuery(Profession.class);
		Root<Profession> root = criteriaQuery.from(Profession.class);
		criteriaQuery.select(root);
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}
	@Override
	public Profession editProfession(Integer professionId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(Profession.class, professionId);
	}
	@Override
	public void deleteProfession(Profession deleteProfession) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(deleteProfession);
	}

}
