package com.web.finances.repository;

import com.web.finances.model.Users;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserRepository 
  extends JpaRepositoryImplementation
  <Users, Long>
{
  public Users findByUsername(
    String username);
}
