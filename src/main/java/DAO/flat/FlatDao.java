package DAO.flat;

import DAO.Dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlatDao implements Dao {
    private List<Flat> flats = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    public FlatDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Flat> getAll() {
        flats = jdbcTemplate.query("select * from flat", new FlatRowMapper());
        return flats;
    }

    @Override
    public List<Flat> get(int id) {
        flats = jdbcTemplate.query("select * from flat where id = ?", new FlatRowMapper(), id);
        return flats;
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
