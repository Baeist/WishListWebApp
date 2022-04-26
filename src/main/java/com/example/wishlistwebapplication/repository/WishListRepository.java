package com.example.wishlistwebapplication.repository;

import com.example.wishlistwebapplication.model.Wish;
import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishListRepository {

  public List<WishList> findUserWishlist(String username) {
    try {
      Connection connection = ConnectionManager.getConnection();
      final String SQL_QUERY = "SELECT wishlist_id, wishlist_name, wishlist_description FROM wishlist WHERE username = ? ORDER BY wishlist_id";
      PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
      ps.setString(1, username);
      List<WishList> listOfWishlists = new ArrayList<>();
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        int wishlist_id = resultSet.getInt("wishlist_id");
        String wishlist_name = resultSet.getString("wishlist_name");
        String wishlist_description = resultSet.getString("wishlist_description");
        listOfWishlists.add(new WishList(wishlist_id, wishlist_name, wishlist_description));
      }
      return listOfWishlists;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Wish> findWishlistWishes(int wishlist_id) {
    try {
      var connection = ConnectionManager.getConnection();
      final String SQL_QUERY = "SELECT * FROM wishes WHERE wishlist_id = ?";
      PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
      ps.setInt(1, wishlist_id);
      List<Wish> listOfWishes = new ArrayList<>();
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        String itemName = resultSet.getString("item_name");
        double price = resultSet.getInt("price_dkk");
        String url = resultSet.getString("url");
        String description = resultSet.getString("description");
        listOfWishes.add(new Wish(itemName, price, url, description));
      }
      return listOfWishes;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  /*
  public WishListRepository() {
    setConnection();
  }


  public void setConnection() {
    try {
      connection = ConnectionManager.getConnection();

    } catch (Exception e) {
      System.out.println("Did not connect to database" + e);
    }

  }
  public ArrayList<Wish> getAllWishes() {
    ArrayList<Wish> wishList = new ArrayList<>();

    try {

      Statement statement = connection.createStatement();
      final String SQL_QUERY = "SELECT * FROM wishes";
      ResultSet rs = statement.executeQuery(SQL_QUERY);


      while (rs.next()) {
        int ID = rs.getInt(1);
        int userID = rs.getInt(2);
        String itemName = rs.getString(3);
        double price = rs.getDouble(4);
        String url = rs.getString(5);
        String description = rs.getString(6);
        wishList.add(new Wish(ID, userID, itemName,price, url, description));

      }

      statement.close();
    } catch (
        SQLException e) {
      System.out.println("Could not create connection");
      e.printStackTrace();
    }
    return wishList;
  }

  public ArrayList<Wish> getWishesForUser(User user) {
    ArrayList<Wish> wishList = new ArrayList<>();

    try {


      final String SQL_QUERY = "SELECT * FROM wishes WHERE userID = ?";
      PreparedStatement statement = connection.prepareStatement(SQL_QUERY);
      statement.setInt(1,user.g());
      ResultSet rs = statement.executeQuery();


      while (rs.next()) {
        int ID = rs.getInt(1);
        int userID = rs.getInt(2);
        String itemName = rs.getString(3);
        double price = rs.getDouble(4);
        String url = rs.getString(5);
        String description = rs.getString(6);
        wishList.add(new Wish(ID, userID, itemName,price, url, description));

      }

      statement.close();
    } catch (
        SQLException e) {
      System.out.println("Could not create connection");
      e.printStackTrace();
    }
    return wishList;
  }
  public boolean saveWish(Wish wish){

    try {
      final String query = "INSERT INTO wishes (userID, item_name, price_dkk, url, description) VALUES (?,?,?,?,?)";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1,wish.getUserID());
      statement.setString(2,wish.getItemName());
      statement.setDouble(3,wish.getPrice());
      statement.setString(4,wish.getUrl());
      statement.setString(5, wish.getDescription());
      int rowsAffected = statement.executeUpdate();
      return rowsAffected > 0; //hvis updaten ikke går igennem returnes false. Ellers returnerer den true.
      //Når man kalder denne metode skal der kunne gives en user med som parameter,
      // wish bør ikke kunne kende user/userID i modellen.
    } catch (Exception e) {
      System.out.println("failed to update wishlist");
      return false;
    }
  }

   */
}