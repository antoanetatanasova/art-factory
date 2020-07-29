package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WorkshopAddBindingModel {

    @NotNull
    @Length(min = 3, message = "Името трябва да пъде по-дълго от {min} символа")
    private String name;
    private String description;
    @NotNull
    @URL(message = "Въведеният адрес е невалиден.")
    private String imageUrl;
    @NotNull
    @DecimalMin(value = "0", message = "Цената трябва да бъде положително число.")
    private BigDecimal price;
    @NotNull
    @FutureOrPresent(message = "Невалидни дата и/или час.")
    private LocalDateTime startsOn;
    @NotNull
    @FutureOrPresent(message = "Невалидни дата и/или час.")
    private LocalDateTime endsOn;
    @NotNull
    @Min(value = 1, message = "Обявете поне {value} място.")
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