package com.example.wishlistwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

  @GetMapping("/")
  public String index(HttpSession session) {

    if(session.getAttribute("username") != null)
    return "redirect:/wishlist/" + session.getAttribute("username");

    session.setAttribute("isLoggedIn", false);
    System.out.println(session.getAttribute("isLoggedIn"));
    return "index";
  }
}
