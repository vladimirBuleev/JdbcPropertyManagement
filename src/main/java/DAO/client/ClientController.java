package DAO.client;

import DAO.Dao;
import DAO.client.Client;
import DAO.client.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController implements Dao<Client> {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Override
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public List<Client> get(@PathVariable int id) {
        return clientService.get(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable int id) {
        clientService.delete(id);

    }

    @PostMapping
    @Override
    public void add(@RequestBody Client client) {
        clientService.add(client);

    }

    @PutMapping("/{id}")
    @Override
    public void update(@PathVariable int id, @RequestBody Client client) {
        clientService.update(id, client);

    }
}
