package com.fitclass.fitclass.service;

import java.util.List;

import com.fitclass.fitclass.infra.entitys.User;
import com.fitclass.fitclass.infra.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository repository;

  public void save(User user) {
    repository.save(user);
  }

	public User findById(Integer id) {
		return repository.findById(id).orElseThrow(
			() -> new RuntimeException("usuario não encontrado")
		);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
