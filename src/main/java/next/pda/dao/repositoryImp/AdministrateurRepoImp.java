package next.pda.dao.repositoryImp;

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
    public Administrateur findByEmailAndPassword(String email, String password) throws Exception {
        Query query =entityManager.createQuery("SELECT a from Administrateur a WHERE (a.email like :email or a.login like:email)");
        query.setParameter("email",email);
        try {
            Administrateur administrateur = (Administrateur) query.getSingleResult();
            System.out.println(administrateur.toString());
            return  administrateur;
        }catch (Exception e){
            throw new Exception("Login not found");
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
