package it.academy.dao;

import it.academy.model.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDao {
    void create(Contract contract);

    List<Contract> readAll();

    Contract findById(int id);

    List<Contract> findAll();

    void delete (Contract contract);
}
