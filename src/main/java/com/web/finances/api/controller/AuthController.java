package com.web.finances.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

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
    String username = login.getUsername();
    String password = login.getPassword();
    Users user = rep.findByUsername(username);

    if (user == null) {
      return ResponseEntity.status(
          HttpStatus.NOT_FOUND).body("O usuário não está cadastrado!");
    }

    if (user != null) {
      if (!password.equals(user.getPassword().toString())) {
        return ResponseEntity.status(
            HttpStatus.NOT_FOUND).body("Senha incorreta!");
      }
    }

    String jwt = TokenAuthenticationService.gerarJWTToken(username);
    return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getUsername()));
  }
}