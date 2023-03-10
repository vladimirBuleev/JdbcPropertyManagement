package DAO.flat;

import DAO.IDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlatService implements IDao<Flat> {
    private final FlatDao dao;

    public FlatService(FlatDao dao) {
        this.dao = dao;
    }

    public List<Flat> getAll() {
        return dao.getAll();
    }

    public Flat get(int id) {
        return dao.get(id);
    }

    public void add(Flat flat) {
        dao.add(flat);
    }

    public void update(int id, Flat flat) {
        dao.update(id, flat);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
