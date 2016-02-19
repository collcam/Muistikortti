/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 *Luokka tallentaa ArrayListiin Muistikortteja ja kutsuu PakanTallennus-luokkaa tallentaakseen pakan teidostoon.
 *
 */
public class MuistikorttipakkaTest {

    File f;
    Muistikorttipakka pakka;
    Muistikortti kortti;

    @Before
    public void setUp() {
        kortti = new Muistikortti("ekaKysymys", "ekaVastaus");
        pakka = new Muistikorttipakka(kortti);
        f = new File("k");
    }

    @Test
    public void konstruktoriAsettaaKortin() {
        assertEquals(pakka.korttienLkm(), 1);

    }

    @Test
    public void testLisaaKortti() {
        Muistikortti k = new Muistikortti("kysymys", "vastaus");
        pakka.lisaaKortti(k);
        assertEquals(pakka.korttienLkm(), 2);

    }

    @Test
    public void poistuukoKortti() {
        assertEquals(pakka.poistaKortti(kortti), true);

    }

    @Test
    public void olemattomanKortinPoistoyritys() {
        Muistikortti k = new Muistikortti("kysymys", "vastaus");
        assertEquals(pakka.poistaKortti(k), false);

    }

    @Test
    public void etsitaanKorttiToimii() {
        Muistikortti k = new Muistikortti("kysymys", "vastaus");
        Muistikortti k2 = new Muistikortti("ky", "va");
        pakka.lisaaKortti(k2);
        assertEquals(pakka.etsiKortti(k), false);
        assertTrue(pakka.etsiKortti(k2));
    }

    @Test
    public void kortinPoistoTiedoillaOnnistuu() {
        Muistikortti k = new Muistikortti("kysymys", "vastaus");
        Muistikortti k2 = new Muistikortti("ky", "va");
        pakka.lisaaKortti(k2);
        pakka.lisaaKortti(k);
        assertTrue(pakka.poistaKorttiTiedoilla("kysymys", "vastaus"));
        assertEquals(pakka.poistaKorttiTiedoilla("h", "i"), false);

    }

    @Test
    public void pakanHakuOnnistuu() {
        pakka.tallennaPakka(f);

        try {
            ArrayList<Muistikortti> b = pakka.haeKorttipakka(f);
            for (int i = 0; i < b.size(); i++) {
                assertTrue(pakka.poistaKorttiTiedoilla(b.get(i).getKysymys(), b.get(i).getVastaus()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MuistikorttipakkaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void pakanTallennusToimii() {
        assertTrue(pakka.tallennaPakka(f));

    }

    @Test
    public void jaaKorttiToimii() {
        Muistikorttipakka p = new Muistikorttipakka();
        assertTrue(p.jaaKortti() == null);
        p.lisaaKortti(kortti);
        assertEquals(p.jaaKortti(), kortti);
    }

    @Test
    public void vastattuOikein() {
        assertTrue(pakka.etsiKortti(kortti));
        pakka.vastattuOikein(kortti);
        assertTrue(pakka.etsiKortti(kortti) == false);

    }

}
