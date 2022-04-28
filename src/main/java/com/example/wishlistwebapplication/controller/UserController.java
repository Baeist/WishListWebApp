package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
  public String sendNewUserInfo(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model, HttpSession session) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    userService.createUser(user);

    model.addAttribute("username", username);

    session.setAttribute("username", username);
    session.setAttribute("isLoggedIn", true);

    return "redirect:/wishlist/" + session.getAttribute("username");
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String succesfulLogIn(@RequestParam("username") String username,
                               @RequestParam("password") String password, Model model, HttpSession session){
    boolean checkPassword = false;

    model.addAttribute("username", username);

    checkPassword = userService.checkUserPasswordForLogIn(username, password);

    if(checkPassword) {
      session.setAttribute("username", username);
      session.setAttribute("isLoggedIn", true);
      return "redirect:/wishlist/" + session.getAttribute("username");
    }


    return "redirect:/login"; // skal have fejl til bruger måske?

  }

  @GetMapping("/findUser")
  public String findUser() {
    return "findUser";
  }

  @PostMapping("/findUser")
  public String searchForUser(@RequestParam("user_name") String username){

    User user = userService.haveUsernameWantPassword(username);

    if(user != null) {

    return "redirect:/wishlist/" + username;
    }

    return "findUser";
  }
}
