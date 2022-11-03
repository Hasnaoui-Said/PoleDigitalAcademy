package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.entity.Activity;
import next.pda.entity.Participant;

import java.util.List;

public class ParticipantDaoImp implements GenericDao<Participant> {

    private EntityManager entityManager;
    public ParticipantDaoImp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pda_data");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Participant participant) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(participant);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Participant update(Participant participant) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(participant);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return participant;
    }

    @Override
    public List<Participant> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM  Participant e");
        return query.getResultList();
    }

    @Override
    public Participant getOne(long Id) {
        Participant participant = entityManager.find(Participant.class,Id);
        return participant;
    }
}
