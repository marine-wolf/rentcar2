package it.academy.web;

import it.academy.model.Car;
import it.academy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CarListController {
    @Autowired
    private CarService carService;

    @GetMapping("/car-list.html")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "car_list",
                Map.of("cars", carService.getAll())
        );
    }

    @ResponseBody
    @GetMapping("/image/{car.carId}/photo.jpg")
    public byte[] getImage(@PathVariable("car.carId") int carId) {
        System.out.println("Call getImage: " + carId);
        Car empl = carService.getById(carId);
        return empl.getCarPhoto().getPhoto();
    }
}
