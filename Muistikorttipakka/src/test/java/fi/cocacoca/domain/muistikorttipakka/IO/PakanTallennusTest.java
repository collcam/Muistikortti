/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.IO;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Muistikorttipakka;
import java.io.File;
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
public class PakanTallennusTest {

    PakanTallennus p;
    Muistikorttipakka pakka;
    Muistikortti k;
    Muistikortti k2;

    @Before
    public void setUp() {
        p=new PakanTallennus("testik","testiv");
        k = new Muistikortti("k", "v");
        k2 = new Muistikortti("k", "v");
        pakka = new Muistikorttipakka(k);
        pakka.lisaaKortti(k2);
        ArrayList<String> a=new ArrayList<>();
       a.add(k.toString());
       a.add(k2.toString());
        
    }
    @Test
    public void pakanTallennusToimii() {
  
        assertTrue(p.tallennaPakka(pakka.tulostapakka()));
    }
    
    //@Test
    //public void toimiikoPakanLataus(){
      //  System.out.println(p.lueMuistikorttipakkaTiedosto("testik", "testiv"));
        //System.out.println(pakka.tulostapakka());
       // assertTrue(p.lueMuistikorttipakkaTiedosto("testik", "testiv").equals(pakka.tulostapakka()));
   // }

}
