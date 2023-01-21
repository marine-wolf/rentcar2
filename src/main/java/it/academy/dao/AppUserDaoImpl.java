package it.academy.dao;

import it.academy.model.AppUser;
import it.academy.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AppUserDaoImpl implements AppUserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AppUser> findByUserName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser au where au.username=:username", AppUser.class)
                .setParameter("username", username)
                .list();
    }

    @Override
    @Transactional
    public void create(AppUser appUser) {
            sessionFactory.getCurrentSession().saveOrUpdate(appUser);
        }

        @Override
    public List<AppUser> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from AppUser", AppUser.class).list();
    }

}

