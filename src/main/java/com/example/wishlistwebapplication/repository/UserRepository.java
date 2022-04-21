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