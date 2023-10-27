package com.mongopoc.web;

import java.util.List;
import com.mongopoc.services.UserService;
import com.mongopoc.models.User;
import com.mongopoc.web.dto.UserDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RestController
@RequiredArgsConstructor
class UserController {

  private final UserService userService;

  @GetMapping("/users")
  List<UserDto> all(Model model) {

    List<User> users = userService.findAll();
    return users.stream().map(user ->
      {return new UserDto(user);}).toList();
  }

  @PostMapping("/users")
  public UserDto createUser(@RequestBody User user) {
      User userCreated = userService.createUser(user);
      return new UserDto(userCreated);
  }
}
