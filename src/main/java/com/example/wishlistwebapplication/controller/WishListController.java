package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.repository.UserRepository;
import com.example.wishlistwebapplication.service.UserService;
import com.example.wishlistwebapplication.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class WishListController {


    @Autowired
    private UserService userService;
    WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping("/wish_form")
    public String wish_form() {
        return "wish_form";
    }


    //@GetMapping("/wishlist/user/{userID}")
    @GetMapping("/wishlist/user/{userID}")
    public String showAllWishlist(@PathVariable("userID") int userID, Model model) {
        //User user = userService.getUserFromID(userID)
        // Arraylist<Wishlist> wishlist = wishListService.getWishlist(userID);
        model.addAttribute("username", "Tobias");
        model.addAttribute("wishList", testWish());
        return "userWishlist";
    }

    // todo Skal slette bruges kun til test
    public ArrayList<WishList> testWish() {
        ArrayList<WishList> list = new ArrayList<>();

        String desc = "asdads asdkjlads alkjsdalskjd a lskjdalds kjad lkjads lkjadslkj asdlkja dslkjasdl kjasdlk jadslkja sdlkjas lkdjads lkjsadlk jadslk jadslkjasdlkj aslkdja slkd jasld jaldskj alkjds";

        WishList one = new WishList("jule2022", desc, null);
        WishList two = new WishList("jule2022", desc, null);
        WishList three = new WishList("jule2022", desc, null);
        WishList four = new WishList("jule2022", desc, null);
        WishList five = new WishList("jule2022", desc, null);
        WishList six = new WishList("jule2022", desc, null);
        WishList seven = new WishList("jule2022", desc, null);
        //WishList eight = new WishList("jule2022", desc, null);

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
