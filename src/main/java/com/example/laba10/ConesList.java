package com.example.laba10;

import java.util.ArrayList;

public class ConesList {
    public ArrayList<Cone> list;

    public ConesList() {
        this.list = new ArrayList<>();
    }

    public double getLargestVolume() {
        double maximum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVolume() > maximum) {
                maximum = list.get(i).getVolume();
            }
        }
        return maximum;
    }


    public ArrayList<Cone> getCone_list() {
        return list;
    }
}
