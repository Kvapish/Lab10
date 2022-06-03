package com.example.laba10;

import java.util.ArrayList;
import java.util.List;

public class CirclesList {
    List<Circle> circles_list;

    public CirclesList() {
        circles_list = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Circles : " + System.lineSeparator() + circles_list;
    }

    public void add(Circle circle) {
        circles_list.add(circle);
    }

    public void remove(int number) {
        if (number < circles_list.size() && number >= 0) {
            circles_list.remove(number);
        }
    }

    public void remove(Circle circle) {
        circles_list.remove(circle);
    }

    public double getAverageSquare() {
        double average = 0;
        for (Circle circle : circles_list) {
            average += circle.getSquare();
        }
        return average / circles_list.size();
    }


    public List<Circle> getCircles_list() {
        return circles_list;
    }
}
