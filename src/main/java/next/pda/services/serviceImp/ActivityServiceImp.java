package next.pda.services.serviceImp;

import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.ActivityDaoImp;
import next.pda.entity.Activity;
import next.pda.services.ActivityService;
import next.pda.services.ExerciseService;
import next.pda.services.GenericService;
import next.pda.services.ResponsableService;

import java.util.List;

public class ActivityServiceImp implements ActivityService, GenericService<Activity> {
    private GenericDao<Activity> activityDao = new ActivityDaoImp();
    private ExerciseService exerciseService = new ExerciceServiceImp();
    private ResponsableService responsableService = new ResponsableServiceImp();


    public ActivityServiceImp() {
    }

    @Override
    public void add(Activity activity) {
        activityDao.add(activity);
    }
    @Override
    public Activity add(Activity activity, List<Integer> exercises, int idRes) {
        try {
            for (Integer ex: exercises)
                activity.getExercices().add(this.exerciseService.getOneById(ex));
            if(idRes != -1)
                activity.setResponsables(this.responsableService.getOneById(idRes));
            activityDao.add(activity);
            return activity;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Activity update(Activity activity, List<Integer> exercises, int idRes) {
        for (Integer ex: exercises)
            activity.getExercices().add(this.exerciseService.getOneById(ex));
        if(idRes != -1)
            activity.setResponsables(this.responsableService.getOneById(idRes));
        return activityDao.update(activity);
    }

    @Override
    public Activity update(Activity activity) {
        return activityDao.update(activity);
    }

    @Override
    public List<Activity> getAll() {
        return activityDao.getAll();
    }

    @Override
    public Activity getOneById(long id) {
       Activity activity =activityDao.getOne(id);
        return activity;
    }

    @Override
    public Activity getOneByName(String name) {
        return null;
    }
}
