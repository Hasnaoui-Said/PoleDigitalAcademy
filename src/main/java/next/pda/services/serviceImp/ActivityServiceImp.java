package next.pda.services.serviceImp;

import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.ActivityDaoImp;
import next.pda.entity.Activity;
import next.pda.services.ActivityService;
import next.pda.services.GenericService;

import java.util.List;

public class ActivityServiceImp implements ActivityService, GenericService<Activity> {
    private GenericDao<Activity> activityDao = new ActivityDaoImp();

    public ActivityServiceImp() {
    }

    @Override
    public void add(Activity activity) {
        activityDao.add(activity);
    }

    @Override
    public Activity update(Activity activity) {
        activity =activityDao.update(activity);
        return activity;
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
