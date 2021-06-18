package com.example.CaseStudy.dao;

import com.example.CaseStudy.model.Account;
import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
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

    public Account loginUser(String user, String pass){
        String query = "SELECT * FROM accounts WHERE username = ? and password = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                int isSell = rs.getInt("isSell");
                int isAdmin = rs.getInt("isAdmin");
                return new Account(id,user,pass,email,isSell,isAdmin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Account checkUserExist(String user){
        String CHECK_ACCOUNT_EXIST = "SELECT * FROM accounts WHERE username =?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ACCOUNT_EXIST);
        ) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,user);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int isSell = rs.getInt("isSell");
                int isAdmin = rs.getInt("isAdmin");
                return new Account(id,user,password,email,isSell,isAdmin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void signUpUser(String username, String password,String email){
        String SIGN_UP = "INSERT INTO accounts(username,password,email) VALUES (?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SIGN_UP)
        ) {
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Account> selectAllAccount() {
        List<Account> accounts = new ArrayList<>();
        String query = "select id,username,password,email,isSell,isAdmin from accounts;";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                int sell = rs.getInt("isSell");
                int admin = rs.getInt("isAdmin");
                accounts.add(new Account(id,name,pass,email,sell,admin));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }


    public Account selectAccount(int id) {
        Account account = null;
        String query = "select * from accounts where id =?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                int sell = rs.getInt("isSell");
                int admin = rs.getInt("isAdmin");
                account = new Account(id, name, pass,email,sell,admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }

    public void insertAccount(Account account) throws SQLException {
        String query = "INSERT INTO accounts(username,password,email,isSell,isAdmin) VALUES (?,?,?,?,?);";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setInt(4, account.getIsSell());
            preparedStatement.setInt(5, account.getIsAdmin());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean updateAccount(Account account) throws SQLException {
        String query = "update accounts set username = ?,password = ?, email = ?, isSell = ?, isAdmin = ? where id = ?;";
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getEmail());
            statement.setInt(4, account.getIsSell());
            statement.setInt(5, account.getIsAdmin());
            statement.setInt(6, account.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteAccount(int id) throws SQLException {
        String query = "delete from accounts where id=?";
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<Account> searchAccount(String key) {
        String query = "select * from accounts where username like ? or id like ? or email like ?";
        List<Account> accounts = new ArrayList<>();
        String keyWord = "%"+key+"%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1,keyWord);
            preparedStatement.setString(2,keyWord);
            preparedStatement.setString(3,keyWord);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                int sell = rs.getInt("isSell");
                int admin = rs.getInt("isAdmin");
                accounts.add(new Account(id,name,pass,email,sell,admin));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }

    public int getTotalAccount(){
        String query = "SELECT COUNT(*) FROM accounts";
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

    public List<Account> pagingAccount(int index) {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts \n" +
                "ORDER BY id \n" +
                "LIMIT 5 OFFSET ?;";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ps.setInt(1, ((index - 1) * 5));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                int sell = rs.getInt("isSell");
                int admin = rs.getInt("isAdmin");
                accounts.add(new Account(id,name,pass,email,sell,admin));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }
}
