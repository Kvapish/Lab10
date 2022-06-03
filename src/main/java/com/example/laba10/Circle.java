package com.example.laba10;

public class Circle {

    public double a = 20;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public static double CorrectRadius(String value) {
        double side = -1;
        try {
            side = Double.parseDouble(value) > 0 ? Double.parseDouble(value) : -1;
        } catch (Exception exception) {

        }
        return side;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius > 0 ? radius : -1;
    }

    @Override
    public String toString() {
        return getRadius() > 0 ? System.lineSeparator() + "Circle{" +
                "Radius = " + radius +
                " , Square = " + getSquare() +
                " , Perimeter = " + getPerimeter() +
                '}' : "Error circle (radius = " + getRadius() + ").";
    }

    public double getSquare() {
        return getRadius() * getRadius() * Math.PI;
    }

    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

}
