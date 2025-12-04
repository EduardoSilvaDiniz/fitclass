package com.fitclass.fitclass.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {
  // TODO implementar retonar o usuario e liberações (authorities)
  private String token;

  public AcessDTO(String token) {
    this.token = token;
  }

  public AcessDTO() {}
}
