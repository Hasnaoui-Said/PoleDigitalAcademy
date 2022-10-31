package next.pda.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")

public class Users implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int Id;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private boolean is_active;

    public Users() {
    }

    public Users(int id, String lastName, String firstName, String email, String phone, boolean is_active) {
        Id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.is_active = is_active;
    }

    public int getId() {
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
