package next.pda.services.serviceImp;

import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.ExerciceDaoImp;
import next.pda.entity.Exercice;
import next.pda.exeption.Ex;
import next.pda.services.GenericService;

import java.util.List;

public class ExerciceServiceImp implements GenericService<Exercice> {
    private GenericDao<Exercice> exerciceDaoImp = new ExerciceDaoImp();
    @Override
    public void add(Exercice exercice) {
        exerciceDaoImp.add(exercice);
    }

    @Override
    public Exercice update(Exercice exercice) {
        exercice = exerciceDaoImp.update(exercice);
        return exercice;
    }

    @Override
    public List<Exercice> getAll() {
        return exerciceDaoImp.getAll();
    }

    @Override
    public Exercice getOneById(long id) {
        Exercice exercice = exerciceDaoImp.getOne(id);
        return exercice;
    }

    @Override
    public Exercice getOneByName(String name) {
        return null;
    }
}
