package bg.softuni.artfactory.model.view;

public class VideoViewModel {

    private Long id;
    private String thumbnail;
    private String title;
    private String youtubeStamp;

    public VideoViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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