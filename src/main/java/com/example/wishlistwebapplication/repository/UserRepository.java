package com.example.wishlistwebapplication.repository;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.model.WishList;
import com.example.wishlistwebapplication.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
  Connection connection;

  public void createUser(User user) {
    try {
      var connection = ConnectionManager.getConnection();
      String INSERT_SQL = "INSERT INTO users(username, password) VALUES (?, ?)"; // INSERT INTO product(name, price) VALUES (?, ?)
      PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      System.out.println(user.getPassword() + user.getUsername() + user.getUserID());
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

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

  // gets a user without their wishlist but includes id, name and password
  public User haveUserNameGetUserInfo(String username) {

    try {
      var connection = ConnectionManager.getConnection();
      Statement statement = connection.createStatement();
      final String SQL_QUERY = "SELECT * FROM users WHERE username = ?";
      PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
      ps.setString(1, username);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int userID = rs.getInt(1);
        username = rs.getString(2);
        String password = rs.getString(3);
        User user = new User(userID, username, password);
        return user;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void setConnection() {
    try {
      connection = ConnectionManager.getConnection();

    } catch (Exception e) {
      System.out.println("Did not connect to database" + e);
    }

  }

  public ArrayList<User> getAllUsers() {
    ArrayList<User> userList = new ArrayList<>();

    try {
      Statement statement = connection.createStatement();
      final String SQL_QUERY = "SELECT * FROM users";
      ResultSet rs = statement.executeQuery(SQL_QUERY);

      while (rs.next()) {
        int userID = rs.getInt(1);
        String username = rs.getString(2);
        userList.add(new User(username, username));
      }
      statement.close();      // god afslutning, har ingen reel betydning her
    } catch (
        SQLException e) {
      System.out.println("Could not create connection");
      e.printStackTrace();
    }
    return userList;
  }
}