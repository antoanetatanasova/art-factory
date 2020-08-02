package bg.softuni.artfactory.service;

import bg.softuni.artfactory.model.service.VideoServiceModel;
import bg.softuni.artfactory.model.view.VideoViewModel;

import java.util.List;

public interface VideoService {

    void addVideo(VideoServiceModel videoServiceModel);

    List<VideoViewModel> findAllVideos();

    VideoViewModel findById(Long id);

    void delete(Long id);
}
