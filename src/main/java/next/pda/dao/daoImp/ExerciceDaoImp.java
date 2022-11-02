package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Exercice;

import java.util.List;

public class ExerciceDaoImp implements GenericDao<Exercice> {

    private EntityManager entityManager;

    public ExerciceDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Exercice exercice) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(exercice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public Exercice update(Exercice exercice) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.merge(exercice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return exercice;
    }

    @Override
    public List<Exercice> getAll(Exercice exercice) {
        Query query = entityManager.createQuery("SELECT e FROM  Exercice e");
        return query.getResultList();
    }

    @Override
    public Exercice getOne(long Id) {
        Exercice exercice = entityManager.find(Exercice.class,Id);
        return exercice;
    }
}
