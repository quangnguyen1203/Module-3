package com.example.JDBCTut;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection(){
        final String url = "jdbc:mysql://localhost:3306/demo";
        final String user = "root";
        final String password = "admin";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if(connection != null){
            System.out.println("thanh cong");
        } else {
            System.out.println("that bai");
        }
    }
}
