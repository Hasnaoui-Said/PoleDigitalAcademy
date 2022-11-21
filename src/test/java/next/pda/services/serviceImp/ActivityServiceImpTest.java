package next.pda.services.serviceImp;

import next.pda.entity.Activity;
import next.pda.enu.TypesActivity;
import next.pda.services.ActivityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityServiceImpTest {
    ActivityService activityService;
    @BeforeEach
    public void before(){
        activityService= new ActivityServiceImp();
    }

    @AfterEach
    public void After(){
        activityService = null;
    }

    @Test
    void add() throws ParseException {
        Date date_debut =new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-29");
        Date date_fin =new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-8");
        Activity activity1 = new Activity("activité 12","Intervention",date_debut,date_fin,true, TypesActivity.valueOf("FORMATION"),null,null,null);
        Activity result=activityService.add(activity1,new ArrayList<>(),1);
        assertSame(activity1,result);
    }

    @Test
    public void addNull() throws ParseException {
        Date date_debut =new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-29");
        Date date_fin =new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-8");
        Activity activity1 = new Activity("activité 12","Intervention",date_debut,date_fin,true, TypesActivity.valueOf("FORMATION"),null,null,null);
        Activity result=activityService.add(activity1,new ArrayList<>(),1);
        System.out.println(result);
        assertNull(result);
    }

    @Test
    void addEmpty(){
        Activity activity1 = new Activity();
        Activity result = activityService.add(activity1,new ArrayList<>(),1);
        System.out.println(result);
        assertNotSame(activity1,result);
    }

    @Test
    void update() {
        Activity activity = activityService.getOneById(1);
        activity.setTitle("activité modifiée");
        Activity result = activityService.update(activity,new ArrayList<>(),1);
        assertEquals("activité modifiée",result.getTitle());
    }

    @Test
    void getAll() {
        List<Activity> activityList = activityService.getAll();
        assertNotNull(activityList);
    }

    @Test
    void getOneById(){
        Activity activity = activityService.getOneById(1);
        assertNotNull(activity);
    }
}