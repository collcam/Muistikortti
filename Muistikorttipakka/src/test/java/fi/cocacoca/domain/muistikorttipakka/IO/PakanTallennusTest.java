/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.IO;

import fi.cocacoca.domain.muistikorttipakka.io.PakanTallennus;
import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Muistikorttipakka;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author cocacoca
 */
public class PakanTallennusTest {

    File f;
    Scanner lukija;
    PakanTallennus p;
    Muistikorttipakka pakka;
    Muistikortti k;
    Muistikortti k2;
    ArrayList<String> a;

    @Before
    public void setUp() {
        f = new File("Muistikorttipakka");
        p = new PakanTallennus();
        k = new Muistikortti("k", "v");
        pakka = new Muistikorttipakka(k);
        pakka.lisaaKortti(k);
        try {
            lukija = new Scanner(f);
        } catch (FileNotFoundException e) {
            return;
        }
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(p.getTiedosto(), f.getAbsolutePath());
    }

    @Test
    public void pakanTallennusToimii() {
        assertTrue(p.tallennaPakka(null) == false);
        assertTrue(p.tallennaPakka(pakka.tulostapakka()));
        assertTrue(lukija.nextLine().equals("k"));
        assertTrue(lukija.nextLine().equals("v"));
    }

}
