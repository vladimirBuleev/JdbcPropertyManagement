package DAO.client;

import DAO.IDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController  {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable int id) {
        return clientService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        clientService.delete(id);

    }

    @PostMapping
    public void add(@RequestBody Client client) {
        clientService.add(client);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Client client) {
        clientService.update(id, client);

    }
}
