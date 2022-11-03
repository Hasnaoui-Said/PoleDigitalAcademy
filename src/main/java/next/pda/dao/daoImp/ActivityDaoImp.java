package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Activity;

import java.util.List;

public class ActivityDaoImp implements GenericDao<Activity> {
    private EntityManager entityManager;

    public ActivityDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Activity activity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(activity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Activity update(Activity activity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(activity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return activity;
    }

    @Override
    public List<Activity> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Activity a");
        return query.getResultList();
    }

    @Override
    public Activity getOne(long Id) {
        Activity activity = entityManager.find(Activity.class,Id);
        return activity;
    }
}
