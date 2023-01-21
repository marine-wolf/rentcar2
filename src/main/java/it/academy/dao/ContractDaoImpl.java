package it.academy.dao;

import it.academy.MysqlJdbcDataSource;
import it.academy.model.Contract;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractDaoImpl implements ContractDao {
    private final MysqlJdbcDataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    public ContractDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(Contract contract) {
            sessionFactory.getCurrentSession().saveOrUpdate(contract);
    }

    @Override
    public List<Contract> readAll() {
        List<Contract> contracts = new ArrayList<>();
        try {
            final Connection connection = dataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM contract");
            while (resultSet.next()) {
                final Contract contract = new Contract();
                contract.setContractId(resultSet.getInt("contractId"));
                contract.setReceivedDate(resultSet.getDate("receivedDate"));
                contract.setReturnDate(resultSet.getDate("returnDate"));
                contract.setContractStatus(resultSet.getString("contractStatus"));

                contracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    @Override
    public Contract findById(int id) {
            return sessionFactory.getCurrentSession().get(Contract.class, id);
    }

    @Override
    public List<Contract> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contract", Contract.class).list();
    }

    @Override
    public void delete(Contract contract) {
        Contract loadedContract = sessionFactory.getCurrentSession().load(Contract.class, contract.getContractId());
        sessionFactory.getCurrentSession().delete(loadedContract);
    }
}
