package it.academy.web;

import it.academy.service.ContractService;
import it.academy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PaymentListController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment-list.html")
    public ModelAndView showPaymentList() {
        return new ModelAndView(
                "payment_list",
                Map.of("payments", paymentService.getAll())
        );
    }
}
