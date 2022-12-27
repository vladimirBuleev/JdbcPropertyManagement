package DAO.client;

import DAO.Dao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService implements Dao<Client> {
    private final ClientDao dao;

    public ClientService(ClientDao dao) {
        this.dao = dao;
    }

    public List<Client> getAll() {
        return dao.getAll();
    }

    public List<Client> get(int id) {
        return dao.get(id);
    }

    public void add(Client client) {
        dao.add(client);
    }

    public void update(int id, Client client) {
        dao.update(id, client);
    }

    public void delete(int id) {
        dao.delete(id);
    }


}
