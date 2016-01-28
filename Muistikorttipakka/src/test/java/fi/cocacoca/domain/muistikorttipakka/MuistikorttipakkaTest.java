/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author cocacoca
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
    public void lisaakoKortinOikein() {
        Muistikortti kokeiluKortti = new Muistikortti("toimiiko", "lisäys");
        pakka.lisaaKortti(kokeiluKortti);
        assertEquals(pakka.korttienLkm(), 2);

    }

    @Test
    public void onnistuukoKortinPoisto() {
        pakka.poistaKortti(kortti);
        assertEquals(pakka.korttienLkm(), 0);
    }

    @Test
    public void onnistuukoKortinEtsinta() {
        Muistikortti kokeiluKortti = new Muistikortti("toimiiko", "etsintä");
        pakka.lisaaKortti(kokeiluKortti);
        assertEquals(pakka.etsiKortti(kokeiluKortti), "löytyi");

    }

    @Test
    public void onnistuukoOlemattomanKortinEtsinta() {
        Muistikortti kokeiluKortti = new Muistikortti("toimiiko", "etsintä");
        assertEquals(pakka.etsiKortti(kokeiluKortti), "ei löydy");
    }

    @Test
    public void tulostetaankoPakkaOikein() {
        ArrayList<Muistikortti> kokeiluLista = new ArrayList<>();
        kokeiluLista.add(kortti);
        assertEquals(pakka.tulostapakka(), kokeiluLista);
    }

}
