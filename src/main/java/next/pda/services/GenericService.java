package next.pda.services;

import java.util.List;

public interface GenericService<T> {
    void add(T t);
    T update(T t);
    List<T> getAll();
    T getOneById(long id);
   T getOneByName(String name);
}
