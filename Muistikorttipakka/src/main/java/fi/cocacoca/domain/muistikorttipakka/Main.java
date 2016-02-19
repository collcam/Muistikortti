/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

/**
 *
 * @author cocacoca
 */
import fi.cocacoca.domain.muistikorttipakka.Muistikorttipakka;
import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.kayttoliittyma.Kayttoliittyma;
import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Kayttoliittyma kliittyma;

        kliittyma = new Kayttoliittyma();
        kliittyma.setTitle("Muistikorttisovellus");

        kliittyma.setVisible(true);

    }
}
