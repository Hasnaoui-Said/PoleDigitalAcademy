package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.entity.User;

import java.util.List;

public class UserDaoImp{
    private EntityManager entityManager;
    public UserDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void add(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT r FROM  User r");
        return query.getResultList();
    }

    public User getOne(long Id) {
        User user = entityManager.find(User.class,Id);
        return user;
    }
}
