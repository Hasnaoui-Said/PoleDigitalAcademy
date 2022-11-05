package next.pda.entity;

import jakarta.persistence.*;
import next.pda.enu.Roles;

import java.io.Serializable;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class Administrateur extends User implements Serializable {
    private String login;
    private String password;

    public Administrateur() {

    }

    public Administrateur(String lastName, String firstName, String email, String phone, Roles role, boolean is_active, String login, String password) {
        super(lastName, firstName, email, phone, role, is_active);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
