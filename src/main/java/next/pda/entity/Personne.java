package next.pda.entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table
public class Personne extends User implements Serializable {
    private String Domaine;

    public Personne() {
    }

    public Personne(int id, String lastName, String firstName, String email, String phone, boolean is_active, String domaine) {
        super(id, lastName, firstName, email, phone, is_active);
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
