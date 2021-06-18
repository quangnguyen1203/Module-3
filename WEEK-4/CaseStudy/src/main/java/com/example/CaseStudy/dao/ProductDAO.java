package com.example.CaseStudy.dao;

import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
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
//    DBConnection dbConnection = new DBConnection();

//    public List<Product> getAllProduct() {
//        List<Product> list = new ArrayList<>();
//        String query = "select id,name,image,price,title,description from products";
//        try(Connection conn = getConnection();
//        PreparedStatement ps = conn.prepareStatement(query)
//        ) {
//            System.out.println(ps);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String image = rs.getString("image");
//                double price = rs.getDouble("price");
//                String title = rs.getString("title");
//                String description = rs.getString("description");
//                list.add(new Product(id,name,image,price,title,description));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.id,p.name,p.image,p.price,p.title,p.description,c.c_id,c.c_name  FROM products p inner join categories c on p.cat_id = c.c_id\n" +
                "ORDER BY id desc;";
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            System.out.println(ps);
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
        } catch (SQLException e) {
        }
        return list;
    }


    public List<Product> getProductByCID(int cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from products where cat_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                list.add(new Product(id,name,image,price,title,description));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductBySellID(int sid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from products where sell_id = ?";
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                list.add(new Product(id,name,image,price,title,description));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select p.id,p.name,p.image,p.price,p.title,p.description,c.c_id,c.c_name from products p \n" +
                "inner join categories c \n" +
                "on p.cat_id = c.c_id \n" +
                " where name like ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Category category = new Category(rs.getInt("c_id"),rs.getString("c_name"));
                list.add(new Product(id,name,image,price,title,description,category));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(int id) {
        String query = "select * from products where id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                return new Product(id,name,image,price,title,description);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getLastProduct(){
        Product product = null;
        String query = "select * from products order by id desc limit 1;";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public void insertProduct(String name,String image,double price, String title, String description,String cat_id,int sid) throws SQLException {
        String query = "insert into products(name,image,price,title,description,cat_id,sell_id) \n" +
                "values(?,?,?,?,?,?,?);";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1,name);
            statement.setString(2,image);
            statement.setDouble(3,price);
            statement.setString(4,title);
            statement.setString(5,description);
            statement.setString(6,cat_id);
            statement.setInt(7,sid);
            statement.executeUpdate();
        }catch (SQLException e){
        }
    }


    public void updateProduct(String name,String image,double price, String title, String description,String cat_id,int id){
        String query = "UPDATE products set name = ?, image = ?, price = ?, title = ?, description = ?, cat_id = ? WHERE id = ?;";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1,name);
            statement.setString(2,image);
            statement.setDouble(3,price);
            statement.setString(4,title);
            statement.setString(5,description);
            statement.setString(6,cat_id);
            statement.setInt(7,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        public void deleteProduct(int pid) {
        String query = "delete from products where id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getTotalProduct(){
        String query = "SELECT COUNT(*) FROM products";
        try (Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.id,p.name,p.image,p.price,p.title,p.description,c.c_id,c.c_name  FROM products p inner join categories c on p.cat_id = c.c_id\n" +
                "ORDER BY id DESC\n" +
                "LIMIT 5 offset ?;";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ps.setInt(1, ((index - 1) * 5));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Category category = new Category(rs.getInt("c_id"), rs.getString("c_name"));
                list.add(new Product(id, name, image, price, title, description, category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Product> pagingHome(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.id,p.name,p.image,p.price,p.title,p.description,c.c_id,c.c_name  FROM products p inner join categories c on p.cat_id = c.c_id\n" +
                "ORDER BY id DESC\n" +
                "LIMIT 12 offset ?;";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ps.setInt(1, ((index - 1) * 12));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Category category = new Category(rs.getInt("c_id"), rs.getString("c_name"));
                list.add(new Product(id, name, image, price, title, description, category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.pagingProduct(1);
        for (Product o : list
             ) {
            System.out.println(o);
        }
    }

}
