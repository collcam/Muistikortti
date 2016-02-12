/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import java.util.*;
import fi.cocacoca.domain.muistikorttipakka.io.PakanTallennus;
import java.io.*;

/**
 * Luokka suorittaa Muistikorttitestit. Se hakee tiedostosta kysymyksiä ja lukee
 * annettiinko niille tiedoston mukaan oikea vastaus.
 *
 *
 */
public class Testi {

    private PakanTallennus pakankasittely;
    private File tiedosto;
    private String kysymys, vastaus;

    public Testi() {

        pakankasittely = new PakanTallennus();
        tiedosto = new File("Muistikorttipakka");
        kysymys = "";
        vastaus = "";

    }

    /**
     * Metodi hakee tiedostosta joka toisella rivillä olevat kysymykset ja joka
     * toisella rivillä olevat vastaukset ja tarkistaa vastaavatko käyttäjän
     * syötteet tiedostosta löytyviä vastauksia.
     */
    public void testaa() {
        try {
            Scanner syote = new Scanner(System.in);
            Scanner lukija = new Scanner(tiedosto);
            String kayttajaSyote = "";

            while (lukija.hasNextLine()) {

                setKysymys(lukija.nextLine());
                setVastaus(lukija.nextLine());

                System.out.println(kysymys);
                kayttajaSyote = syote.nextLine();

               // if (kayttajaSyote.equalsIgnoreCase(vastaus)) {

              //  }else System.out.println("vaarin vastaus="+vastaus);
            }

        } catch (Exception e) {
            return;
        }
    }

    public void setKysymys(String k) {
        this.kysymys = k;
    }

    public void setVastaus(String v) {
        this.kysymys = v;
    }

    public String getKysymys() {
        return kysymys;
    }

    public String getVastaus() {
        return vastaus;

    }

    public String getTiedosto() {
        return tiedosto.getAbsolutePath();
    }

}
