/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import java.util.*;
import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;
import java.io.*;
import java.nio.file.Files;

/**
 * Luokka suorittaa Muistikorttitestit. Se hakee tiedostosta kysymyksiä ja lukee
 * annettiinko niille tiedoston mukaan oikea vastaus.
 *
 *
 */
public class Testi {

    /**
     * Metodi hakee tiedostosta joka toisella rivillä olevat kysymykset ja joka
     * toisella rivillä olevat vastaukset ja tarkistaa vastaavatko käyttäjän
     * syötteet tiedostosta löytyviä vastauksia.
     */
    public static boolean testaa(String syote, Muistikortti kortti) {
        return kortti.getVastaus().equalsIgnoreCase(syote);

    }

}
