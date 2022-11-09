package com.agile.psbackspringboot.model;

import com.agile.psbackspringboot.enums.TypeCar;
import com.agile.psbackspringboot.exceptions.PlaceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParkingTests {

    @Test
    public void should_create_parking() {
        Parking parking = new Parking();
        Assertions.assertTrue(parking != null && parking.getNom().equals("EMPTY") && parking.getAdresse() != null && parking.getPlaces() != null && parking.getPlaces().size() == 0);

        parking = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);
        Assertions.assertTrue(parking != null && parking.getNom().equals("Parking 1") && parking.getAdresse() != null && parking.getPlaces() != null && parking.getPlaces().size() == 15);
    }

    @Test
    public void should_get_All_place_libre_for_type() {
        Parking parking = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);
        Assertions.assertEquals(1, parking.searchPlaceLibre(TypeCar.NORMALE).size());
        Assertions.assertEquals(2, parking.searchPlaceLibre(TypeCar.HANDICAPE).size());
        Assertions.assertEquals(3, parking.searchPlaceLibre(TypeCar.LONG).size());
        Assertions.assertEquals(4, parking.searchPlaceLibre(TypeCar.DEUX_ROUES).size());
        Assertions.assertEquals(5, parking.searchPlaceLibre(TypeCar.ELECTRIQUE).size());
    }

    @Test
    public void should_return_list_of_place_of_type() {
        Parking parking = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);
        Assertions.assertEquals(1,parking.searchPlaceLibre(TypeCar.NORMALE).size());
        Assertions.assertEquals(2, parking.searchPlaceLibre(TypeCar.HANDICAPE).size());
        Assertions.assertEquals(3, parking.searchPlaceLibre(TypeCar.LONG).size());
        Assertions.assertEquals(4, parking.searchPlaceLibre(TypeCar.DEUX_ROUES).size());
        Assertions.assertEquals(5, parking.searchPlaceLibre(TypeCar.ELECTRIQUE).size());
        try{
            parking.occuperPlace(1);
            Assertions.assertEquals(0,parking.searchPlaceLibre(TypeCar.NORMALE).size());
            parking.occuperPlace(4);
            Assertions.assertEquals(2, parking.searchPlaceLibre(TypeCar.LONG).size());
        } catch (PlaceNotFoundException e) {
            Assertions.fail();
        }
    }

    @Test
    public void should_change_status_of_place() {
        Parking parking = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);
        try{
            parking.occuperPlace(1);
            Assertions.assertFalse(parking.getPlaces().get(0).isLibre());
            parking.libererPlace(1);
            Assertions.assertTrue(parking.getPlaces().get(0).isLibre());
        } catch (PlaceNotFoundException e) {
            Assertions.fail();
        }
    }

    @Test
    public void shouldBeEquals() {
        Parking parking1 = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);
        Parking parking2 = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);

        Assertions.assertEquals(parking1, parking2);
    }

    @Test
    public void shouldNotBeEquals() {
        Parking parking1 = new Parking("Parking 1", new Adresse(), 1,2,3,4,5);
        Parking parking2 = new Parking("Parking 2", new Adresse(), 1,2,3,4,5);

        Assertions.assertNotEquals(parking1, parking2);

        parking2.setNom("Parking 1");
        parking2.setPlaces(new ArrayList<>());

        Assertions.assertNotEquals(parking1, parking2);
    }

}
