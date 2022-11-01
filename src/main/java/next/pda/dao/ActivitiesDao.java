package next.pda.dao;

import next.pda.entity.Activity;

import java.util.List;

public interface ActivitiesDao {
    public void add(Activity activity);
    public Activity update(Activity activity);
    public void delete(long Id);
    public List<Activity> getAllActivities(Activity activity);
    public Activity getOne(long Id);
}
