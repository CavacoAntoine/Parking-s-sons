package com.agile.psbackspringboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdresseTests {

    @Test
    public void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void should_create_adresse() {
        Adresse adresse = new Adresse();
        Assertions.assertNotNull(adresse);
    }

    @Test
    public void should_set_numero() {
        Adresse adresse = new Adresse();
        adresse.setNumero(1);
        Assertions.assertEquals(1,adresse.getNumero());
    }

    @Test
    public void should_set_rue() {
        Adresse adresse = new Adresse();
        adresse.setRue("avenue des champs-elysees");
        Assertions.assertEquals("avenue des champs-elysees",adresse.getRue());
    }

    @Test
    public void should_set_ville() {
        Adresse adresse = new Adresse();
        adresse.setVille("Paris");
        Assertions.assertEquals("Paris",adresse.getVille());
    }

    @Test
    public void should_set_codePostal() {
        Adresse adresse = new Adresse();
        adresse.setCodePostal(75001);
        Assertions.assertEquals(75001,adresse.getCodePostal());
    }

}
