package data.client;

import data.DB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDB implements DB {
    private final JdbcTemplate jdbcTemplate;

    public ClientDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void show() {
        List<Client> clients = jdbcTemplate.query("select * from client", new ClientRowMapper());
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void show(int id) {
        List<Client> clients = jdbcTemplate.query("select * from client where id=?",new ClientRowMapper(),id);
        for (Client client : clients) {
            System.out.println(client);
        }

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
