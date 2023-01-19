package DAO.client;

import DAO.IDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClientDao implements IDao<Client> {
    private final ClientRowMapper clientRowMapper = new ClientRowMapper();
    private final JdbcTemplate jdbcTemplate;

    public ClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> getAll() {
        return jdbcTemplate.query("select * from client", clientRowMapper);
    }

    @Override
    public Client get(int id) {
        return jdbcTemplate.queryForObject("select * from client where id=?", clientRowMapper, id);
    }

    @Override
    public void add(Client client) {
        jdbcTemplate.update("insert into client(name,surname,middlename,passport,telephone_number) values(?,?,?,?,?)", client.getName(), client.getSurname(),
                client.getMiddleName(), client.getPassport(), client.getTelNumber());
    }

    @Override
    public void update(int id, Client newClient) {
        jdbcTemplate.update("update client set name=?,surname=?,middlename=?,passport=?,telephone_number=? where id=?",
                newClient.getName(), newClient.getSurname(), newClient.getMiddleName(), newClient.getPassport(), newClient.getTelNumber(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from client where id=?", id);

    }
}
