package next.pda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "user_id")
public class Participant extends Personne implements Serializable {
    private String identifiant;
    private String structure;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Activity> activities =new ArrayList<Activity>();
    public Participant() {
    }

    public Participant(int id, String lastName, String firstName, String email, String phone, boolean is_active, String domaine, String identifiant, String structure, List<Activity> activities) {
        super(id, lastName, firstName, email, phone, is_active, domaine);
        this.identifiant = identifiant;
        this.structure = structure;
        this.activities = activities;
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

    @Override
    public String toString() {
        return "Participants{" +
                "identifiant='" + identifiant + '\'' +
                ", structure='" + structure + '\'' +
                ", activities=" + activities +
                '}';
    }
}
