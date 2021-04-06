package ru.omsu.imit.novikova._working_with_bd.model;

import java.sql.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return id == userInfo.id &&
                Objects.equals(phone, userInfo.phone) &&
                Objects.equals(email, userInfo.email) &&
                Objects.equals(date, userInfo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, email, date);
    }
}
