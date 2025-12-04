package com.fitclass.fitclass.service;

import com.fitclass.fitclass.dto.UserDTO;
import com.fitclass.fitclass.entity.User;
import com.fitclass.fitclass.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository repository;
  @Autowired private PasswordEncoder passwordEncoder;

  public void save(UserDTO userDto) {
    User user = new User(userDto);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    repository.save(user);
  }

  public User findById(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("usuario não encontrado"));
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
