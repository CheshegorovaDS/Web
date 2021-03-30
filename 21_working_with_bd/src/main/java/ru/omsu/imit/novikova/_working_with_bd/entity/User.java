package ru.omsu.imit.novikova._working_with_bd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="phone", length = 11, nullable = false, unique = true)
    private String phone;

    @Column(name="email", length = 45, nullable = false, unique = true)
    private String email;

    @Column(name="date")
    private Date date;

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
