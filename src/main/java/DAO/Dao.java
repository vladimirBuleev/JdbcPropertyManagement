package DAO;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    List<T> get(int id);

    void delete(int id);

}
