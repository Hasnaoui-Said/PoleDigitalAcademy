package next.pda.services;

import next.pda.entity.Responsable;

import java.util.List;

public interface ResponsableService {
    void add(Responsable responsable);
    Responsable update(Responsable responsable);
    List<Responsable> getAll();
    Responsable getOneById(long id);
    Responsable getOneByName(String name);
}
