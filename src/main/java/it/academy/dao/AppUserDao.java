package it.academy.dao;

import it.academy.model.AppUser;
import it.academy.model.Car;
import it.academy.model.Contract;

import java.util.List;

public interface AppUserDao {
    List<AppUser> findByUserName(String username);

    void create(AppUser appUser);

    List<AppUser> findAll();
}
