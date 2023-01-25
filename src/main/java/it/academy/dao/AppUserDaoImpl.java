package it.academy.dao;

import it.academy.MysqlJdbcDataSource;
import it.academy.model.AppUser;
import it.academy.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AppUserDaoImpl implements AppUserDao{

    private final MysqlJdbcDataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    public AppUserDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public List<AppUser> readAll() {
        List<AppUser> appUsers = new ArrayList<>();
        try {
            final Connection connection = dataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM app_user");
            while (resultSet.next()) {
                final AppUser appUser = new AppUser();
                appUser.setUserId(resultSet.getString("userId"));
                appUser.setUsername(resultSet.getString("username"));
                appUser.setPassword(resultSet.getString("password"));
                appUser.setRole(resultSet.getString("role"));


                appUsers.add(appUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appUsers;
    }


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

    @Override
    @Transactional
    public void delete(AppUser appUser) {
        AppUser loadedAppUser = sessionFactory.getCurrentSession().load(AppUser.class, appUser.getUsername());
        sessionFactory.getCurrentSession().delete(loadedAppUser);
    }

    @Override
    public AppUser findUserId(String userId) {
        return sessionFactory.getCurrentSession().get(AppUser.class, userId);
    }

}

