package com.example.wishlistwebapplication.model;

public class Wish {
  private String itemName;
  private double price;
  private String url;
  private String description;

  public Wish(String itemName, double price, String url, String description) {
    this.itemName = itemName;
    this.price = price;
    this.url = url;
    this.description = description;
  }

  public String getItemName() {
    return itemName;
  }

  public double getPrice() {
    return price;
  }

  public String getUrl() {
    return url;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "Wish{" +
        "itemName='" + itemName + '\'' +
        ", price=" + price +
        ", url='" + url + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
