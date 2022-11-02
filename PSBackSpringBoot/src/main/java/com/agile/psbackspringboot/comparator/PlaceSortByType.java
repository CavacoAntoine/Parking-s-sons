package com.agile.psbackspringboot.comparator;

import com.agile.psbackspringboot.model.Place;

import java.util.Comparator;

public class PlaceSortByType implements Comparator<Place> {
    @Override
    public int compare(Place o1, Place o2) {
        if(o1.equals(o2)) return 0;
        return o1.getType().compareTo(o2.getType());
    }
}
