package bg.softuni.artfactory;

import bg.softuni.artfactory.model.entity.Workshop;
import bg.softuni.artfactory.model.view.WorkshopViewModel;
import bg.softuni.artfactory.repository.WorkshopRepository;
import bg.softuni.artfactory.service.WorkshopService;
import bg.softuni.artfactory.service.impl.WorkshopServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WorkshopServiceTest {

    private WorkshopService serviceToTest;

    @Mock
    WorkshopRepository mockWorkshopRepository;

    @BeforeEach
    public void setUp() {
        this.serviceToTest = new WorkshopServiceImpl(mockWorkshopRepository, new ModelMapper());
    }

    @Test
    public void testFindAll() {
        //Arrange
        Workshop workshopEntity = new Workshop();
        workshopEntity.setName("Test workshop");
        workshopEntity.setDescription("Test description");
        workshopEntity.setImageUrl("https://res.cloudinary.com/the-potential/image/upload/v1595087223/art-factory/workshops/top-view-photo-of-person-weaving-using-hand-loom-4219651_agzxhb.jpg");
        workshopEntity.setPrice(new BigDecimal(25));
        workshopEntity.setStartsOn(LocalDateTime.of(2020,8,29,5,0, 0));
        workshopEntity.setEndsOn(LocalDateTime.of(2020, 8, 29, 11,0, 0));
        workshopEntity.setMaxPlaces(3);

        when(mockWorkshopRepository.findAll()).
                thenReturn(List.of(workshopEntity));

        // act
        List<WorkshopViewModel> workshopModel = serviceToTest.findAllWorkshops();

        // assert
        Assertions.assertEquals(1, workshopModel.size());
        WorkshopViewModel actualModel = workshopModel.get(0);

        Assertions.assertEquals(workshopEntity.getName(), actualModel.getName());
        Assertions.assertEquals(workshopEntity.getDescription(), actualModel.getDescription());
        Assertions.assertEquals(workshopEntity.getImageUrl(), actualModel.getImageUrl());
        Assertions.assertEquals(workshopEntity.getStartsOn(), actualModel.getStartsOn());
        Assertions.assertEquals(workshopEntity.getEndsOn(), actualModel.getEndsOn());
        Assertions.assertEquals(workshopEntity.getPrice(), actualModel.getPrice());
        Assertions.assertEquals(workshopEntity.getMaxPlaces(), actualModel.getMaxPlaces());
    }

}
