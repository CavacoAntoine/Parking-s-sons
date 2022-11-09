package com.agile.psbackspringboot.comparator;

import com.agile.psbackspringboot.model.Place;

import java.util.Comparator;

public class PlaceSortByNumero implements Comparator<Place> {
    @Override
    public int compare(Place o1, Place o2) {
        return Integer.compare(o1.getNumero(), o2.getNumero());
    }
}
