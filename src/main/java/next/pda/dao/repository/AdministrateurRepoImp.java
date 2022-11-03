package next.pda.dao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import next.pda.dao.AdminRepository;
import next.pda.entity.Administrateur;

public class AdministrateurRepoImp implements AdminRepository {
    private EntityManager entityManager;

    public AdministrateurRepoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override
    public Administrateur findByEmailAndPassword(String email, String password) {
        Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE (a.email like :email or a.login like:email) and a.password like :password");
        query.setParameter("email",email);
        query.setParameter("password",password);
        Administrateur administrateur = (Administrateur) query.getSingleResult();

        if(administrateur!=null){
            return administrateur;
        }else {
            return null;
        }
    }

    @Override
    public Administrateur findByEmail(String email) {
        Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE a.email like :email");
        query.setParameter("email",email);
        Administrateur administrateur = (Administrateur) query.getSingleResult();
        return administrateur;
    }

    @Override
    public Administrateur findByPassword(String password) {
        Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE a.password like :password");
        query.setParameter("password",password);
        Administrateur administrateur = (Administrateur) query.getSingleResult();
        return administrateur;
    }
}
