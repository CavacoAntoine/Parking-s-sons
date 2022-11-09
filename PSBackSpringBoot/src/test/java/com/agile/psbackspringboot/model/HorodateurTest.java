package com.agile.psbackspringboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class HorodateurTest {

    @Test
    public void shouldBeBad() {
        Horodateur horodateur = new Horodateur(new Voiture(), new Place(), new Date(), new Date(new Date().getTime()-10000), false, false);
        Assertions.assertTrue(horodateur.isBad());

        horodateur = new Horodateur(new Voiture(), new Place(), new Date(), new Date(new Date().getTime()+10000), true, false);
        Assertions.assertTrue(horodateur.isBad());

        horodateur = new Horodateur(new Voiture(), new Place(), new Date(), new Date(new Date().getTime()+10000), false, true);
        Assertions.assertTrue(horodateur.isBad());
    }

    @Test
    public void shouldNotBeBad() {
        Horodateur horodateur = new Horodateur(new Voiture(), new Place(), new Date(), new Date(new Date().getTime()+10000), false, false);
        Assertions.assertFalse(horodateur.isBad());

    }

}
