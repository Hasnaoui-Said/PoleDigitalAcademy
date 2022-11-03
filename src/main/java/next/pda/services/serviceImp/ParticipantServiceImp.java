package next.pda.services.serviceImp;

import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.ParticipantDaoImp;
import next.pda.entity.Participant;
import next.pda.services.GenericService;

import java.util.List;

public class ParticipantServiceImp implements GenericService<Participant> {

    private GenericDao<Participant> participantDao = new ParticipantDaoImp();

    public ParticipantServiceImp() {
    }

    @Override
    public void add(Participant participant) {
        participantDao.add(participant);
    }

    @Override
    public Participant update(Participant participant) {
        participant =participantDao.update(participant);
        return participant;
    }

    @Override
    public List<Participant> getAll() {
        return participantDao.getAll();
    }

    @Override
    public Participant getOneById(long id) {
        Participant participant =participantDao.getOne(id);
        return participant;
    }

    @Override
    public Participant getOneByName(String name) {
        return null;
    }
}
