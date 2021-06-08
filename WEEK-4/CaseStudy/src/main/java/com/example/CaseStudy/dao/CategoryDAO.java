package com.example.CaseStudy.dao;

import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Product> getAllProductByCategory(int cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.id,p.name,p.image,p.price,p.title,p.description,c.c_id,c.c_name  FROM products p\n" +
                "inner join categories c on\n" +
                "p.cat_id = c.c_id\n" +
                "where cat_id = ?;";
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            System.out.println(ps);
            ps.setInt(1,cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Category category = new Category(rs.getInt("c_id"),rs.getString("c_name"));
                list.add(new Product(id,name,image,price,title,description,category));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select c_id,c_name from categories";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("c_id");
                String cname = rs.getString("c_name");
                list.add(new Category(cid,cname));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
