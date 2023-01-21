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

        @GetMapping("/car-show/{car.carId}.html")
        public ModelAndView showCar(@PathVariable("car.carId") Integer carId) {
            System.out.println("Call car show controller");
            Car car = carService.getById(carId);
            System.out.println(car);
            return new ModelAndView("car_show",
                    Map.of("сar",car));
        }








//        @GetMapping("/{carId}")
//        public ModelAndView showCar(@PathVariable ("carId") int carId) {
//          System.out.println("Call page of car");
//            return new ModelAndView(
//                    "car_show",
//                    Map.of("car", carService.getById(carId))
//            );
//        }

//        @ResponseBody
//        @GetMapping("/image/{car.carId}/photo.jpg")
//        public byte[] getImage(@PathVariable("car.carId") int carId) {
//            System.out.println("Call getImage: " + carId);
//            Car empl = carService.getById(carId);
//            return empl.getCarPhoto().getPhoto();
//        }
    }


