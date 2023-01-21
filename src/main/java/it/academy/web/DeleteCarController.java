package it.academy.web;

import it.academy.model.Car;
import it.academy.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteCarController {
    @Autowired
    private CarService carService;

    @GetMapping("/delete-car.html")
    public String showDeleteCarPage() {
        return "delete_car";
    }

    @PostMapping("/delete-car.html")
    @SneakyThrows
//    public String deleteCarById (int id){
//        carService.deleteById(id);
    public String deleteCar(Car car) {
        System.out.println("Call deleteCar: " + car);
        carService.delete(car);
        return "redirect:/car-list.html";

    }

}
