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
import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Muistikorttipakka;
import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;
import fi.cocacoca.domain.muistikorttipakka.kayttoliittyma.Kayttoliittyma;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
//        Muistikortti m=new Muistikortti("k","v");
//        Muistikortti m2=new Muistikortti("k","v");
//        Muistikortti m3=new Muistikortti("k","v");
//        File f=new File("t");
//        Muistikorttipakka p=new Muistikorttipakka();
//        p.lisaaKortti(m3);
//        p.lisaaKortti(m2);
//        p.lisaaKortti(m);

//        System.out.println(p.tallennaPakka(f));
//        try{
//            System.out.println(p.haeKorttipakka(f));
//        }catch(Exception e){
//            System.out.println("ei onnistu");
//        }
        Kayttoliittyma kliittyma;

        kliittyma = new Kayttoliittyma();
        kliittyma.setTitle("Muistikorttisovellus");

        kliittyma.setVisible(true);

    }
}
