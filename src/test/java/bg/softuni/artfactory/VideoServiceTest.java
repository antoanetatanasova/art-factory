package bg.softuni.artfactory;

import bg.softuni.artfactory.model.entity.Video;
import bg.softuni.artfactory.model.view.VideoViewModel;
import bg.softuni.artfactory.repository.VideoRepository;
import bg.softuni.artfactory.service.VideoService;
import bg.softuni.artfactory.service.impl.VideoServiceImpl;
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
public class VideoServiceTest {

    private VideoService serviceToTest;

    @Mock
    VideoRepository mockVideoRepository;

    @BeforeEach
    public void setUp() {
        this.serviceToTest = new VideoServiceImpl(mockVideoRepository, new ModelMapper());
    }

    @Test
    public void testFindAll() {
        //Arrange
        Video videoEntity = new Video();
        videoEntity.setThumbnail("https://res.cloudinary.com/the-potential/image/upload/v1595087223/art-factory/workshops/top-view-photo-of-person-weaving-using-hand-loom-4219651_agzxhb.jpg");
        videoEntity.setTitle("Test video");
        videoEntity.setYoutubeStamp("UdCCmhq_Xco");

        when(mockVideoRepository.findAll()).
                thenReturn(List.of(videoEntity));

        // act
        List<VideoViewModel> videoModel = serviceToTest.findAllVideos();

        // assert
        Assertions.assertEquals(1, videoModel.size());
        VideoViewModel actualModel = videoModel.get(0);

        Assertions.assertEquals(videoEntity.getTitle(), actualModel.getTitle());
        Assertions.assertEquals(videoEntity.getThumbnail(), actualModel.getThumbnail());
        Assertions.assertEquals(videoEntity.getYoutubeStamp(), actualModel.getYoutubeStamp());
    }

}