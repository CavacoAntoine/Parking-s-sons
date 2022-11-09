package com.agile.psbackspringboot.comparator;

import com.agile.psbackspringboot.enums.TypeCar;
import com.agile.psbackspringboot.model.Adresse;
import com.agile.psbackspringboot.model.Parking;
import com.agile.psbackspringboot.model.Place;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlaceSortByNumeroTest {

    @Test
    public void shouldSortParkingByName() {
        List<Place> places = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 100; i++) {
            places.add(new Place(TypeCar.NORMALE, random.nextInt()));
        }

        places.sort(new PlaceSortByNumero());

        for(int i = 1; i<100; i++) {
            Assertions.assertTrue(places.get(i-1).getNumero() <= places.get(i).getNumero());
        }
    }
}
