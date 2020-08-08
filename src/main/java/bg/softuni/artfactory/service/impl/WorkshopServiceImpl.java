package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.entity.Workshop;
import bg.softuni.artfactory.model.service.WorkshopServiceModel;
import bg.softuni.artfactory.model.view.WorkshopViewModel;
import bg.softuni.artfactory.repository.WorkshopRepository;
import bg.softuni.artfactory.service.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;
    private final ModelMapper modelMapper;

    public WorkshopServiceImpl(WorkshopRepository workshopRepository, ModelMapper modelMapper) {
        this.workshopRepository = workshopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addWorkshop(WorkshopServiceModel workshopServiceModel) {
        Workshop workshop = this.modelMapper
                .map(workshopServiceModel, Workshop.class);

        this.workshopRepository.saveAndFlush(workshop);
    }

    @Override
    public List<WorkshopViewModel> findAllWorkshops() {
        List<Workshop> workshops = this.workshopRepository.findAll();
        return workshops.stream().map(workshop -> this.modelMapper
                .map(workshop, WorkshopViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public WorkshopViewModel findById(Long id) {
        return this.workshopRepository
                .findById(id)
                .map(workshop -> this.modelMapper.map(workshop, WorkshopViewModel.class))
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        this.workshopRepository.deleteById(id);
    }

}