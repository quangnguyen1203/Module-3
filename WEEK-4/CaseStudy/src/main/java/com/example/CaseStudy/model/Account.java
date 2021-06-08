package com.example.CaseStudy.model;

public class Account {
    private int id;
    private String username;
    private String password;
    private String email;
    private int isSell;
    private int isAdmin;

    public Account() {
    }

    public Account(String username, String password, String email, int isSell, int isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public Account(int id, String username, String password, String email, int isSell, int isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
