package DAO.flat;

import DAO.IDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flats")
public class FlatController {
    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping
    public List<Flat> getAll() {
        return flatService.getAll();
    }

    @GetMapping("/{id}")
    public Flat get(@PathVariable int id) {
        return flatService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        flatService.delete(id);

    }

    @PostMapping
    public void add(@RequestBody Flat flat) {
        flatService.add(flat);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Flat flat) {
        flatService.update(id, flat);

    }
}
