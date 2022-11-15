package next.pda.dao;

import next.pda.entity.Activity;
import next.pda.entity.Participant;
import next.pda.enu.Genre;

import java.util.Date;
import java.util.List;

public interface ParticipantRepository {
    List<Participant> filter(long activity_id,Date dateDebut,Date dateFin,Genre genre);
}
