package DAO.flat;

import DAO.IDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FlatDao implements IDao<Flat> {
    private final FlatRowMapper flatRowMapper = new FlatRowMapper();
    private final JdbcTemplate jdbcTemplate;

    public FlatDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Flat> getAll() {
        return jdbcTemplate.query("select * from flat", flatRowMapper);
    }

    @Override
    public Flat get(int id) {
        return jdbcTemplate.queryForObject("select * from flat where id = ?", flatRowMapper, id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from flat where id=?", id);
    }

    @Override
    public void add(Flat flat) {
        jdbcTemplate.update("insert into flat(city,street,housenum,floor,apnum,aparea,rentprice,status) values (?,?,?,?,?,?,?,?)",
                flat.getCity(), flat.getStreet(), flat.getHouseNum(), flat.getFloor(),
                flat.getApNum(), flat.getApArea(), flat.getRentPrice(), flat.getStatus());
    }

    @Override
    public void update(int id, Flat newFlat) {
        jdbcTemplate.update("update flat set city=?,street=?,housenum=?,floor=?,apnum=?,aparea=?,rentprice=?,status=? where id=?",
                newFlat.getCity(), newFlat.getStreet(), newFlat.getHouseNum(), newFlat.getFloor(), newFlat.getApNum(),
                newFlat.getApArea(), newFlat.getRentPrice(), newFlat.getStatus(), id);
    }

}
