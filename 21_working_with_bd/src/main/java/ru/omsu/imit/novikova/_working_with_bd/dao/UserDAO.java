package ru.omsu.imit.novikova._working_with_bd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.omsu.imit.novikova._working_with_bd.entity.User;
import ru.omsu.imit.novikova._working_with_bd.exception.UserException;
import ru.omsu.imit.novikova._working_with_bd.model.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAO() {
    }

    public User findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public User findByPhone(String phone) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(User.class, phone);
    }

    public List<UserInfo> listUserInfo() {
        String sql = "Select id from " + User.class.getName();
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY)
    public void addUser(int id, String phone, String email, Date date) throws UserException {
        User user = this.findByPhone(phone);
        if (user != null) {
            throw new UserException("User with the same phone already exist " + id);
        }

    }

}
