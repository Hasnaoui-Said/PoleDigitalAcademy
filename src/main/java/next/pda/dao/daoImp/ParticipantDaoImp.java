package next.pda.dao.daoImp;

import jakarta.persistence.*;
import next.pda.dao.GenericDao;
import next.pda.dao.ParticipantRepository;
import next.pda.entity.Activity;
import next.pda.entity.Participant;
import next.pda.enu.Genre;
import next.pda.single.EntitySingletone;

import java.util.Date;
import java.util.List;

public class ParticipantDaoImp implements GenericDao<Participant>,ParticipantRepository{

    private EntitySingletone singletone= EntitySingletone.getInstance()  ;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public ParticipantDaoImp() {

    }

    @Override
    public Participant add(Participant participant) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(participant);
            transaction.commit();
            return participant;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Participant update(Participant participant) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
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
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Query query = entityManager.createQuery("SELECT e FROM  Participant e");
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
    public Participant getOne(long Id) {
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Participant participant = entityManager.find(Participant.class,Id);
            return participant;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }

    @Override
    public List<Participant> filter(long activity_id,Date dateDebut,Date dateFin, Genre genre) {

        String query = "SELECT p FROM Participant p join p.activities a where 1=1 ";
        if(activity_id >0){
            query += "and a.id=:activity_id ";
        }if(dateDebut != null){
            query += "and a.dateDebut=:dateDebut ";
        }if(dateFin != null){
            query += "and a.dateFin=:dateFin ";
        }if(genre!=null){
            query += "and p.genre=:genre";
        }
        entityManager = singletone.getEntityManager();
        transaction = singletone.getTransaction();
        transaction.begin();
        try {
            Query a = entityManager.createQuery(query,Activity.class);
            if(activity_id > 0){
                a.setParameter("activity_id",activity_id);
            }if(dateDebut!=null){
                a.setParameter("dateDebut",dateDebut);
            }if(dateFin != null){
                a.setParameter("dateFin",dateFin);
            }if(genre != null){
                a.setParameter("genre",genre);
            }
            return a.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            singletone.closeEntityManager();
        }

    }
}
