package com.web.finances.domain.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.web.finances.domain.model.Users;
import com.web.finances.domain.repository.UserRepository;

@Component
public class CustomUserDetailsService 
  implements UserDetailsService {

  @Autowired
  private UserRepository rep;

  @Override
  public UserDetails loadUserByUsername(
      String username) 
      throws UsernameNotFoundException 
  {
    Users user = rep.findByUsername(username);
    return new User(
      user.getUsername(), 
      user.getPassword(), 
      Collections.emptyList()
    );
  }

}
