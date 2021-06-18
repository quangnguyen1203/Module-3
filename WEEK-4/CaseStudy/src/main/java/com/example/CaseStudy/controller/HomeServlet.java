package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.CategoryDAO;
import com.example.CaseStudy.dao.ProductDAO;
import com.example.CaseStudy.model.Category;
import com.example.CaseStudy.model.Product;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/index")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProduct(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        listProduct(request,response);
    }

    public void listProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        ProductDAO productDAO = new ProductDAO();
        int count = productDAO.getTotalProduct();
        int endPage = count/12;
        if(count % 12 != 0){
            endPage++;
        }
        List<Product> list = productDAO.pagingHome(index);

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("productList",list);
        request.setAttribute("endPage",endPage);
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
