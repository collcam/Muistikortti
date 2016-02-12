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
import fi.cocacoca.domain.muistikorttipakka.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

     //   Muistikortti k=new Muistikortti("hei","vaan");
        // Muistikortti k1=new Muistikortti("a","b");
        //  Muistikortti k2=new Muistikortti("c","d");
        //Muistikorttipakka p=new Muistikorttipakka();
        //  p.lisaaKortti(k2);
        // p.lisaaKortti(k1);
        //   p.lisaaKortti(k);
        //    System.out.println(p.korttienLkm());
        //  System.out.println(p.poistaKorttiTiedoilla("c","d"));
        //System.out.println(p.korttienLkm());
        Kayttoliittyma kliittyma = new Kayttoliittyma();
        kliittyma.setTitle("Muistikorttisovellus");

        kliittyma.setVisible(true);

    }
}
