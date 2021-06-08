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

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryList(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryList(request,response);
    }

    public void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int cateID = Integer.parseInt(request.getParameter("cid"));
        //da lay dc category id ve roi
        ProductDAO dao = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Product> productList = dao.getProductByCID(cateID);
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("tag", cateID);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
