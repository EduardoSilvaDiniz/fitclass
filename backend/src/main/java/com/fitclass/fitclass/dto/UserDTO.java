package com.fitclass.fitclass.dto;

import com.fitclass.fitclass.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class UserDTO {
  private Long id;
  private String name;
  private String email;
  private String login;
  private String password;

  public UserDTO(User user) {
    BeanUtils.copyProperties(user, this);
  }

  public UserDTO() {}
}
