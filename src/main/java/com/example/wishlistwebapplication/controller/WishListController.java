package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.Wish;
import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class WishListController {

    @Autowired
    WishListService wishListService;

    @GetMapping("/wish_form")
    public String wish_form() {
        return "wish_form";
    }

    @GetMapping("/wishlist/{username}")
    public String showAllWishlist(@PathVariable("username") String username, Model model) {
        // Arraylist<Wishlist> wishlist = wishListService.getWishlist(userID);
        model.addAttribute("username", username);
        model.addAttribute("wishlist", wishListService.findUserWishlist(username));

        return "/all_users_wishlist";
    }

    @PostMapping("/wishlist/{username}")
    public String createWishlist(
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 HttpSession session) {
        String username = (String)session.getAttribute("username");
        wishListService.insertNewWishlistFromUser(username, name, description);

        return "redirect:/wishlist/" + username;
    }

    @GetMapping("/wishlist/{username}/{id}")
    public String showWishlist(@PathVariable("username") String username, @PathVariable("id") int wishlistID,
                               Model model) {

        model.addAttribute("username", username);
        model.addAttribute("wishes", wishListService.findWishlistWishes(wishlistID));
        return "wishlist";
    }
        @GetMapping("/wishlist")
        public String wishlist () {
            return "findUser";
        }

        @GetMapping("/makewish")
        public String makeWish(){
        return "makewish";
        }

        @PostMapping("/makewish")
        public String createWish(@RequestParam("wishname") String wishName,
                                 @RequestParam("url") String url, @RequestParam("price") double price,
                                 @RequestParam("description") String description, HttpSession session){

        wishListService.insertNewWishIntoAList(wishName, url, price, description);

        return "redirect:/wishlist/" + session.getAttribute("username"); // skal returnere til den rigtige ønskeliste ikek den generelle
        }



}
