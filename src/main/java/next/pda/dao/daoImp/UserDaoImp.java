package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.entity.User;
import next.pda.single.EntitySingletone;

import java.util.List;

public class UserDaoImp{
    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public UserDaoImp() {
    }

    public void add(User user) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            singletone.closeEntityManager();
        }
    }

    public List<User> getAll() {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Query query = entityManager.createQuery("SELECT r FROM  User r");
            return query.getResultList();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }

    public User getOne(long Id) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            User user = entityManager.find(User.class,Id);
            return user;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
