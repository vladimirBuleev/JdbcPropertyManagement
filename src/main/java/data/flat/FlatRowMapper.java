package data.flat;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlatRowMapper implements RowMapper<Flat> {

    @Override
    public Flat mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Flat(
                rs.getInt("id"),
                rs.getString("city"),
                rs.getString("street"),
                rs.getString("houseNum"),
                rs.getString("floor"),
                rs.getString("apNum"),
                rs.getDouble("apArea"),
                rs.getDouble("rentPrice"),
                rs.getString("status")
        );
    }
}
