package com.fitclass.fitclass.infra.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "users")
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "name")
  private String name;

	@Column(name = "password")
	private String password;

  public User() {}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

}
