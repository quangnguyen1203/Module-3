package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.AccountDAO;
import com.example.CaseStudy.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {
    AccountDAO accountDAO = new AccountDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        signUpUser(request,response);
    }

    private void signUpUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String re_pass = request.getParameter("confirm_password");
        if(!password.equals(re_pass)){
            request.setAttribute("message","Enter a password that does not match.");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request,response);
        } else {
            AccountDAO accountDAO = new AccountDAO();
            Account a = accountDAO.checkUserExist(username);
            if(a==null){
                accountDAO.signUpUser(username,password,email);
                request.setAttribute("message","Registered successfully");
                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                rd.forward(request,response);
            } else {
                request.setAttribute("message","Username available");
                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                rd.forward(request,response);
            }
        }
    }
}
