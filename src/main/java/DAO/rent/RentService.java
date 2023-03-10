package DAO.rent;

import DAO.IDao;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RentService implements IDao<Rent> {
    private final RentDao rentDao;

    public RentService(RentDao rentDao) {
        this.rentDao = rentDao;
    }

    @Override
    public List<Rent> getAll() {
        return rentDao.getAll();
    }

    @Override
    public Rent get(int id) {
        return rentDao.get(id);
    }

    @Override
    public void delete(int id) {
        rentDao.delete(id);
    }

    @Override
    public void add(Rent rent) {
        rentDao.add(rent);

    }

    @Override
    public void update(int id, Rent rent) {
        rentDao.update(id, rent);

    }
}
