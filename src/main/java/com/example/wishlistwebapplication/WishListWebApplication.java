package com.example.wishlistwebapplication;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.model.Wish;
import com.example.wishlistwebapplication.repository.UserRepository;
import com.example.wishlistwebapplication.repository.WishListRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WishListWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishListWebApplication.class, args);
    }

}
