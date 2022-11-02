package com.agile.psbackspringboot.comparator;

import com.agile.psbackspringboot.model.Parking;

import java.util.Comparator;

public class ParkingSortByName implements Comparator<Parking> {

    @Override
    public int compare(Parking o1, Parking o2) {
        if(o1.equals(o2)) return 0;
        return o1.getNom().compareTo(o2.getNom());
    }
}
