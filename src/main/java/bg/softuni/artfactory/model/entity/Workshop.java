package bg.softuni.artfactory.model.entity;

import bg.softuni.artfactory.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "workshops")
public class Workshop extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @NotNull
    @Column(name = "image_url")
    private String imageUrl;
    @NotNull
    @Column(name = "price")
    @DecimalMin(value = "0")
    private BigDecimal price;
    @NotNull
    @Column(name = "starts_on")
    @FutureOrPresent
    private LocalDateTime startsOn;
    @NotNull
    @Column(name = "ends_on")
    @FutureOrPresent
    private LocalDateTime endsOn;
    @NotNull
    @Column(name = "max_places")
    @Min(value = 1)
    private int maxPlaces;

    public Workshop() {
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