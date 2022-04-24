package com.example.wishlistwebapplication.model;

import java.util.List;

public class WishList {

  private int id;
  private String name;
  private String description;
  private List<Wish> wishList;


  public WishList(int id, String name, String description, List<Wish> wishList){
    this.id = id;
    this.name = name;
    this.description = description;
    this.wishList = wishList;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Wish> getWishList() {
    return wishList;
  }

  public void setWishList(List<Wish> wishList) {
    this.wishList = wishList;
  }
}
