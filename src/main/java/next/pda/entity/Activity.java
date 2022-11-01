package next.pda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table

public class Activity implements Serializable {
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
    private Responsable responsable;
    @ManyToMany(mappedBy = "activities",fetch = FetchType.EAGER)
    private List<Exercice> exercices =new ArrayList<Exercice>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Participant> participants = new ArrayList<Participant>();
    public Activity() {
    }

    public Activity(long id, String title, String description, Date dateDebut, Date dateFin, boolean etat, Responsable responsable, List<Exercice> exercices, List<Participant> participants) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.responsable = responsable;
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

    public Responsable getResponsables() {
        return responsable;
    }

    public void setResponsables(Responsable responsable) {
        this.responsable = responsable;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
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
                ", responsables=" + responsable +
                ", exercices=" + exercices +
                ", participants=" + participants +
                '}';
    }
}