/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import fi.cocacoca.domain.muistikorttipakka.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 * Main metodi.
 *
 * @author cocacoca
 */
public class Main {

    /**
     * Main metodi kutsuu käyttöliittymää.
     *
     * @param args main metodi
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma());

    }
}
