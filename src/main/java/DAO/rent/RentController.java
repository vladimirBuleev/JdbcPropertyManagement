package DAO.rent;

import DAO.IDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    public List<Rent> getAll() {
        return rentService.getAll();
    }

    @GetMapping("/{id}")
    public Rent get(@PathVariable int id) {
        return rentService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        rentService.delete(id);
    }

    @PostMapping

    public void add(@RequestBody Rent rent) {
        rentService.add(rent);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Rent rent) {
        rentService.update(id, rent);

    }
}
