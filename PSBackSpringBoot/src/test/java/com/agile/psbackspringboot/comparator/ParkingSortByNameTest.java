package com.agile.psbackspringboot.comparator;

import com.agile.psbackspringboot.model.Adresse;
import com.agile.psbackspringboot.model.Parking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingSortByNameTest {

    @Test
    public void shouldSortParkingByName() {
        List<Parking> parkings = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 100; i++) {
            parkings.add(new Parking("nom"+random.nextInt(100), new Adresse(), 1,1,1,1,1));
        }

        parkings.sort(new ParkingSortByName());

        for(int i = 1; i<100; i++) {
            Assertions.assertTrue(parkings.get(i-1).getNom().compareTo(parkings.get(i).getNom()) <= 0);
        }
    }

}
