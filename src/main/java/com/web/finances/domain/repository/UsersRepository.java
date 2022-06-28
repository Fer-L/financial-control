package com.web.finances.domain.repository;

import com.web.finances.domain.model.Users;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UsersRepository
    extends JpaRepositoryImplementation<Users, Long> {
  public Users findByUsername(
      String username);
}
