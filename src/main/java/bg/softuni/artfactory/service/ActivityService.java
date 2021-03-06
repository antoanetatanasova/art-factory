package bg.softuni.artfactory.service;

import bg.softuni.artfactory.model.service.ActivityServiceModel;
import bg.softuni.artfactory.model.view.ActivityViewModel;

import java.util.List;

public interface ActivityService {

    void addActivity(ActivityServiceModel activityServiceModel);

    void editActivity(ActivityServiceModel activityServiceModel, Long id);

    List<ActivityViewModel> findAllActivities();

}