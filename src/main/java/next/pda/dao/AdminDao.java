package next.pda.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import next.pda.entity.Administrateurs;

public class AdminDao {
    private EntityManager entityManager;
    public AdminDao(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addAdmin(Administrateurs admin){
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println("transaction_begin");
        transaction.begin();
        try {
            entityManager.persist(admin);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
