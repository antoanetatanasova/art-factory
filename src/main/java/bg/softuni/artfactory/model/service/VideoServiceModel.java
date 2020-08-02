package bg.softuni.artfactory.model.service;

public class VideoServiceModel extends BaseServiceModel {

    private String thumbnail;
    private String title;
    private String youtubeStamp;

    public VideoServiceModel() {
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYoutubeStamp() {
        return youtubeStamp;
    }

    public void setYoutubeStamp(String youtubeStamp) {
        this.youtubeStamp = youtubeStamp;
    }

}