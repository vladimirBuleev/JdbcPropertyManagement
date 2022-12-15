package data.rent;

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
                rs.getString("startDate"),
                rs.getString("endDate"),
                rs.getString("paymentDate"),
                rs.getDouble("sum")
        );
    }
}
