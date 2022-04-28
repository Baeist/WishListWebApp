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
        return "all_users_wishlist";
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


    //todo skal slettes:når vi for databasen op at kører
    public ArrayList<Wish> testWishDisplay(){
        ArrayList<Wish> wishes = new ArrayList<>();


        String itemName = "Iphone";
        double price = 9999.99;
        String url = "https://www.apple.com/dk/";
        String description =    "9 kr./måned efter den gratis prøveperiode. Ét abonnement pr. gruppe med Familiedeling. "
            +   "Ét abonnement pr. gruppe med Familiedeling.";

        Wish wish1 = new Wish(itemName, price, url, description);

        for (int i = 0; i < 15; i++) {
            wishes.add(wish1);
        }

        return wishes;
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

        return list;
    }
}
