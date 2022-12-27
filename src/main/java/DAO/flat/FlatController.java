package DAO.flat;

import DAO.Dao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flats")
public class FlatController implements Dao<Flat> {
    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping
    @Override
    public List<Flat> getAll() {
        return flatService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public List<Flat> get(@PathVariable int id) {
        return flatService.get(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable int id) {
        flatService.delete(id);

    }

    @PostMapping
    @Override
    public void add(@RequestBody Flat flat) {
        flatService.add(flat);

    }

    @PutMapping("/{id}")
    @Override
    public void update(@PathVariable int id, @RequestBody Flat flat) {
        flatService.update(id, flat);

    }
}
