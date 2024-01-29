package dev.lzzgabriel.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lzzgabriel.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  
  @GetMapping
  public ResponseEntity<User> findAll() {
    var user = new User(1l, "Marcos", "marcos@hotmal", "99999", "123");
    return ResponseEntity.ok().body(user);
  }

}
