package it.academy.web;

import it.academy.model.Car;
import it.academy.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class DeleteCarController {
    @Autowired
    private CarService carService;

    @GetMapping("/delete-car.html")
    public ModelAndView showDeleteCarPage() {
        List<Car> cars = carService.getAll();
        return new ModelAndView(
                "delete_car",
                Map.of("cars", cars)
        );
    }

    @PostMapping("/delete-car.html")
    @SneakyThrows
    public String deleteCar(Car car) {
        System.out.println("Call deleteCar: " + car);
        carService.delete(car);
        return "redirect:/car-list.html";

    }

}
