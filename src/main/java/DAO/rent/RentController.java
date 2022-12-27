package DAO.rent;

import DAO.Dao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController implements Dao<Rent> {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    @Override
    public List<Rent> getAll() {
        return rentService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public List<Rent> get(@PathVariable int id) {
        return rentService.get(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable int id) {
        rentService.delete(id);
    }

    @PostMapping
    @Override
    public void add(@RequestBody Rent rent) {
        rentService.add(rent);

    }

    @PutMapping("/{id}")
    @Override
    public void update(@PathVariable int id, @RequestBody Rent rent) {
        rentService.update(id, rent);

    }
}
