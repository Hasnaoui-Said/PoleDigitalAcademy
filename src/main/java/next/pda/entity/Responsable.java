package next.pda.entity;

import jakarta.persistence.*;
import next.pda.enu.Roles;
import next.pda.enu.TypesResponsable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "user_id")
public class Responsable extends Personne implements Serializable {
    @Enumerated(value = EnumType.STRING)
    private TypesResponsable Type;
    @OneToMany(mappedBy = "responsable")
    private List<Activity> activity = new ArrayList<Activity>();;

    public Responsable() {
    }

    public Responsable(String lastName, String firstName, String email, String phone, Roles role, boolean is_active, String domaine, TypesResponsable type, Activity activity) {
        super(lastName, firstName, email, phone, role, is_active, domaine);
        Type = type;
        this.activity.add(activity);
    }

    public TypesResponsable getType() {
        return Type;
    }

    public void setType(TypesResponsable type) {
        Type = type;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Responsables{" +
                "Type=" + Type +
                '}';
    }
}
