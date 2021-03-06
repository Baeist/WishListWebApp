package com.example.wishlistwebapplication.service;

import com.example.wishlistwebapplication.model.Wish;
import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
  WishListRepository wishListRepository;

  public WishListService(WishListRepository wishListRepository) {
    this.wishListRepository = wishListRepository;
  }

  public List<WishList> findUserWishlist(String username) {
    return wishListRepository.findUserWishlist(username);
  }

  public List<Wish> findWishlistWishes (int wishlist_id) {
    return wishListRepository.findWishlistWishes(wishlist_id);
  }


  public void insertNewWishlistFromUser(String username, String name, String description){
    wishListRepository.insertNewWishlistFromUser(username, name, description);
  }

  public void insertNewWishIntoAList(int wishlistID, String wishName, String url, double price, String description){
    wishListRepository.insertNewWishIntoAList(wishlistID, wishName, url, price, description);
  }
}
