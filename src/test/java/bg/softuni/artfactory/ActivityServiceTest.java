package bg.softuni.artfactory;

import bg.softuni.artfactory.model.entity.Activity;
import bg.softuni.artfactory.model.view.ActivityViewModel;
import bg.softuni.artfactory.repository.ActivityRepository;
import bg.softuni.artfactory.service.ActivityService;
import bg.softuni.artfactory.service.impl.ActivityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {

    private ActivityService serviceToTest;

    @Mock
    ActivityRepository mockActivityRepository;

    @BeforeEach
    public void setUp() {
        this.serviceToTest = new ActivityServiceImpl(mockActivityRepository, new ModelMapper());
    }

    @Test
    public void testFindAll() {
        //Arrange
        Activity activityEntity = new Activity();
        activityEntity.setName("Test activity");
        activityEntity.setDescription("Test description");

        when(mockActivityRepository.findAll()).
                thenReturn(List.of(activityEntity));

        // act
        List<ActivityViewModel> activityModel = serviceToTest.findAllActivities();

        // assert
        Assertions.assertEquals(1, activityModel.size());
        ActivityViewModel actualModel = activityModel.get(0);

        Assertions.assertEquals(activityEntity.getName(), actualModel.getName());
        Assertions.assertEquals(activityEntity.getDescription(), actualModel.getDescription());
    }

}