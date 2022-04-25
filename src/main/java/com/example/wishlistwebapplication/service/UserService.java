package com.example.wishlistwebapplication.service;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.model.Wish;
import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser(User user) {
    userRepository.createUser(user);
  }

  public List<WishList> findUserWishlist(String username) {
    return userRepository.findUserWishlist(username);
  }

  public List<Wish> findWishlistWishes (int wishlist_id) {
    return userRepository.findWishlistWishes(wishlist_id);
  }


  public User haveUsernameWantPassword(String username){
  return userRepository.haveUserNameGetUserInfo(username);
  }

  public boolean checkUserPasswordForLogIn(String userName, String password){

    User user = userRepository.haveUserNameGetUserInfo(userName);

    if(user == null)
      return false;

    if(password.equals(user.getPassword()))
      return true;

    return false;
  }





}
