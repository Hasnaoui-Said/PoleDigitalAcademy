package next.pda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import next.pda.enu.Genre;
import next.pda.enu.Roles;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "user_id")
public class Participant extends Personne implements Serializable {
    private String identifiant;
    private String structure;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @ManyToMany(mappedBy = "participants",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Activity> activities =new ArrayList<Activity>();
    public Participant() {
    }

    public Participant(String lastName, String firstName, String email, String phone, Roles role, boolean is_active, String domaine, String identifiant, String structure, Genre genre, Activity activities) {
        super(lastName, firstName, email, phone, role, is_active, domaine);
        this.identifiant = identifiant;
        this.structure = structure;
        this.genre = genre;
        this.activities.add(activities);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Participants{" +
                "identifiant='" + identifiant + '\'' +
                ", structure='" + structure + '\'' +
                '}';
    }
}
