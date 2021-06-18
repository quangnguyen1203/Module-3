package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.ProductDAO;
import com.example.CaseStudy.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        double pprice = Double.parseDouble(request.getParameter("price"));
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pcategory = request.getParameter("category");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();

        ProductDAO productDAO = new ProductDAO();
        try {
            productDAO.insertProduct(pname,pimage,pprice,ptitle,pdescription,pcategory,sid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("home");
    }
}
