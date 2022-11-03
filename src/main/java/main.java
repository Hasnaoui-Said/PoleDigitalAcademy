import next.pda.entity.Activity;
import next.pda.entity.Administrateur;
import next.pda.entity.Participant;
import next.pda.services.AdminService;
import next.pda.services.serviceImp.ActivityServiceImp;
import next.pda.services.GenericService;
import next.pda.services.serviceImp.AdminServiceImp;
import next.pda.services.serviceImp.ParticipantServiceImp;

public class main {
    public static void main(String[] args) {
        String lastName="salim";
        String firstName="ahmed";
        String email ="ahmed@gmail.com";
        String phone ="123456789";
        boolean isActive= true;
        String login ="ahmed_salim01";
        String password ="azerty";
        Administrateur administrateur = new Administrateur();
        administrateur.setFirstName(firstName);
        administrateur.setLastName(lastName);
        administrateur.setEmail(email);
        administrateur.setPhone(phone);
        administrateur.setIs_active(isActive);
        administrateur.setLogin(login);
        administrateur.setPassword(password);
        AdminService  adminService = new AdminServiceImp();
        Administrateur test = adminService.loginByEmailAndPassword(login,password);
        if(test!=null){
            System.out.println("success");
        }else{
            System.out.println("information inccorect!");
        }
    }
}
