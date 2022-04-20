package com.example.wishlistwebapplication.repository;

import com.example.wishlistwebapplication.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

  private String DBURL = "jdbc:mysql://localhost:3306/wishlist";
  private String user = "root";
  private String passWord = "2702";

  private Connection connection;

  public UserRepository() {
    setConnection();
  }

  public void setConnection() {
    try {
      connection = DriverManager.getConnection(DBURL, user, passWord);

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
        userList.add(new User(userID,username));

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