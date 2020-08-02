package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

import static bg.softuni.artfactory.constant.Constants.*;

public class VideoAddBindingModel {

    @NotNull(message = MANDATORY_FIELD)
    @URL(message = INVALID_URL)
    private String thumbnail;
    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 3, message = MIN_LENGTH)
    private String title;
    @NotNull(message = MANDATORY_FIELD)
    private String youtubeStamp;

    public VideoAddBindingModel() {
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