package next.pda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import next.pda.enu.StatusExercice;

@Entity
@Table
public class Exercices implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long exercice_id;
    private String annee;
    private Date dateDebut;
    private Date dateFin;
    private StatusExercice status;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Activities> activities = new ArrayList<Activities>();
    public Exercices() {
    }

    public Exercices(long exercice_id, String annee, Date dateDebut, Date dateFin, StatusExercice status, List<Activities> activities) {
        this.exercice_id = exercice_id;
        this.annee = annee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
        this.activities = activities;
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

    public List<Activities> getActivities() {
        return activities;
    }

    public void setActivities(List<Activities> activities) {
        this.activities = activities;
    }


}
