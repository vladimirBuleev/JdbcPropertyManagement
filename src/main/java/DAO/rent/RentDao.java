package DAO.rent;

import DAO.Dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RentDao implements Dao {
    private final JdbcTemplate jdbcTemplate;
    private List<Rent> rents = new ArrayList<>();

    public RentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public java.sql.Date dateParser(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date dateParse = dateFormat.parse(date);
        return new java.sql.Date(dateParse.getTime());
    }

    @Override
    public List<Rent> getAll() {
        rents = jdbcTemplate.query("select * from rent", new RentRowMapper());
        return rents;
    }

    @Override
    public List<Rent> get(int id) {
        rents = jdbcTemplate.query("select * from rent where id =?", new RentRowMapper(), id);
        return rents;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from rent where id=?", id);
    }

    public void add(Rent rent) {
        jdbcTemplate.update("insert into rent(clientId,flatId,startDate,endDate,paymentDate,sum) values (?,?,?,?,?,?)",
                rent.getClientId(), rent.getFlatId(), rent.getStartDate(), rent.getEndDate(), rent.getPaymentDate(), rent.getSum());
    }

    public void update(int id, Rent rent) {
        jdbcTemplate.update("update rent set clientId=?,flatId=?,startDate=?,endDate=?,paymentDate=?,sum = ? where id =?",
                rent.getClientId(), rent.getFlatId(), rent.getStartDate(), rent.getEndDate(), rent.getPaymentDate(), rent.getSum(), id);
    }
}
