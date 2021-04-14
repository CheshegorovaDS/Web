package ru.omsu.imit.novikova._working_with_bd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="USER")
public class User implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="phone", length = 11, nullable = false, unique = true)
    private String phone;

    @Column(name="email", length = 45, nullable = false, unique = true)
    private String email;

    @Column(name="date")
    private Date date;

    public User() {
    }

    public User(int id, String phone, String email, Date date) {
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(date, user.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, email, date);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
