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

/**
 *
 * @author cocacoca
 */

    public class MuistikorttipakkaTest {

    Muistikorttipakka pakka;
    Muistikortti kortti;

    @Before
    public void setUp() {
       kortti= new Muistikortti("ekaKysymys","ekaVastaus");
         pakka = new Muistikorttipakka(kortti);
      
        
    }@Test
    public void konstruktoriAsettaaKortin(){
     assertEquals(pakka.korttienLkm(),1);
     
    }

    @Test
    public void testLisaaKortti() {
        Muistikortti k=new Muistikortti("kysymys","vastaus");
        pakka.lisaaKortti(k);
        assertEquals(pakka.korttienLkm(),2);
        
        
    }@Test
    public void poistuukoKortti(){
       assertEquals(pakka.poistaKortti(kortti), true);
       
    
    }@Test
    public void olemattomanKortinPoistoyritys(){
        Muistikortti k=new Muistikortti("kysymys","vastaus");
        assertEquals(pakka.poistaKortti(k),false);
        
        
    }@Test
    public void etsiKorttiLoytaaKortin(){
        assertEquals(pakka.etsiKortti(kortti),"löytyi");
    }@Test
    public void etsitaanOlematonKortti(){
      Muistikortti k=new Muistikortti("kysymys","vastaus");
      assertEquals(pakka.etsiKortti(k), "ei löydy");
    }@Test
    public void tallennetaanPakkaToimii(){
      //  assertEquals(pakka.tallennaPakka(), true);
    }@Test
    public void pakkaTulostuuOikein(){
        ArrayList<Muistikortti> a=new ArrayList<>();
        a.add(kortti);
        assertEquals(pakka.tulostapakka(), a);
    }
    

    
}
