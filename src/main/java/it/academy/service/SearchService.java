package it.academy.service;


import it.academy.dao.CarDao;
import it.academy.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final CarDao carDao;

    @Autowired
    @Qualifier("simpleHttpClient")
    private HttpClient httpClient;

    @Autowired
    public SearchService(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> search(String pattern) {
        if (pattern == null) {
            return Collections.emptyList();
        }
        return carDao.readAll().stream()
                .filter(car -> car
                        .getProducer()
                        .toLowerCase()
                        .contains(pattern.toLowerCase()))
                .collect(Collectors.toList());
    }
}