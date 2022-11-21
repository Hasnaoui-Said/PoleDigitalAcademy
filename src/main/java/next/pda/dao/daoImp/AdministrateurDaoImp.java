package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Administrateur;
import next.pda.single.EntitySingletone;

import java.util.List;

public class AdministrateurDaoImp implements GenericDao<Administrateur> {
    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public AdministrateurDaoImp() {
    }

    @Override
    public Administrateur add(Administrateur administrateur) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(administrateur);
            transaction.commit();
            return administrateur;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        singletone.getEntityManager();
        singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(administrateur);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            singletone.closeEntityManager();
        }
        return administrateur;
    }

    @Override
    public List<Administrateur> getAll() {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Query query = entityManager.createQuery("SELECT a FROM Administrateur a");
            transaction.commit();
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
    public Administrateur getOne(long Id) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Administrateur administrateur = entityManager.find(Administrateur.class,Id);
            transaction.commit();
            return administrateur;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
