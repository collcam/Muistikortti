/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import java.util.ArrayList;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 *Luokka tallentaa ArrayListiin Muistikortteja ja kutsuu PakanTallennus-luokkaa tallentaakseen pakan teidostoon.
 *
 */
public class MuistikorttipakkaTest {

    Muistikorttipakka pakka;
    Muistikortti kortti;

    @Before
    public void setUp() {
        kortti = new Muistikortti("ekaKysymys", "ekaVastaus");
        pakka = new Muistikorttipakka(kortti);

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
        assertEquals(pakka.etsiKortti(k), false);
        assertTrue(pakka.etsiKortti(kortti));
    }

    @Test
    public void pakkaTulostuuOikein() {
        ArrayList<Muistikortti> a = new ArrayList<>();
        a.add(kortti);
        assertEquals(pakka.tulostapakka(), a);
    }

    @Test
    public void kortinPoistoTiedoillaOnnistuu() {

        assertTrue(pakka.poistaKorttiTiedoilla("ekaKysymys", "ekaVastaus"));
        assertEquals(pakka.poistaKorttiTiedoilla("h", "i"), false);
    }

    @Test
    public void pakanTallennusToimii() {
        assertTrue(pakka.tallennaPakka());

    }

}
