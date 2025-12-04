package com.fitclass.fitclass.service;

import com.fitclass.fitclass.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;

  static UserDetailsImpl build(User user) {
    return new UserDetailsImpl(
        user.getId(),
        user.getName(),
        user.getLogin(), // username
        user.getEmail(),
        user.getPassword(), // <--- AQUI, finalmente
        new ArrayList<>());
  }

  public UserDetailsImpl(
      Long id,
      String name,
      String username,
      String email,
      String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public @Nullable String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
