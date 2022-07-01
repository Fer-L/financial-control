package com.web.finances.api.dto;

import com.web.finances.domain.model.Company;
import com.web.finances.domain.model.Users;
import lombok.Data;

@Data
public class LoginDTO {
  private Long id;
  private String username;
  private String password;
  private String name;
}
