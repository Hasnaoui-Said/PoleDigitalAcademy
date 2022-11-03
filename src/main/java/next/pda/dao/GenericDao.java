package next.pda.dao;

import java.util.List;

public interface GenericDao<T>  {
    void add(T c);
    T update(T c);
    List<T> getAll();
    T getOne(long Id);
}
