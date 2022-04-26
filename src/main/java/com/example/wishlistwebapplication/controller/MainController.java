package com.example.wishlistwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String index(@CookieValue(value = "username", defaultValue = "") String username) {
    return "index";
  }
}
