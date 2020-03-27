package com.mypractice.spring.dao;

import com.mypractice.spring.model.User;

public interface UserDetailsDao {
  User findUserByUsername(String username);
}
