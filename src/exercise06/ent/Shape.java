package exercise06.ent;

import exercise06.ent.enums.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private Color color;

    private List<Shape> shapes = new ArrayList<>();

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double area();
}
