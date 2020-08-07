package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.entity.Activity;
import bg.softuni.artfactory.model.service.ActivityServiceModel;
import bg.softuni.artfactory.model.view.ActivityViewModel;
import bg.softuni.artfactory.repository.ActivityRepository;
import bg.softuni.artfactory.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ModelMapper modelMapper;

    public ActivityServiceImpl(ActivityRepository activityRepository, ModelMapper modelMapper) {
        this.activityRepository = activityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addActivity(ActivityServiceModel activityServiceModel) {
        Activity activity = this.modelMapper
                .map(activityServiceModel, Activity.class);
        this.activityRepository.saveAndFlush(activity);
    }

    @Override
    public void editActivity(ActivityServiceModel activityServiceModel, Long id) {


        Activity activity = this.activityRepository.findFirstById(id);
        activity = this.modelMapper
                .map(activityServiceModel, Activity.class);
        this.activityRepository.saveAndFlush(activity);
    }

    @Override
    public List<ActivityViewModel> findAllActivities() {
        return this.activityRepository.findAll().stream().map(activity -> this.modelMapper
                .map(activity, ActivityViewModel.class))
                .collect(Collectors.toList());
    }

}