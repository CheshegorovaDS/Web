package ru.omsu.imit.novikova._working_with_bd.model;

import java.sql.Date;

public class UserInfo {

    private int id;
    private String phone;
    private String email;
    private Date date;

    public UserInfo() {
    }

    public UserInfo(int id, String phone, String email, Date date) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
