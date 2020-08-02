package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;

import static bg.softuni.artfactory.constant.Constants.*;

import javax.validation.constraints.NotNull;

public class ActivityAddBindingModel {

    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 4, message = MIN_LENGTH)
    private String name;
    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 4, message = MIN_LENGTH)
    @Length(max = 1800, message = MAX_LENGTH)
    private String description;

    public ActivityAddBindingModel() {
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

}