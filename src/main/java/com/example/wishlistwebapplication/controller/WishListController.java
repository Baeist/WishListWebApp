package com.example.wishlistwebapplication.controller;

import com.example.wishlistwebapplication.model.WishList;
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

    @GetMapping("/wishlist/{username}")
    public String showAllWishlist(@PathVariable("username") String username, Model model) {
        // Arraylist<Wishlist> wishlist = wishListService.getWishlist(userID);
        model.addAttribute("username", username);
        model.addAttribute("wishlist", testWish());
        return "all_users_wishlist";
    }

    @GetMapping("/wishlist/{username}/{id}")
    public String showWishlist  (@PathVariable("username") String username, @PathVariable("id") int wishID,
                                 Model model){

        return "wishlist";
    }

    
    
    
    
    
    
    
    @GetMapping("/wishlist")
    public String wishlist(){
        return "findUser";
    }





    //todo Skal slette bruges kun til test
    public ArrayList<WishList> testWish() {
        ArrayList<WishList> list = new ArrayList<>();

        String desc = "asdads asdkjlads alkjsdalskjd a lskjdalds kjad lkjads lkjadslkj asdlkja dslkjasdl kjasdlk jadslkja sdlkjas lkdjads lkjsadlk jadslk jadslkjasdlkj aslkdja slkd jasld jaldskj alkjds";
        String desc2 = "asdads asdkjlads alkjsdalskjd a lskjdalds kjad lkjads lkjadslkj asdlkja dslkjasdl";

        WishList one = new WishList(1, "jule2022", desc, null);
        WishList two = new WishList(2,"jule2022", desc, null);
        WishList three = new WishList(3,"jule2022", desc2, null);
        WishList four = new WishList(4,"jule2022", desc, null);
        WishList five = new WishList(5,"jule2022", desc2, null);
        WishList six = new WishList(6,"jule2022", desc, null);
        WishList seven = new WishList(7,"jule2022", desc2, null);

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
