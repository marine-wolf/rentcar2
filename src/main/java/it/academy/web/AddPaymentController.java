package it.academy.web;

import it.academy.model.Car;
import it.academy.model.Contract;
import it.academy.model.Payment;
import it.academy.service.CarService;
import it.academy.service.ContractService;
import it.academy.service.PaymentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddPaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ContractService contractService;

    @GetMapping("/add-payment.html")
//    public String showAddContractPage() {
//        return "add_contract";
//    }
    public ModelAndView showAddPaymentPage() {
        List<Contract> contracts = contractService.getAll();
        return new ModelAndView(
                "add_payment",
                Map.of("contracts", contracts)
        );
    }

    @PostMapping("/add-payment.html")
    @SneakyThrows
    public String addPayment(Payment payment) {
        System.out.println("Call addPayment: " + payment);
//        System.out.println("Call addContract-carId: " +carId);

//      System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        paymentService.addNewPayment(payment);
        return "redirect:/payment-list.html";

    }


}
