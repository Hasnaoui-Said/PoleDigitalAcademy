package next.pda.single;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.loader.ast.spi.SingleEntityLoader;

public class EntitySingletone {
    private static final EntitySingletone signletone;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction transaction;
    static {
        signletone = new EntitySingletone();
    }

    private EntitySingletone(){}
    public static EntitySingletone getInstance(){
        return signletone;
    }
    public EntityManager getEntityManager(){
        if(entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
    public  EntityTransaction getTransaction(){
        transaction = entityManager.getTransaction();
        return transaction;
    }
    public void closeEntityManager(){
        if(entityManager.isOpen() || entityManager!=null){
            entityManager.close();
        }
        entityManager = null;
    }
}
