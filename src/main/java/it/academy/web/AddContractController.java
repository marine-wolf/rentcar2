package it.academy.web;

import it.academy.model.Car;
import it.academy.model.Contract;
import it.academy.service.CarService;
import it.academy.service.ContractService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CarService carService;

    @GetMapping("/add-contract.html")
    public ModelAndView showAddContractPage() {
        List<Car> cars = carService.getAll();
        return new ModelAndView(
                "add_contract",
                Map.of("cars", cars)
        );
    }

    @PostMapping("/add-contract.html")
    @SneakyThrows
    public String addContract(Contract contract) {
        System.out.println("Call addContract: " + contract);
        contractService.addNewContract(contract);
        return "redirect:/car-list.html";

    }


}
