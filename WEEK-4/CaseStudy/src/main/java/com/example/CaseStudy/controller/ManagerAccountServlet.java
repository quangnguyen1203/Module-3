package com.example.CaseStudy.controller;

import com.example.CaseStudy.dao.AccountDAO;
import com.example.CaseStudy.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ManagerAccountServlet", value = "/account")
public class ManagerAccountServlet extends HttpServlet {
    private AccountDAO accountDAO;

    public void init() {
        accountDAO = new AccountDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertAccount(request, response);
                    break;
                case "edit":
                    updateAccount(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteAccount(request, response);
                    break;
                case "search":
                    searchAccount(request,response);
                    break;
                default:
                    listAccount(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        AccountDAO accountDAO = new AccountDAO();
        int count = accountDAO.getTotalAccount();
        int endPage = count/5;
        if(count % 5 != 0){
            endPage++;
        }
        List<Account> list = accountDAO.pagingAccount(index);
        request.setAttribute("accountList",list);
        request.setAttribute("endPage",endPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/ManagerAccount.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/ManagerAccount.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account existingAccount = accountDAO.selectAccount(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/editaccount.jsp");
        request.setAttribute("editAccount", existingAccount);
        dispatcher.forward(request, response);

    }

    private void insertAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int isSell = Integer.parseInt(request.getParameter("isSell"));
        int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
        Account newUser = new Account(name,password,email,isSell,isAdmin);
        accountDAO.insertAccount(newUser);
        List<Account> accountList = accountDAO.selectAllAccount();
        request.setAttribute("accountList", accountList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/ManagerAccount.jsp");
        dispatcher.forward(request, response);
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        int isSell = Integer.parseInt(request.getParameter("isSell"));
        int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
        Account book = new Account(id,name,pass,email,isSell,isAdmin);
        accountDAO.updateAccount(book);
        List<Account> accountList = accountDAO.selectAllAccount();
        request.setAttribute("accountList", accountList);
        response.sendRedirect("account");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        accountDAO.deleteAccount(id);
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        AccountDAO accountDAO = new AccountDAO();
        int count = accountDAO.getTotalAccount();
        int endPage = count/5;
        if(count % 5 != 0){
            endPage++;
        }
        List<Account> accountList = accountDAO.pagingAccount(index);
        request.setAttribute("endPage",endPage);
        request.setAttribute("accountList", accountList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/ManagerAccount.jsp");
        dispatcher.forward(request, response);
    }

    private void searchAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String key = request.getParameter("search");
        List<Account> accounts = accountDAO.searchAccount(key);
        request.setAttribute("accountList", accounts);
        request.setAttribute("key",key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/ManagerAccount.jsp");
        dispatcher.forward(request, response);
    }
}
