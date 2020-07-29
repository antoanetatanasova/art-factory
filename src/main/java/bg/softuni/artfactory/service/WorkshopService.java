package bg.softuni.artfactory.service;

import bg.softuni.artfactory.model.service.WorkshopServiceModel;
import bg.softuni.artfactory.model.view.WorkshopViewModel;

import java.util.List;

public interface WorkshopService {

    void addWorkshop(WorkshopServiceModel workshopServiceModel);

    List<WorkshopViewModel> findAllWorkshops();

    WorkshopViewModel findById(Long id);

    void delete(Long id);

}