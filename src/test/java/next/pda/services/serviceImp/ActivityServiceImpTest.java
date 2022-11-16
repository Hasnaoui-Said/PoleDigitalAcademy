package next.pda.services.serviceImp;

import next.pda.entity.Activity;
import next.pda.enu.TypesActivity;
import next.pda.services.ActivityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ActivityServiceImpTest {

    @Test
    void add() throws ParseException {
        Date date_debut =new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-29");
        Date date_fin =new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-8");
        Activity activity1 = new Activity("activité 11","Intervention",date_debut,date_fin,true, TypesActivity.valueOf("FORMATION"),null,null,null);
        ActivityService activityService= new ActivityServiceImp();
        Activity result=activityService.add(activity1,new ArrayList<>(),1);
        Assertions.assertNotNull(result);
    }

    @Test
    void update() {

    }

    @Test
    void getAll() {
    }

    @Test
    void getOneById() {
    }

    @Test
    void getOneByName() {
    }
}