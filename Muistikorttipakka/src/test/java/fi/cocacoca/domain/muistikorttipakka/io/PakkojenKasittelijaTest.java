/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.io;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

/**
 *
 * @author cocacoca
 */
public class PakkojenKasittelijaTest {

    ArrayList<Muistikortti> a;
    Muistikortti k;
    Muistikortti k2;
    File f;

    @Before
    public void setUp() {
        a = new ArrayList<Muistikortti>();
        k = new Muistikortti("k", "v");
        k2 = new Muistikortti("k1", "v1");
        a.add(k);
        a.add(k2);
        f = new File("Testifile");

    }

    @Test
    public void PakanTallennusToimii() {
        assertTrue(PakkojenKasittelija.tallennaPakka(a, f));
    }

    /**
     * Test of tallennaPakka method, of class PakkojenKasittelija.
     */
    @Test
    public void pakanLatausToimii() {

        try {
            PakkojenKasittelija.load(f);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PakkojenKasittelijaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void pakanTallennusVaarin() {
        assertEquals(PakkojenKasittelija.tallennaPakka(null, null), false);
    }

}
