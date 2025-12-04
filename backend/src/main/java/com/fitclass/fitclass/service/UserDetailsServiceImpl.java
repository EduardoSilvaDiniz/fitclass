package com.fitclass.fitclass.service;

import com.fitclass.fitclass.entity.User;
import com.fitclass.fitclass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =
        userRepository
            .findByLogin(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("Usúario não encontrando " + username));
    return UserDetailsImpl.build(user);
  }
}
