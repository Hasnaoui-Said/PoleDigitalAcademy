package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Activity;
import next.pda.exeption.Ex;
import next.pda.single.EntitySingletone;

import java.util.List;

public class ActivityDaoImp implements GenericDao<Activity> {
    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public ActivityDaoImp() {

    }

    @Override
    public void add(Activity activity) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(activity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            singletone.closeEntityManager();
        }
    }

    @Override
    public Activity update(Activity activity) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(activity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            singletone.closeEntityManager();
        }
        return activity;
    }

    @Override
    public List<Activity> getAll() {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Query query = entityManager.createQuery("SELECT a FROM Activity a");
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
    public Activity getOne(long Id) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Activity activity = entityManager.find(Activity.class,Id);
            return activity;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
