package next.pda.services;

import next.pda.entity.Activity;
import next.pda.entity.Participant;

import java.util.List;

public interface ParticipantService {
    void add(Participant participant);
    Participant update(Participant participant);
    List<Participant> getAll();
    Participant getOneById(long id);
    Participant getOneByName(String name);
    List<Participant> getAllByGenre(String genre);
    List<Participant> getAllByDate(String date);
}
