package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.AccountDAO;
import com.example.CaseStudy.dao.CategoryDAO;
import com.example.CaseStudy.dao.ProductDAO;
import com.example.CaseStudy.model.Account;
import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    AccountDAO accountDAO = new AccountDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request,response);
    }

    private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountDAO.loginUser(username,password);
        if(account == null){
            request.setAttribute("message","Wrong username or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        } else {
            HttpSession session = request.getSession();
            ProductDAO productDAO = new ProductDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Product> productList = productDAO.getAllProduct();
            List<Category> categoryList = categoryDAO.getAllCategory();
            request.setAttribute("productList",productList);
            request.setAttribute("categoryList", categoryList);
            session.setAttribute("acc",account);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
