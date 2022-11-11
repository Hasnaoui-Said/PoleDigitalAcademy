package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.User;

import java.util.List;

public class UserDaoImp implements GenericDao<User> {
    private EntityManager entityManager;
    public UserDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(User responsable) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(responsable);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public User update(User responsable) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(responsable);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return responsable;
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT r FROM  User  r");
        return query.getResultList();
    }

    @Override
    public User getOne(long Id) {
        User responsable = entityManager.find(User.class,Id);
        return responsable;
    }
}
