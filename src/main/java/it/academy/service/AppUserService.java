package it.academy.service;

import it.academy.dao.AppUserDao;
import it.academy.model.AppUser;
import it.academy.model.Car;
import it.academy.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    AppUserDao appUserDao;

    @Transactional
    public List<AppUser> findUserByUsername(String username) {
        System.out.println("Search for user: " + username);
        return appUserDao.findByUserName(username);
    }

    @Transactional
    public AppUser findUserId(String userId) {
        System.out.println("Search for user: " + userId);
        return appUserDao.findUserId(userId);
    }

    @Transactional
    public void addNewUser(AppUser appUser) {
//        if (contract.getCar() == null) {
//            Car car = new Car();
//            car.setContract(contract);
//            car.setCarId(carId);
//        }
        appUserDao.create(appUser);
    }

    @Transactional
    public List<AppUser> getAll() {
        return appUserDao.findAll();
    }

    @Transactional
    public void delete (AppUser appUser) {appUserDao.delete(appUser);}
}
