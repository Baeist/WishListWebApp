package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  public void sendNewUserInfo(@RequestParam("username") String username, @RequestParam("password") String password) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    userService.createUser(user);

  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String succesfulLogIn(@RequestParam("username") String username, @RequestParam("password") String password){
    boolean checkPassword = false;
    checkPassword = userService.checkUserPasswordForLogIn(username, password);

    if(checkPassword)
      return "redirect:/"; // skal ændres til korrekt url, returnere til landing for testing

    return "/login"; // skal have fejl til bruger måske?

  }

  @GetMapping("/findUser")
  public String findUser() {
    return "findUser";
  }

  @PostMapping("/findUser")
  public String findUser(@RequestParam("username") String username) {
    userService.findUser(username);
    return "redirect:/findUser";
  }
}
