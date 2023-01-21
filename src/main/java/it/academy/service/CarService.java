package it.academy.service;

import it.academy.dao.CarDao;
import it.academy.model.Car;
import it.academy.model.CarPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarDao carDao;

    @Transactional
    public void addNewCar(Car car, byte[] photo) {
        if (car.getCarPhoto() == null) {
            CarPhoto carPhoto = new CarPhoto();
            carPhoto.setCar(car);
            carPhoto.setPhoto(photo);
            car.setCarPhoto(carPhoto);
        }

        carDao.create(car);
    }
    @Transactional
    public List<Car> getAll() {
        return carDao.findAll();
    }
    @Transactional
    public Car getById(int carId) {
        return carDao.findById(carId);
    }

    @Transactional
    public void delete (Car car) {carDao.delete(car);}

//    @Transactional
//    public void deleteById (int carId){carDao.deleteById(carId);}

//    @Transactional
//    public List<Car> getCarsByPage(int pageid, int total){
//        return carDao.getCarByPage(pageid, total);
//    }

//    public void saveAllCars(List<Car> cars){
//        carRepository.saveAll(cars);
//    }
//    public Iterable<Car> getAllCars(Integer pageSize, Integer offcet){
//        return carRepository.findAll(PageRequest.of(offcet,pageSize));
//    }

//    @Transactional
//    public void update(Car car, byte[] photo) {
//        if (car.getCarPhoto() == null) {
//            CarPhoto carPhoto = new CarPhoto();
//            carPhoto.setCar(car);
//            carPhoto.setPhoto(photo);
//            car.setCarPhoto(carPhoto);
//        }
//        carDao.update(car);
//    }

}