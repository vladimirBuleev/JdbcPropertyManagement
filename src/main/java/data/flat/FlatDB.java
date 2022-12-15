package data.flat;

import data.DB;
import data.client.Client;
import data.client.ClientDB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlatDB implements DB {
    private final JdbcTemplate jdbcTemplate;

    public FlatDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void show() {
        List<Flat> flats = jdbcTemplate.query("select * from flat", new FlatRowMapper());
        for (Flat flat : flats) {
            System.out.println(flat);
        }
    }

    @Override
    public void show(int id) {
        List<Flat> flats = jdbcTemplate.query("select * from flat where id = ?", new FlatRowMapper(), id);
        for (Flat flat : flats) {
            System.out.println(flat);
        }

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from flat where id=?", id);
    }

    public void add(Flat flat) {
        jdbcTemplate.update("insert into flat(city,street,housenum,floor,apnum,aparea,rentprice,status) values (?,?,?,?,?,?,?,?)",
                flat.getCity(), flat.getStreet(), flat.getHouseNum(), flat.getFloor(),
                flat.getApNum(), flat.getApArea(), flat.getRentPrice(), flat.getStatus());
    }

    public void update(int id, Flat newFlat) {
        jdbcTemplate.update("update flat set city=?,street=?,housenum=?,floor=?,apnum=?,aparea=?,rentprice=?,status=? where id=?",
                newFlat.getCity(), newFlat.getStreet(), newFlat.getHouseNum(), newFlat.getFloor(), newFlat.getApNum(),
                newFlat.getApArea(), newFlat.getRentPrice(), newFlat.getStatus(), id);
    }

}
