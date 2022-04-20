package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {
  WishListService wishListService;

  public WishListController(WishListService wishListService) {
    this.wishListService = wishListService;
  }

  @GetMapping("/wish_form")
  public String wish_form() {
    return "wish_form";
  }
}
