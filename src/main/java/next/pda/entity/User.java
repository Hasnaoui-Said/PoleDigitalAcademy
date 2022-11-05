package next.pda.entity;

import jakarta.persistence.*;
import next.pda.enu.Roles;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long Id;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    @Enumerated(value = EnumType.STRING)
    private Roles role;
    private boolean is_active;

    public User() {
    }

    public User(String lastName, String firstName, String email, String phone, Roles role, boolean is_active) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.is_active = is_active;
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Id=" + Id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", is_active=" + is_active +
                '}';
    }
}
