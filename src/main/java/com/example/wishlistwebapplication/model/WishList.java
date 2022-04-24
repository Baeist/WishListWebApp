package com.example.wishlistwebapplication.model;



public class WishList {

  private int wishlist_ID;
  private String wishlist_name;
  private String description;

  public WishList(int wishlist_ID, String wishlist_name, String description){
    this.wishlist_ID = wishlist_ID;
    this.wishlist_name = wishlist_name;
    this.description = description;
  }

  public int getWishlist_ID() {
    return wishlist_ID;
  }

  public void setWishlist_ID(int wishlist_ID) {
    this.wishlist_ID = wishlist_ID;
  }
  
  public String getWishlist_name() {
    return wishlist_name;
  }

  public void setWishlist_name(String wishlist_name) {
    this.wishlist_name = wishlist_name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "WishList{" +
        "wishlist_ID=" + wishlist_ID +
        ", wishlist_name='" + wishlist_name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
