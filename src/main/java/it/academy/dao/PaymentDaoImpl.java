package it.academy.dao;

import it.academy.MysqlJdbcDataSource;
import it.academy.model.Contract;
import it.academy.model.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao{
    private final MysqlJdbcDataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    public PaymentDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(Payment payment) {
        sessionFactory.getCurrentSession().saveOrUpdate(payment);
    }

    @Override
    public List<Payment> readAll() {
        List<Payment> payments = new ArrayList<>();
        try {
            final Connection connection = dataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM payment");
            while (resultSet.next()) {
                final Payment payment = new Payment();
                payment.setPaymentId(resultSet.getInt("paymentId"));
                payment.setCreateDate(resultSet.getDate("createDate"));
//
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public Payment findById(int id) {
        return sessionFactory.getCurrentSession().get(Payment.class, id);
    }

    @Override
    public List<Payment> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Payment", Payment.class).list();
    }

    @Override
    public void delete(Payment payment) {
        Payment loadedPayment = sessionFactory.getCurrentSession().load(Payment.class, payment.getPaymentId());
        sessionFactory.getCurrentSession().delete(loadedPayment);
    }
}
