package com.fitclass.fitclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class AuthenticationDTO {
  private String username;
  private String password;

  public AuthenticationDTO() {}
}
