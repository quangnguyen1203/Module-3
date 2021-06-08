package com.example.user_manager.controller;

import com.example.user_manager.dao.UserDAO;
import com.example.user_manager.model.Account;
import com.example.user_manager.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            loginByUser(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void loginByUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = userDAO.loginUser(username,password);
        if (account == null){
            request.setAttribute("message","Wrong username or password");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        } else {
            List<User> userList = userDAO.selectAllUsers();
            request.setAttribute("listUser",userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request,response);
        }
    }
}
