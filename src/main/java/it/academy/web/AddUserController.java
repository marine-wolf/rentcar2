package it.academy.web;

import it.academy.model.AppUser;
import it.academy.model.Car;
import it.academy.model.Contract;
import it.academy.service.AppUserService;
import it.academy.service.CarService;
import it.academy.service.ContractService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/add-user.html")
    public ModelAndView showAddUserPage() {
        List<AppUser> appUsers = appUserService.getAll();
        return new ModelAndView(
                "add_user",
                Map.of("appUsers", appUsers)
        );
    }

    @PostMapping("/add-user.html")
    @SneakyThrows
    public String addAppUser(AppUser appUser) {
        System.out.println("Call addAppUser: " + appUser);
//        System.out.println("Call addContract-carId: " +carId);

//      System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        appUserService.addNewUser(appUser);
        return "redirect:/user-list.html";


    }
}
