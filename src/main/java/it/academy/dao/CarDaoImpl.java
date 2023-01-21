package it.academy.dao;


import it.academy.MysqlJdbcDataSource;
import it.academy.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final MysqlJdbcDataSource dataSource;

//    private JdbcTemplate template;
//    public JdbcTemplate getTemplate(){
//        return template;
//    }
//    public void setTemplate(JdbcTemplate template){
//        this.template=template;
//    }

    @Autowired
    private SessionFactory sessionFactory;

    public CarDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(Car car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public Car findById(int carId) {
        return sessionFactory.getCurrentSession().get(Car.class, carId);
    }

    @Override
    public List<Car> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Car", Car.class).list();
    }

    @Override
    public List<Car> readAll() {
        List<Car> cars = new ArrayList<>();
        try {
            final Connection connection = dataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
            while (resultSet.next()) {
                final Car car = new Car();
                car.setCarId(resultSet.getInt("carId"));
                car.setProducer(resultSet.getString("producer"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setVmotor(resultSet.getString("vmotor"));
                car.setPricePerDay(resultSet.getDouble("pricePerDay"));

                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

//    @Override
//    public List<Car> getCarByPage(int pageid, int total) {
//        String sql = "SELECT *FROM Car LIMIT "+(pageid-1)+","+total;
//        return getTemplate().query(sql, new RowMapper<Car>() {
//            @Override
//            public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Car carss = new Car();
//                carss.setId(rs.getInt("id"));
//                carss.setProducer(rs.getString("producer"));
//                carss.setModel(rs.getString("model"));
//                carss.setColor(rs.getString("color"));
//                carss.setVmotor(rs.getString("vmotor"));
////                carss.setCarPhoto(rs.getBytes("photo"));
//                return carss;
//            }
//        });
//    }
    //    @Override
//    public void update(Car car) {
//        sessionFactory.getCurrentSession().saveOrUpdate(car);
//    }

//    @Override
//    public void updateId(int id) {
//        sessionFactory.getCurrentSession().createQuery("update from Car where id=" + id).executeUpdate();
//    }
    @Override
    public void delete(Car car) {
        Car loadedCar = sessionFactory.getCurrentSession().load(Car.class, car.getCarId());
        sessionFactory.getCurrentSession().delete(loadedCar);
    }

}