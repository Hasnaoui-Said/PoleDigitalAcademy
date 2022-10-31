package next.pda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table

public class Activities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private long id;
    private String title;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private boolean etat;
    @ManyToOne
    private Responsables responsables;
    @ManyToMany(mappedBy = "activities",fetch = FetchType.EAGER)
    private List<Exercices> exercices =new ArrayList<Exercices>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Participants> participants = new ArrayList<Participants>();
    public Activities() {
    }

    public Activities(long id, String title, String description, Date dateDebut, Date dateFin, boolean etat, Responsables responsables, List<Exercices> exercices, List<Participants> participants) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.responsables = responsables;
        this.exercices = exercices;
        this.participants = participants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Responsables getResponsables() {
        return responsables;
    }

    public void setResponsables(Responsables responsables) {
        this.responsables = responsables;
    }

    public List<Exercices> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercices> exercices) {
        this.exercices = exercices;
    }

    public List<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participants> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", etat=" + etat +
                ", responsables=" + responsables +
                ", exercices=" + exercices +
                ", participants=" + participants +
                '}';
    }
}
