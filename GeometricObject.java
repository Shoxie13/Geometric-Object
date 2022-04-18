package workshop3;

public abstract class GeometricObject {
    private String color = "white";
    private Boolean filled;

    GeometricObject() {};
    protected GeometricObject(String color, Boolean filled) {};

    //Accessor and Mutator for color
    String getColor() {
        return color;
    }
    void setColor(String color) {
        this.color = color;
    };

    //Accessor and Mutator for filled
    Boolean getFilled() {
        return filled;
    }
    void setFilled(Boolean filled) {
        this.filled = filled;
    };
    

    abstract double getArea();
    abstract double getPerimeter();
}
