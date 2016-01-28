/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cocacoca
 */
public class MuistikorttipakkaTest {

    Muistikorttipakka pakka;
    Muistikortti kortti;

    @Before
    public void setUp() {
        Muistikortti kortti= new Muistikortti("ekaKysymys","ekaVastaus");
        Muistikorttipakka pakka = new Muistikorttipakka(kortti);
      
        
    }@Test
    public void konstruktoriAsettaaKortin(){
     assertEquals(pakka.korttienLkm(),1);
     
    }

    @Test
    public void testLisaaKortti() {
        pakka.lisaaKortti("kysymys", "vastaus");
        assertEquals(pakka.korttienLkm(),2);
        
        
    }

    /**
     * Test of tulostapakka method, of class Muistikorttipakka.
     */
    @Test
    public void testTulostapakka() {
       
    }

    /**
     * Test of poistaKortti method, of class Muistikorttipakka.
     */
    @Test
    public void testPoistaKortti() {
       
        pakka.poistaKortti(kortti);
      assertEquals(pakka.etsiKortti(kortti),"ei löydy");
    }

}
