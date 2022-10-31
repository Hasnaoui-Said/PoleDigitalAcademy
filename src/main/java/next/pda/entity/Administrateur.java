package next.pda.entity;

public class Administrateur extends Users{
    private String login;
    private String password;

    public Administrateur() {

    }

    public Administrateur(int id, String lastName, String firstName, String email, String phone, boolean is_active, String login, String password) {
        super(id, lastName, firstName, email, phone, is_active);
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
