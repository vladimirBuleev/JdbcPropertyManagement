package data.rent;

import data.DB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class RentDB implements DB {
    private final JdbcTemplate jdbcTemplate;

    public RentDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public java.sql.Date dateParser(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date dateParse = dateFormat.parse(date);
        return new java.sql.Date(dateParse.getTime());
    }

    @Override
    public void show() {
        List<Rent> rents = jdbcTemplate.query("select * from rent", new RentRowMapper());
        for (Rent rent : rents) {
            System.out.println(rent);
        }
    }

    @Override
    public void show(int id) {
        List<Rent> rents = jdbcTemplate.query("select * from rent where id =?", new RentRowMapper(), id);
        for (Rent rent : rents) {
            System.out.println(rent);
        }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from rent where id=?", id);
    }

    public void add(Rent rent) {
        try {
            jdbcTemplate.update("insert into rent(clientId,flatId,startDate,endDate,paymentDate,sum) values (?,?,?,?,?,?)",
                    rent.getClientId(), rent.getFlatId(), dateParser(rent.getStartDate()), dateParser(rent.getEndDate()), dateParser(rent.getPaymentDate()), rent.getSum());
        } catch (ParseException e) {
            System.out.println("wrong date format" + e);
        }
    }

    public void update(int id, Rent rent) {
        try {
            jdbcTemplate.update("update rent set clientId=?,flatId=?,startDate=?,endDate=?,paymentDate=?,sum = ? where id =?",
                    rent.getClientId(), rent.getFlatId(), dateParser(rent.getStartDate()), dateParser(rent.getEndDate()), dateParser(rent.getPaymentDate()), rent.getSum(), id);
        } catch (ParseException e) {
            System.out.println("wrong date format" + e);
        }
    }
}
