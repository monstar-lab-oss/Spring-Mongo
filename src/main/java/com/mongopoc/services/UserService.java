package com.mongopoc.services;

import com.mongopoc.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mongopoc.models.User;
import java.util.List;

/** Provide user related functionality. */
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public String getFullName(String id) {
    var user = userRepository
          .findById(id)
          .orElseThrow();
    return user.getFirstName() + " " + user.getLastName();
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(User newUser, String id) {
    return userRepository.findById(id)
            .map(user -> {
              user.setFirstName(newUser.getFirstName());
              user.setLastName(newUser.getLastName());
              return userRepository.save(user);
            })
            .orElseGet(() -> {
              newUser.setId(id);
              return userRepository.save(newUser);
            });
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}
