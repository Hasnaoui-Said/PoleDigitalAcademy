package next.pda.services;

import next.pda.entity.Activity;

import java.util.List;

public interface ActivityService {
    public void add(Activity activity);
    public void add(Activity activity, List<Integer> exercises, int idRes);
    public Activity update(Activity activity, List<Integer> exercises, int idRes);
    public Activity update(Activity activity);

    public List<Activity> getAll();

    public Activity getOneById(long id);
    public Activity getOneByName(String name);
}
