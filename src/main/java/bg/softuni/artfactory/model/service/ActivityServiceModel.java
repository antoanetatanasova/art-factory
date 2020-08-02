package bg.softuni.artfactory.model.service;

public class ActivityServiceModel extends BaseServiceModel {

    private String name;
    private String description;

    public ActivityServiceModel() {
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