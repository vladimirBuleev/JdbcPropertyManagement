package DAO.client;

import DAO.Dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDao implements Dao {
    private List<Client> clients = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    public ClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> getAll() {
        clients =jdbcTemplate.query("select * from client", new ClientRowMapper());
        return clients;
    }

    public List<Client> get(int id) {
        clients = jdbcTemplate.query("select * from client where id=?", new ClientRowMapper(), id);
        return clients;
    }


    public void add(Client client) {
        jdbcTemplate.update("insert into client(name,surname,middlename,passport,telephone_number) values(?,?,?,?,?)", client.getName(), client.getSurname(),
                client.getMiddleName(), client.getPassport(), client.getTelNumber());
    }

    public void update(int id, Client newClient) {
        jdbcTemplate.update("update client set name=?,surname=?,middlename=?,passport=?,telephone_number=? where id=?",
                newClient.getName(), newClient.getSurname(), newClient.getMiddleName(), newClient.getPassport(), newClient.getTelNumber(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from client where id=?", id);

    }
}