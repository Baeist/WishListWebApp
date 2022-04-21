package com.example.wishlistwebapplication.repository;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.model.Wish;
import com.example.wishlistwebapplication.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishListRepository {

  private Connection connection;
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