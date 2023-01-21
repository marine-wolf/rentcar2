package it.academy.service;

import it.academy.dao.ContractDao;
import it.academy.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractSearchService {
    private final ContractDao contractDao;

    @Autowired
    @Qualifier("simpleHttpClient")
    private HttpClient httpClient;

    @Autowired
    public ContractSearchService(ContractDao contractDao) {
        this.contractDao = contractDao;
    }

    public List<Contract> search(String pattern) {
        if (pattern == null) {
            return Collections.emptyList();
        }
        return contractDao.readAll().stream()
                .filter(contract -> contract
                        .getContractStatus()
                        .contains(pattern))
                .collect(Collectors.toList());
    }
}

