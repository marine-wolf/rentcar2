package it.academy.dao;

import it.academy.model.Contract;
import it.academy.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao {
    void create(Payment payment);

    List<Payment> readAll();

    Payment findById(int id);

    List<Payment> findAll();

    void delete (Payment payment);
}
