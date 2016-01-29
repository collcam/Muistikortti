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
public class SelaaMuistikorttipakkaTest {
    
    public SelaaMuistikorttipakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lueMuistikorttipakkaTiedosto method, of class SelaaMuistikorttipakka.
     */
    @Test
    public void testLueMuistikorttipakkaTiedosto() {
        System.out.println("lueMuistikorttipakkaTiedosto");
        String knimi = "";
        String vnimi = "";
        SelaaMuistikorttipakka instance = new SelaaMuistikorttipakka();
        boolean expResult = false;
        boolean result = instance.lueMuistikorttipakkaTiedosto(knimi, vnimi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
