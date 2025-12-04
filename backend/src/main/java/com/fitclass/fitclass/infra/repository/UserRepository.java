package com.fitclass.fitclass.infra.repository;

import com.fitclass.fitclass.infra.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}
