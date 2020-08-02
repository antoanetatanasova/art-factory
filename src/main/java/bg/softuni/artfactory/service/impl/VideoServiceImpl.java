package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.entity.Video;
import bg.softuni.artfactory.model.service.VideoServiceModel;
import bg.softuni.artfactory.model.view.VideoViewModel;
import bg.softuni.artfactory.repository.VideoRepository;
import bg.softuni.artfactory.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final ModelMapper modelMapper;

    public VideoServiceImpl(VideoRepository videoRepository, ModelMapper modelMapper) {
        this.videoRepository = videoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addVideo(VideoServiceModel videoServiceModel) {
        Video video = this.modelMapper.map(videoServiceModel, Video.class);
        this.videoRepository.saveAndFlush(video);
    }

    @Override
    public List<VideoViewModel> findAllVideos() {
        return this.videoRepository.findAll().stream().map(video -> this.modelMapper
                .map(video, VideoViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public VideoViewModel findById(Long id) {
        return this.videoRepository
                .findById(id)
                .map(video -> this.modelMapper
                .map(video, VideoViewModel.class))
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        this.videoRepository.deleteById(id);
    }

}