package it.academy.service;

import it.academy.dao.CarDao;
import it.academy.dao.ContractDao;
import it.academy.dao.PaymentDao;
import it.academy.model.Car;
import it.academy.model.Contract;
import it.academy.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Transactional
    public void addNewPayment(Payment payment) {
//        if (payment.getNumberOfDays()==null && payment.getTotalPrice()==null){
//            Contract contract = new Contract();
//            Car car = new Car();
//            payment.setNumberOfDays(contract.getNumberOfDays());
//            payment.setTotalPrice(contract.getNumberOfDays()*car.getPricePerDay());
//        }
//        if (contract.getCar() == null) {
//            Car car = new Car();
//            car.setContract(contract);
//            car.setCarId(carId);
//        }
        paymentDao.create(payment);
    }

    @Transactional
    public List<Payment> getAll() {
        return paymentDao.findAll();
    }

    @Transactional
    public Payment getById(int paymentId) {
        return paymentDao.findById(paymentId);
    }

    @Transactional
    public void delete (Payment payment) {
        paymentDao.delete(payment);}
}
