package com.example.wishlistwebapplication.model;

import java.util.List;

public class User {
  private String username;
  private String password;
  private int userID;

  public User(){}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(int userID, String username, String password) {
    this.userID = userID;
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  public int getUserID() {
    return userID;
  }
}
