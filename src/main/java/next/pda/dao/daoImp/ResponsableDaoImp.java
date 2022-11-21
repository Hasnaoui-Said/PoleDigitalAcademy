package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Responsable;
import next.pda.single.EntitySingletone;

import java.util.List;

public class ResponsableDaoImp implements GenericDao<Responsable> {
    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public ResponsableDaoImp() {
    }

    @Override
    public Responsable add(Responsable responsable) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(responsable);
            transaction.commit();
            return responsable;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }

    @Override
    public Responsable update(Responsable responsable) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(responsable);
            transaction.commit();
            return responsable;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }

    @Override
    public List<Responsable> getAll() {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Query query = entityManager.createQuery("SELECT r FROM  Responsable  r");
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
    public Responsable getOne(long Id) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Responsable responsable = entityManager.find(Responsable.class,Id);
            return responsable;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
