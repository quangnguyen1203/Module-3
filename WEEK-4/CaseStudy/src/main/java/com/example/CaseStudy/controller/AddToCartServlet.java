package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.ProductDAO;
import com.example.CaseStudy.model.Item;
import com.example.CaseStudy.model.Order;
import com.example.CaseStudy.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addtoCart")
public class AddToCartServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        int id;
        if(request.getParameter("productId") != null){
            id = Integer.parseInt(request.getParameter("productId"));
            Product product = productDAO.getProductByID(id);
            if(product != null){
                if(request.getParameter("quantity")!= null){
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                }
                HttpSession session = request.getSession();
                if(session.getAttribute("order")==null){
                    Order order = new Order();
                    List<Item> listItems = new ArrayList<>();
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setProduct(product);
                    item.setPrice(product.getPrice());
                    listItems.add(item);
                    order.setItems(listItems);
                    session.setAttribute("order",order);
                } else {
                    Order order = (Order) session.getAttribute("order");
                    List<Item> listItems = order.getItems();
                    boolean check = false;
                    for (Item item: listItems
                         ) {
                        if(item.getProduct().getId() == product.getId()){
                            item.setQuantity(item.getQuantity()+quantity);
                            check = true;
                        }
                    }
                    if(check == false){
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(product);
                        item.setPrice(product.getPrice());
                        listItems.add(item);
                    }
                    session.setAttribute("order",order);
                }
            }
            request.getRequestDispatcher("index").forward(request,response);
        } else {
            request.getRequestDispatcher("index").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
