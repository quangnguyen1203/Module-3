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

@WebServlet(name = "CPServlet", value = "/home")
public class CPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProduct(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProduct(request,response);
    }

    public void listProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Product> productList = productDAO.getAllProduct();
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("product/ManagerProduct.jsp").forward(request,response);
    }
}
