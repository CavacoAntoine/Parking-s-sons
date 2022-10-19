package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypePlace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceTests {

    @Test
    public void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void should_createPlace() {
        Place place = new Place();
        Assertions.assertTrue(place != null && place.getNumero() == 1 && place.isLibre() && place.getType() == TypePlace.NORMALE);

        place = new Place(TypePlace.DEUX_ROUES, 2);
        Assertions.assertTrue(place != null && place.getNumero() == 2 && place.isLibre() && place.getType() == TypePlace.DEUX_ROUES);
    }

    @Test
    public void should_getType() {
        Place place = new Place();
        Assertions.assertSame(place.getType(), TypePlace.NORMALE);
    }

    @Test
    public void should_be_libre() {
        Place place = new Place();
        Assertions.assertTrue(place.isLibre());
    }

    @Test
    public void should_not_be_libre() {
        Place place = new Place();
        place.setLibre(false);
        Assertions.assertFalse(place.isLibre());
    }

    @Test
    public void should_set_libre() {
        Place place = new Place();
        place.setLibre(false);
        Assertions.assertFalse(place.isLibre());
        place.setLibre(true);
        Assertions.assertTrue(place.isLibre());
    }

    @Test
    public void should_getNumero() {
        Place place = new Place();
        Assertions.assertEquals(1, place.getNumero());
    }


}
