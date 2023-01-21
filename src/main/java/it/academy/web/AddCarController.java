package it.academy.web;

import it.academy.model.Car;
import it.academy.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddCarController {

    @Autowired
    private CarService carService;

    @GetMapping("/add-car.html")
    public String showAddCarPage() {
        return "add_car";
    }

    @PostMapping("/add-car.html")
    @SneakyThrows
    public String addCar(@RequestParam("photo") MultipartFile file, Car car) {
        System.out.println("Call addCar: " +car);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());
        carService.addNewCar(car, file.getBytes());
        return "redirect:/car-list.html";

    }


}


