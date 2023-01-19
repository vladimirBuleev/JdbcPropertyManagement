package DAO.rent;

import DAO.IDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RentDao implements IDao<Rent> {
    private final JdbcTemplate jdbcTemplate;
    private final RentRowMapper rentRowMapper = new RentRowMapper();

    public RentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rent> getAll() {
        return jdbcTemplate.query("select * from rent", rentRowMapper);
    }

    @Override
    public Rent get(int id) {
        return jdbcTemplate.queryForObject("select * from rent where id =?", rentRowMapper, id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from rent where id=?", id);
    }

    @Override
    public void add(Rent rent) {
        jdbcTemplate.update("insert into rent(clientId,flatId,startDate,endDate,paymentDate,sum) values (?,?,?,?,?,?)",
                rent.getClientId(), rent.getFlatId(), rent.getStartDate(), rent.getEndDate(), rent.getPaymentDate(), rent.getSum());

    }

    @Override
    public void update(int id, Rent rent) {
        jdbcTemplate.update("update rent set clientId=?,flatId=?,startDate=?,endDate=?,paymentDate=?,sum = ? where id =?",
                rent.getClientId(), rent.getFlatId(), rent.getStartDate(), rent.getEndDate(), rent.getPaymentDate(), rent.getSum(), id);

    }

}
