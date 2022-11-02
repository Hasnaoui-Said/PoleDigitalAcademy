package next.pda.dao;

import java.util.List;

public interface GenericDao<T>  {
    public void add(T c);
    public T update(T c);
    public List<T> getAll(T c);
    public T getOne(long Id);
}
