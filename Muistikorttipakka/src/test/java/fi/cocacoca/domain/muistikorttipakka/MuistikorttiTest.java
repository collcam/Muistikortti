/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.cocacoca.domain.muistikorttipakka;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MuistikorttiTest {
    Muistikortti kortti;
    
    @Before
    public void setUp(){
        
        
    }@Test
    public void konstruktoriAsettaaOikeanAlkuarvon(){
     kortti=new Muistikortti();
    assertEquals(kortti.toString(), " : ");
    }
    @Test
    public void parametrillinenkonstruktoriToimii(){
        kortti=new Muistikortti("kysymys","vastaus");
        assertEquals(kortti.toString(),"kysymys : vastaus");
    }@Test
    public void toStringOnOikein(){
      kortti=new Muistikortti("k","v");
      assertEquals(kortti.toString(),"k : v");
    }
}
