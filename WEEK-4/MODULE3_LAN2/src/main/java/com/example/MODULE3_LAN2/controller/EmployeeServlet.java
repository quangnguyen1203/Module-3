package com.example.MODULE3_LAN2.controller;

import com.example.MODULE3_LAN2.DAO.EmployeeDAO;
import com.example.MODULE3_LAN2.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeDAO employeeDAO;
    public void init(){
        employeeDAO = new EmployeeDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEmployye(request, response);
                    break;
                case "search":
                    searchEmployee(request,response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> employees = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String staffgroup = request.getParameter("staffgroup");
        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        int identity = Integer.parseInt(request.getParameter("identity"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Employee newEmployee = new Employee(staffgroup,name,dob,gender,phone,identity,email,address);
        employeeDAO.addEmployee(newEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployye(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployeeById(id);
        List<Employee> employees = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingUser = employeeDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", existingUser);
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String staffgroup = request.getParameter("staffgroup");
        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        int identity = Integer.parseInt(request.getParameter("identity"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Employee book = new Employee(id,staffgroup,name,dob,gender,phone,identity,email,address);
        employeeDAO.updateEmployee(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("employees");
        List<Employee> employees = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String key = request.getParameter("search");
        List<Employee> employees = employeeDAO.searchCountry(key);
        request.setAttribute("listEmployee", employees);
        request.setAttribute("key",key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
