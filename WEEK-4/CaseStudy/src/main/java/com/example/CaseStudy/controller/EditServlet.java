package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.CategoryDAO;
import com.example.CaseStudy.dao.ProductDAO;
import com.example.CaseStudy.model.Account;
import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditServlet", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int pid = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        double pprice = Double.parseDouble(request.getParameter("price"));
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pcategory = request.getParameter("category");

        ProductDAO productDAO = new ProductDAO();
        productDAO.updateProduct(pname,pimage,pprice,ptitle,pdescription,pcategory,pid);
        request.getRequestDispatcher("home").forward(request,response);
    }
}
