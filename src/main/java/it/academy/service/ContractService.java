package it.academy.service;

import it.academy.dao.ContractDao;
import it.academy.model.Car;
import it.academy.model.CarPhoto;
import it.academy.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    ContractDao contractDao;

    @Transactional
    public void addNewContract(Contract contract) {
//        if (contract.getCar() == null) {
//            Car car = new Car();
//            car.setContract(contract);
//            car.setCarId(carId);
//        }
        contractDao.create(contract);
    }

    @Transactional
    public List<Contract> getAll() {
        return contractDao.findAll();
    }

    @Transactional
    public Contract getById(int contractId) {
        return contractDao.findById(contractId);
    }

    @Transactional
    public void delete (Contract contract) {
        contractDao.delete(contract);}
}
