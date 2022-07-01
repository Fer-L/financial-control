package com.web.finances.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.web.finances.api.dto.JwtResponse;
import com.web.finances.api.dto.LoginDTO;
import com.web.finances.domain.model.Users;
import com.web.finances.domain.repository.UsersRepository;
import com.web.finances.domain.security.TokenAuthenticationService;

@RestController
@RequestMapping("/login")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  private UsersRepository rep;

  @PostMapping
  public ResponseEntity<Object> autenticarUsuario(@RequestBody LoginDTO login) {
    String name = login.getName();
    String username = login.getUsername();
    if ( name == null) {
      Authentication authentication = authenticationManager
              .authenticate(new UsernamePasswordAuthenticationToken(username, login.getPassword()));
      Users user = rep.findByUsername(username);
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = TokenAuthenticationService.gerarJWTToken(username);
      return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getUsername()));
    }
    else {
      String encrypted_password = encoder.encode(login.getPassword());

      Users user = new Users();
      user.setName(name);
      user.setPassword(encrypted_password);
      user.setUsername(username);
      rep.save(user);

      return new ResponseEntity<>("Usuário criado", HttpStatus.CREATED);
    }
  }
}