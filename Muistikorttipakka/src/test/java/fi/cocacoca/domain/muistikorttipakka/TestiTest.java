/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import static fi.cocacoca.domain.muistikorttipakka.Testi.testaa;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *
 */
public class TestiTest {

    
    Muistikortti m;
    

    @Before
    public void setUp() throws IOException {
         m=new Muistikortti("hei","hello");
        
    }

    @Test
    public void testaaToimii() {
        assertTrue(testaa("hello",m));
    }

}
