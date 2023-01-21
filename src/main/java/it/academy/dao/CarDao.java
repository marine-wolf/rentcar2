package it.academy.dao;

import it.academy.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {


    void create(Car car);

    List<Car> readAll();

    Car findById(int id);

    List<Car> findAll();

    void delete(Car car);

}
