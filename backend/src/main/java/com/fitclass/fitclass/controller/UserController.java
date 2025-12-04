package com.fitclass.fitclass.controller;

import com.fitclass.fitclass.dto.UserDTO;
import com.fitclass.fitclass.entity.User;
import com.fitclass.fitclass.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

  private final UserService service;

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody UserDTO user) {
    service.save(user);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  @Operation(description = "busca todos os usuarios e retonar uma lista")
  @ApiResponse(responseCode = "200", description = "retonar a lista de usuarios")
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
