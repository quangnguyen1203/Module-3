package com.example.MODULE3_LAN2.DAO;

import com.example.MODULE3_LAN2.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/baithi2?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    public EmployeeDAO() {
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

    private static final String SELECT_ALL_EMPLOYEE = "SELECT id,staffgroup,name,gender,phone FROM employees";

    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String staffgroup = rs.getString("staffgroup");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                employees.add(new Employee(id,staffgroup,name,gender,phone));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO `employees` (`staffgroup`, `name`, `dob`, `gender`, `phone`, `identity`, `email`, `address`) VALUES (?,?,?,?,?,?,?,?);";

    public void addEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getStaffgroup());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDate(3, employee.getDob());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setInt(6, employee.getIdentity());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private static final String SELECT_EMPLOYEES_BY_ID = "select * from employees where id =?";

    public Employee selectUser(int id) {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEES_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String staffgroup = rs.getString("staffgroup");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                int identity = rs.getInt("identity");
                String email = rs.getString("email");
                String address = rs.getString("address");
                employee = new Employee(id,staffgroup, name,dob,gender,phone,identity, email,address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    private static final String DELETE_EMPLOYEE_SQL = "delete from employees where id = ?;";

    public boolean deleteEmployeeById(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private static final String UPDATE_USERS_SQL = "update employees set staffgroup =?,name =?, dob= ?, gender =?,phone=?,identity=?,email=?,address=? where id = ?;";

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, employee.getStaffgroup());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDate(3, employee.getDob());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setInt(6, employee.getIdentity());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9,employee.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
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

    private static final String SELECT_USER_BY_COUNTRY = "select * from employees where id like ? or name like ?";

    public List<Employee> searchCountry(String key) {
        List<Employee> employees = new ArrayList<>();
        String keyWord = "%"+key+"%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);) {
            preparedStatement.setString(1,keyWord);
            preparedStatement.setString(2,keyWord);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String staffgroup = rs.getString("staffgroup");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                int identity = rs.getInt("identity");
                String email = rs.getString("email");
                String address = rs.getString("address");
                employees.add(new Employee(id,staffgroup, name,dob,gender,phone,identity, email,address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }
}
