package it.academy.web;

import it.academy.model.Contract;
import it.academy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ContractListController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/contract-list.html")
    public ModelAndView showContractList() {
        return new ModelAndView(
                "contract_list",
                Map.of("contracts", contractService.getAll())
        );
    }

}
