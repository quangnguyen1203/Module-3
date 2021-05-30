package com.example.user_manager.controller;

import com.example.user_manager.dao.UserDAO;
import com.example.user_manager.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            searchUserByCountry(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void searchUserByCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String key = request.getParameter("search");
        List<User> users = userDAO.searchCountry(key);
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/view.jsp");
        dispatcher.forward(request, response);
    }
}
