package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static bg.softuni.artfactory.constant.Constants.*;

public class WorkshopAddBindingModel {

    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 3, message = MIN_LENGTH)
    private String name;
    private String description;
    @NotNull(message = MANDATORY_FIELD)
    @URL(message = INVALID_URL)
    private String imageUrl;
    @NotNull(message = MANDATORY_FIELD)
    @DecimalMin(value = "0", message = INVALID_NUMBER)
    private BigDecimal price;
    @NotNull(message = MANDATORY_FIELD)
    @FutureOrPresent(message = INVALID_DATE_TIME)
    private LocalDateTime startsOn;
    @NotNull(message = MANDATORY_FIELD)
    @FutureOrPresent(message = INVALID_DATE_TIME)
    private LocalDateTime endsOn;
    @NotNull(message = MANDATORY_FIELD)
    @Min(value = 1, message = INVALID_NUMBER)
    private int maxPlaces;

    public WorkshopAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getStartsOn() {
        return startsOn;
    }

    public void setStartsOn(LocalDateTime startsOn) {
        this.startsOn = startsOn;
    }

    public LocalDateTime getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(LocalDateTime endsOn) {
        this.endsOn = endsOn;
    }

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public void setMaxPlaces(int maxPlaces) {
        this.maxPlaces = maxPlaces;
    }

}