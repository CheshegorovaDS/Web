package ru.omsu.imit.novikova._working_with_bd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
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

    public List<Object[]> listUserInfo() {
        String sql = "SELECT * FROM USER";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery(sql);
        return query.getResultList();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void changeUserPhone(String oldPhone, String newPhone) throws UserException {
        User user = this.findByPhone(oldPhone);
        if (user != null) {
            throw new UserException("User with the same phone already exist " + oldPhone);
        }
        user.setPhone(newPhone);
    }
}
