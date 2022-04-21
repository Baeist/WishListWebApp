package com.example.wishlistwebapplication.service;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser(User user) {
    userRepository.createUser(user);
  }

  public void findUser(String username) {
    userRepository.findUser(username);
  }


  public User haveUsernameWantPassword(String username){
  return userRepository.haveUserNameGetUserInfo(username);
  }

  public boolean checkUserPasswordForLogIn(String userName, String password){

    User user = userRepository.haveUserNameGetUserInfo(userName);

    if(password.equals(user.getPassword()))
      return true;

    return false;
  }





}
