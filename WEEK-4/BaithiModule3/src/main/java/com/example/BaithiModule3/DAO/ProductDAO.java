package com.example.BaithiModule3.DAO;

import com.example.BaithiModule3.model.Category;
import com.example.BaithiModule3.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/baithi?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products (name,price,quantity,color,`describe`,category) VALUES\n" +
            "(?, ?, ?, ?, ?, ?);";

    public void insertProducts(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setInt(6, product.getId_category());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id =?";

    public Product selectProducts(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String describe = rs.getString("describe");
                String category = rs.getString("category");
                product = new Product(id,name,price,quantity,color,describe,category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    private static final String SELECT_PRODUCT_BY_NAME = "select p.id,p.name,p.price,p.quantity,p.color,p.describe,c.name_category from products p \n" +
            "INNER JOIN category c \n" +
            "ON p.category = c.id_category \n" +
            "where name like ?";

    public List<Product> searchNameProduct(String key) {
        List<Product> productList = new ArrayList<>();
        String keyWord = "%"+key+"%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);) {
            preparedStatement.setString(1,keyWord);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String describe = rs.getString("describe");
                String category = rs.getString("name_category");
                productList.add(new Product(id,name,price,quantity,color,describe,category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    private static final String SELECT_ALL_PRODUCTS = "select p.id,p.name,p.price,p.quantity,p.color,p.describe,c.name_category from products p\n" +
            "INNER JOIN category c \n" +
            "ON p.category = c.id_category ORDER BY ";

    public List<Product> selectAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String describe = rs.getString("describe");
                String category = rs.getString("name_category");
                productList.add(new Product(id,name,price,quantity,color,describe,category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";

    public boolean deleteProducts(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private static final String UPDATE_PRODUCTS_SQL = "update products set `name` =?,price =?, quantity =?, color =?, `describe` =?, category =?  where id = ?;";

    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescribe());
            statement.setInt(6, product.getId_category());
            statement.setInt(7,product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private static final String CATEGORY_LIST = "SELECT * FROM category";

    public List<Category> showCategorylist(){
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CATEGORY_LIST)
        ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_category");
                String name = rs.getString("name_category");
                categoryList.add(new Category(id,name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }
}
