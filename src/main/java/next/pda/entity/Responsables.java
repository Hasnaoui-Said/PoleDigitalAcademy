package next.pda.entity;

import jakarta.persistence.*;
import next.pda.enu.TypesResponsable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "user_id")
public class Responsables extends Personnes implements Serializable {
    private TypesResponsable Type;
    @OneToMany(mappedBy = "responsables")
    private List<Activities> activity = new ArrayList<Activities>();;

    public Responsables() {
    }

    public Responsables(int id, String lastName, String firstName, String email, String phone, boolean is_active, String domaine, TypesResponsable type, List<Activities> activity) {
        super(id, lastName, firstName, email, phone, is_active, domaine);
        Type = type;
        this.activity = activity;
    }

    public TypesResponsable getType() {
        return Type;
    }

    public void setType(TypesResponsable type) {
        Type = type;
    }

    public List<Activities> getActivity() {
        return activity;
    }

    public void setActivity(List<Activities> activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Responsables{" +
                "Type=" + Type +
                ", activity=" + activity +
                '}';
    }
}
