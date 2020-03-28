package com.mypractice.assistancetracker.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypractice.assistancetracker.dao.UserDetailsDao;
import com.mypractice.assistancetracker.model.User;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {
  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public User findUserByUsername(String username) {
    return sessionFactory.getCurrentSession().get(User.class, username);
  }
}
