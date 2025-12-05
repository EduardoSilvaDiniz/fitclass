package com.fitclass.fitclass.controller;

import com.fitclass.fitclass.entity.User;
import com.fitclass.fitclass.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recurso")
@RequiredArgsConstructor
@CrossOrigin
public class UserControllerTwo {

  private final UserService service;

  @GetMapping
  @Operation(description = "busca todos os usuarios e retonar uma lista")
  @ApiResponse(responseCode = "200", description = "retonar a lista de usuarios")
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
