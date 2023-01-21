package it.academy.web;

import it.academy.model.AppUser;

import it.academy.service.AppUserService;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public String addAppUser(@Valid AppUser appUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "add_user";
        System.out.println("Call addAppUser: " + appUser);
        String strPass = appUser.getPassword();
        String strPassNoop = "{noop}" + strPass;
        appUser.setPassword(strPassNoop);

        appUserService.addNewUser(appUser);
        return "redirect:/index.html";


    }
}
