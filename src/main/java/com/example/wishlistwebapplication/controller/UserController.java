package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
  public String sendNewUserInfo(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    userService.createUser(user);

    model.addAttribute("username", username);
    model.addAttribute("wishlist", testWish());

    return "all_users_wishlist";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String succesfulLogIn(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
    boolean checkPassword = false;

    model.addAttribute("username", username);
    model.addAttribute("wishlist", testWish());

    checkPassword = userService.checkUserPasswordForLogIn(username, password);

    if(checkPassword) {
      return "all_users_wishlist";
    }
    return "redirect:/login"; // skal have fejl til bruger måske?

  }

  @GetMapping("/findUser")
  public String findUserWishlist() {
    return "findUser";
  }

  @PostMapping("/findUser")
  public String findUserWishlist(String username, Model model) {
    model.addAttribute("wishlists", userService.findUserWishlist("Tom"));
    return "redirect:/findUser";
  }


  //todo Skal slette:når vi har fået databasen op: bruges kun til test
  public ArrayList<WishList> testWish() {
    ArrayList<WishList> list = new ArrayList<>();

    String desc = "asdads asdkjlads alkjsdalskjd a lskjdalds kjad lkjads lkjadslkj asdlkja dslkjasdl kjasdlk jadslkja sdlkjas lkdjads lkjsadlk jadslk jadslkjasdlkj aslkdja slkd jasld jaldskj alkjds";
    String desc2 = "asdads asdkjlads alkjsdalskjd a lskjdalds kjad lkjads lkjadslkj asdlkja dslkjasdl";

    WishList one = new WishList(1, "jule2022", desc);
    WishList two = new WishList(2,"jule2022", desc);
    WishList three = new WishList(3,"jule2022", desc2);
    WishList four = new WishList(4,"jule2022", desc);
    WishList five = new WishList(5,"jule2022", desc2);
    WishList six = new WishList(6,"jule2022", desc);
    WishList seven = new WishList(7,"jule2022", desc2);

    list.add(one);
    list.add(two);
    list.add(three);
    list.add(four);
    list.add(five);
    list.add(six);
    list.add(seven);
    //list.add(eight);

    return list;
  }
}
