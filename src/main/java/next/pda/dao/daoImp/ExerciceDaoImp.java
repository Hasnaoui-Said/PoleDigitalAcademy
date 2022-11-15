package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Exercice;
import next.pda.single.EntitySingletone;

import java.util.List;

public class ExerciceDaoImp implements GenericDao<Exercice> {

    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public ExerciceDaoImp() {
    }

    @Override
    public void add(Exercice exercice) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(exercice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            singletone.closeEntityManager();
        }

    }

    @Override
    public Exercice update(Exercice exercice) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try{
            entityManager.merge(exercice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            singletone.closeEntityManager();
        }
        return exercice;
    }

    @Override
    public List<Exercice> getAll() {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try{
            Query query = entityManager.createQuery("SELECT e FROM  Exercice e");
            transaction.commit();
            return query.getResultList();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }

    @Override
    public Exercice getOne(long Id) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Exercice exercice = entityManager.find(Exercice.class,Id);
            transaction.commit();
            return exercice;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
