package ru.omsu.imit.novikova._working_with_bd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.omsu.imit.novikova._working_with_bd.entity.User;
import ru.omsu.imit.novikova._working_with_bd.exception.UserException;
import ru.omsu.imit.novikova._working_with_bd.model.UserInfo;

import java.sql.Date;
import java.util.ArrayList;
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
        String sql = "SELECT * FROM USER WHERE id = " + id;
        Query query = session.createNativeQuery(sql);
        Object[] o = (Object[]) query.getSingleResult();
        User u = new User(
                (int) o[0],
                (String) o[1],
                (String) o[2],
                (Date) o[3]
        );
        return u;
    }

    public User findByPhone(String phone) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM USER WHERE phone = \"" + phone + "\"";
        Query query = session.createNativeQuery(sql);
        Object[] o = (Object[]) query.getSingleResult();
        User u = new User(
                (int) o[0],
                (String) o[1],
                (String) o[2],
                (Date) o[3]
        );
        return u;
    }

    public List<Object[]> listUserInfo() {
        String sql = "SELECT * FROM USER";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery(sql);
        return query.getResultList();
    }

    public void changeUserPhone(String oldPhone, String newPhone) throws UserException {
        User user = this.findByPhone(oldPhone);
        if (user == null) {
            throw new UserException("User with the same phone not exist " + oldPhone);
        }
        String sql = "UPDATE USER SET phone = \"" + newPhone + "\" WHERE phone = \""+ oldPhone + "\"";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery(sql);
        query.executeUpdate();
    }
}
