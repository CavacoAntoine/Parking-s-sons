package com.agile.psbackspringboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingFactoryTest {

    @Test
    public void shouldCreateParking() {
        Parking parking1 = new Parking("PARKING 1", new Adresse(), 1,2,3,4,5);
        ParkingFactory parkingFactory = new ParkingFactory();
        parkingFactory.setNom("Parking 1");
        parkingFactory.setAdresse(new Adresse());
        parkingFactory.setNbrNormPlace(1);
        parkingFactory.setNbrHandiPlace(2);
        parkingFactory.setNbrLongPlace(3);
        parkingFactory.setNbrDeuxRPlace(4);
        parkingFactory.setNbrElecPlace(5);

        Assertions.assertEquals(parking1, parkingFactory.create());
    }

}
