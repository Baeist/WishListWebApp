package com.example.wishlistwebapplication.repository;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.utilities.ConnectionManager;
import com.example.wishlistwebapplication.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class UserRepository {
  Connection connection;

  public void createUser(User user) {
      try {
        var connection = ConnectionManager.getConnection();
        final String INSERT_SQL = "INSERT INTO users(username, password) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.executeUpdate();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public User findUser(String username) {
    try {
      var connection = ConnectionManager.getConnection();
      final String SQL_QUERY = "SELECT username FROM users WHERE username = ?";
      PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
      ps.setString(1, username);
      ps.executeUpdate();
      } catch (Exception e) {
      e.printStackTrace();
        }
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
        userList.add(new User(username,username));
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