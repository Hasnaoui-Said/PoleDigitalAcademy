package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Administrateur;

import java.util.List;

public class AdministrateurDaoImp implements GenericDao<Administrateur> {
    private EntityManager entityManager ;

    public AdministrateurDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Administrateur administrateur) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(administrateur);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(administrateur);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return administrateur;
    }

    @Override
    public List<Administrateur> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Administrateur a");
        return query.getResultList();
    }

    @Override
    public Administrateur getOne(long Id) {
        Administrateur administrateur = entityManager.find(Administrateur.class,Id);
        return administrateur;
    }
}
