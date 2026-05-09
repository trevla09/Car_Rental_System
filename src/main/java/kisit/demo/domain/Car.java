package kisit.demo.domain;

public class Car {
    private final String id;
    private final String model;
    private boolean isAvailable;

    public Car(String id, String model, boolean isAvailable) {
        this.id = id;
        this.model = model;
        this.isAvailable = isAvailable;
    }

    public boolean canBeRented() {
        return isAvailable;
    }

    public void markAsRented() {
        this.isAvailable = false;
    }

    public String getId()      { return id; }
    public String getModel()   { return model; }
    public boolean isAvailable() { return isAvailable; }
}