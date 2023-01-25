package it.academy.web;

import it.academy.model.Car;
import it.academy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

    @Controller
    public class CarShowController {
        @Autowired
        private CarService carService;

        @GetMapping("/car-show/{carId}.html")
        public String showCar(@PathVariable("carId") Integer carId, Model model) {
            System.out.println("Call car show controller");
            Car car = carService.getById(carId);
            System.out.println(car);
            model.addAttribute("car", car);
//            return new ModelAndView("car_show",
//                    Map.of("сar",car));
            return "car_show";
        }
    }


