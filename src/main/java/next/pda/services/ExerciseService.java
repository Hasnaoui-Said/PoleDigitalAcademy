package next.pda.services;

import next.pda.entity.Exercice;

import java.util.List;

public interface ExerciseService {
    public void add(Exercice exercice);
    public Exercice update(Exercice activity);

    public List<Exercice> getAll();

    public Exercice getOneById(long id);
    public Exercice getOneByName(String name);
}
