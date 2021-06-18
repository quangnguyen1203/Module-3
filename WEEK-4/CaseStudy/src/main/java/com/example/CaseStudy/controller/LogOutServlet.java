package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.CategoryDAO;
import com.example.CaseStudy.dao.ProductDAO;
import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
//        request.getRequestDispatcher("index.jsp").forward(request,response);
//        response.sendRedirect("index.jsp");
//        session.invalidate();
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Product> productList = productDAO.getAllProduct();
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
