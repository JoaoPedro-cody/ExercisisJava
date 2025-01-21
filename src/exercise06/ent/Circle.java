package exercise06.ent;

import exercise06.ent.enums.Color;

public class Circle extends Shape {
    private Double radius;
    private static final double pi = Math.PI;

    public Circle() {
        super();
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return pi * (radius * radius);
    }
}
