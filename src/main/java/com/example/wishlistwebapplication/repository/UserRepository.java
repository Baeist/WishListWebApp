package com.example.wishlistwebapplication.repository;

import com.example.wishlistwebapplication.model.User;
import com.example.wishlistwebapplication.util.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class UserRepository {

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
  }
