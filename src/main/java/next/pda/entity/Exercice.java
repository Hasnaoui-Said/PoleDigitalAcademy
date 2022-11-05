package next.pda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import next.pda.enu.StatusExercice;

@Entity
@Table
public class Exercice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long exercice_id;
    private String annee;
    @Temporal(value = TemporalType.DATE)
    private Date dateDebut;
    @Temporal(value = TemporalType.DATE)
    private Date dateFin;
    @Enumerated(value = EnumType.STRING)
    private StatusExercice status;

    @ManyToMany(mappedBy = "exercices",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Activity> activities = new ArrayList<Activity>();
    public Exercice() {
    }

    public Exercice(String annee, Date dateDebut, Date dateFin, StatusExercice status, Activity activities) {
        this.annee = annee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
        this.activities.add(activities);
    }

    public long getExercice_id() {
        return exercice_id;
    }

    public void setExercice_id(long exercice_id) {
        this.exercice_id = exercice_id;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
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

    public StatusExercice getStatus() {
        return status;
    }

    public void setStatus(StatusExercice status) {
        this.status = status;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "exercice_id=" + exercice_id +
                ", annee='" + annee + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", status=" + status+
                '}';
    }
}
