package com.example.customer_manage_jsp.servlet;

import com.example.customer_manage_jsp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội"));
        customers.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang"));
        customers.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Hà Tĩnh"));
        customers.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Giang"));
        customers.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội"));

        request.setAttribute("customers",customers);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
