package DAO.rent;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentRowMapper implements RowMapper<Rent> {
    @Override
    public Rent mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Rent(
                rs.getInt("id"),
                rs.getInt("clientId"),
                rs.getInt("flatId"),
                rs.getDate("startDate"),
                rs.getDate("endDate"),
                rs.getDate("paymentDate"),
                rs.getDouble("sum")
        );
    }
}
