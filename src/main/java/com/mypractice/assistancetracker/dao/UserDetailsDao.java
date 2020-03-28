package com.mypractice.assistancetracker.dao;

import com.mypractice.assistancetracker.model.User;

public interface UserDetailsDao {
  User findUserByUsername(String username);
}
