package next.pda.dao.repositoryImp;

import jakarta.persistence.*;
import next.pda.dao.AdminRepository;
import next.pda.entity.Administrateur;
import next.pda.single.EntitySingletone;

public class AdministrateurRepoImp implements AdminRepository {
    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public AdministrateurRepoImp() {

    }

    @Override
    public Administrateur findByEmailAndPassword(String email) throws Exception {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE (a.email like :email or a.login like:email)");
        query.setParameter("email",email);
        try {
            Administrateur administrateur = (Administrateur) query.getSingleResult();
            return  administrateur;
        }catch (Exception e){
            throw new Exception("Login not found");
        }finally {
            singletone.closeEntityManager();
        }
    }

    @Override
    public Administrateur findByEmail(String email) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        try {
            Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE a.email like :email");
            query.setParameter("email",email);
            Administrateur administrateur = (Administrateur) query.getSingleResult();
            return administrateur;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }

    @Override
    public Administrateur findByPassword(String password) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        try {
            Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE a.password like :password");
            query.setParameter("password",password);
            Administrateur administrateur = (Administrateur) query.getSingleResult();
            return administrateur;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
