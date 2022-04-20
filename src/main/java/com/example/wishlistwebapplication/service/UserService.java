package com.example.wishlistwebapplication.service;

import com.example.wishlistwebapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


}
