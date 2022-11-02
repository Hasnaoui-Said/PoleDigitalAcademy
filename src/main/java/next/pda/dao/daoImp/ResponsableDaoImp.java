package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Responsable;

import java.util.List;

public class ResponsableDaoImp implements GenericDao<Responsable> {
    private EntityManager entityManager;
    public ResponsableDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Responsable responsable) {
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
    public Responsable update(Responsable responsable) {
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
    public List<Responsable> getAll(Responsable responsable) {
        Query query = entityManager.createQuery("SELECT r FROM  Responsable  r");
        return query.getResultList();
    }

    @Override
    public Responsable getOne(long Id) {
        Responsable responsable = entityManager.find(Responsable.class,Id);
        return responsable;
    }
}
