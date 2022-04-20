package com.example.wishlistwebapplication.service;

import com.example.wishlistwebapplication.repository.WishListRepository;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
  WishListRepository wishListRepository;

  public WishListService(WishListRepository wishListRepository) {
    this.wishListRepository = wishListRepository;
  }
}
