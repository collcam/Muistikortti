/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import fi.cocacoca.domain.muistikorttipakka.io.PakanTallennus;
import java.io.File;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 */
public class TestiTest {

    PakanTallennus pakankasittely;
    File tiedosto;
    String kysymys, vastaus;
    Testi t = new Testi();

    @Before
    public void setUp() {
        pakankasittely = new PakanTallennus();
        tiedosto = new File("Muistikorttipakka");
        kysymys = "";
        vastaus = "";

    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(tiedosto.getName(), "Muistikorttipakka");
        assertEquals(t.getKysymys(), "");
        assertEquals(t.getVastaus(), "");
    }

    @Test
    public void testGetTiedosto() {
        assertEquals(tiedosto.getAbsolutePath(), t.getTiedosto());
    }

}
