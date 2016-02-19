/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;
import java.io.File;
import java.io.IOException;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 */
public class TestiTest {

    PakkojenKasittelija pakankasittely;
    File tiedosto;
    String kysymys, vastaus;
    Testi t;

    @Before
    public void setUp() throws IOException {
        pakankasittely = new PakkojenKasittelija();
        tiedosto = new File("Muistikorttipakka");
        kysymys = "";
        vastaus = "";
        t  = new Testi();
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(tiedosto.getName(), "Muistikorttipakka");
        assertEquals(t.getKysymys(), "");
        assertEquals(t.getVastaus(), "");
    }

    @Test
    public void testGetTiedosto() {
        assertEquals("Muistikorttipakka", t.getTiedosto().getName());
    }

}
