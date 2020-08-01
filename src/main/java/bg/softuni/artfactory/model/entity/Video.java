package bg.softuni.artfactory.model.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "video")
public class Video extends BaseEntity {

    @Column(name = "thumbnail")
    @NotNull
    @URL
    private String thumbnail;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "youtube_url")
    @NotNull
    @URL
    private String youtubeUrl;

    public Video() {
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

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

}