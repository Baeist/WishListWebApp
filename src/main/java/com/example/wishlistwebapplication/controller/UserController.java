package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/createUser")
  public String createUser() {
    return "createUser";
  }

  @PostMapping("/createUser")
  public void sendNewUserInfo(@ModelAttribute User user) {
    userService.createUser(user);
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/findUser")
  public String findUser() {
    return "findUser";
  }
}
