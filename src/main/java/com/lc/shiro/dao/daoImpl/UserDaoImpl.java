package com.lc.shiro.dao.daoImpl;

import com.lc.shiro.dao.UserDao;
import com.lc.shiro.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 22:55
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public User findUserByName(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User u where u.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", username);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User u";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        return users;
    }
}
