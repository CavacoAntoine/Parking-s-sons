package com.agile.psbackspringboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdresseTests {

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

    @Test
    public void shouldBeEquals() {
        Adresse adresse1 = new Adresse();
        Adresse adresse2 = new Adresse();

        Assertions.assertEquals(adresse1, adresse2);

        adresse1.setNumero(15);
        adresse1.setRue("chemin de l'orangerie");
        adresse1.setCodePostal(77700);
        adresse1.setVille("Chessy");
        adresse2.setNumero(15);
        adresse2.setRue("chemin de l'orangerie");
        adresse2.setCodePostal(77700);
        adresse2.setVille("Chessy");

        Assertions.assertEquals(adresse1, adresse2);
    }

    @Test
    public void shouldNotBeEquals() {
        Adresse adresse1 = new Adresse();
        adresse1.setNumero(15);
        Adresse adresse2 = new Adresse();

        Assertions.assertNotEquals(adresse1, adresse2);

        adresse1.setRue("chemin de l'orangerie");
        adresse1.setCodePostal(77700);
        adresse1.setVille("Chessy");
        adresse2.setNumero(15);
        adresse2.setRue("chemi de l'orangerie");
        adresse2.setCodePostal(77700);
        adresse2.setVille("Chessy");

        Assertions.assertNotEquals(adresse1, adresse2);
    }

}
