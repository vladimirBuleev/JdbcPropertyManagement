package DAO;

import java.util.List;

public interface IDao<T> {
    List<T> getAll();

    T get(int id);

    void delete(int id);

    void add(T t);

    void update(int id, T t);


}
