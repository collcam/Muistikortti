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
    Muistikortti kortti2;

    @Before
    public void setUp() {
        kortti = new Muistikortti();
        kortti2 = new Muistikortti("kysymys", "vastaus");
    }

    @Test
    public void konstruktoriAsettaaOikeanAlkuarvon() {

        assertEquals(kortti.toString(), ",");
    }

    @Test
    public void parametrillinenkonstruktoriToimii() {

        assertEquals(kortti2.toString(), "kysymys,vastaus");
    }
}
