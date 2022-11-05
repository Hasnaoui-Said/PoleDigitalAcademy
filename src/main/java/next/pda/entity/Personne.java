package next.pda.entity;

import jakarta.persistence.*;
import next.pda.enu.Roles;

import java.io.Serializable;
@Entity
@Table
public class Personne extends User implements Serializable {
    private String Domaine;

    public Personne() {
    }

    public Personne(String lastName, String firstName, String email, String phone, Roles role, boolean is_active, String domaine) {
        super(lastName, firstName, email, phone, role, is_active);
        Domaine = domaine;
    }

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String domaine) {
        Domaine = domaine;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "Domaine='" + Domaine + '\'' +
                '}';
    }
}
