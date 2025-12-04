package com.fitclass.fitclass.entity;

import com.fitclass.fitclass.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Table(name = "users")
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "login", nullable = false, unique = true)
  private String login;

  @Column(name = "password")
  private String password;

  public User() {}

  public User(UserDTO usuario) {
    BeanUtils.copyProperties(usuario, this);
  }
}
