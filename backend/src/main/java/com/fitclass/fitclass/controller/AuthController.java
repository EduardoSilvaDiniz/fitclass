package com.fitclass.fitclass.controller;

import com.fitclass.fitclass.dto.AcessDTO;
import com.fitclass.fitclass.dto.AuthenticationDTO;
import com.fitclass.fitclass.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
// TODO Alerta isso é perigoso em produção
@CrossOrigin(origins = "*")
public class AuthController {
  @Autowired private AuthService authService;

  @PostMapping(value = "/login")
  public ResponseEntity<AcessDTO> login(@RequestBody AuthenticationDTO auth) {
    return ResponseEntity.ok(authService.login(auth));
  }
}
