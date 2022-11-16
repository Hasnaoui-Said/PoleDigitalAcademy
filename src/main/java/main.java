import next.pda.entity.*;
import next.pda.enu.Genre;
import next.pda.enu.Roles;
import next.pda.enu.TypesResponsable;
import next.pda.services.AdminService;
import next.pda.services.ParticipantService;
import next.pda.services.serviceImp.*;
import next.pda.services.GenericService;

import java.util.List;

public class main {
    public static void main(String[] args) {
        String lastName="elyagoubi";
        String firstName="raouya";
        String email ="raouya@gmail.com";
        String phone ="123456789";
        boolean isActive= true;
        String role = "Participant";
        String domaine ="IT";
        String genre ="male";
        String identifiant="raouya_elya";
        String structur ="structure";
        Responsable responsable = new Responsable();
        Activity activity = new Activity();
        Exercice exercice = new Exercice();
        Participant participant = new Participant();
        AdminService  adminService = new AdminServiceImp();
        GenericService<Activity> activityService = new ActivityServiceImp();
        GenericService<Responsable> responsableService = new ResponsableServiceImp();
        GenericService<Exercice> exerciceService = new ExerciceServiceImp();
        ParticipantService participantService = new ParticipantServiceImp();
        String acti ="Activité3";





    }
}
