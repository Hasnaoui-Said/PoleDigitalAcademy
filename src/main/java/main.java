import jakarta.persistence.Query;
import next.pda.dao.AdminRepository;
import next.pda.dao.daoImp.ActivityDaoImp;
import next.pda.dao.daoImp.ParticipantDaoImp;
import next.pda.entity.*;
import next.pda.enu.Genre;
import next.pda.enu.Roles;
import next.pda.enu.TypesActivity;
import next.pda.enu.TypesResponsable;
import next.pda.services.ActivityService;
import next.pda.services.AdminService;
import next.pda.services.ParticipantService;
import next.pda.services.serviceImp.*;
import next.pda.services.GenericService;
import next.pda.single.EntitySingletone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) throws ParseException {
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
        Participant participant=new Participant();
        ActivityService activityService = new ActivityServiceImp();
        ParticipantDaoImp participantDaoImp =new ParticipantDaoImp();
        ParticipantService participantService =new ParticipantServiceImp();
        activity.setDescription("hahahahaha");
        Activity result = activityService.add(activity,new ArrayList<>(),1);
        System.out.println(result.getId());
    }
}
