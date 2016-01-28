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
import java.io.*;
import java.util.Scanner;

public class SelaaMuistikorttipakka {

    public File ktiedosto;
    public File vtiedosto;

    public SelaaMuistikorttipakka() {
        
    }

    public boolean lueMuistikorttipakkaTiedosto(String knimi, String vnimi) {
        try { ktiedosto= new File(knimi);
            vtiedosto= new File(vnimi);
            if (!ktiedosto.exists() || !vtiedosto.exists()) {
                System.out.println("Ei löydä tiedostoa.");
                return false;
            }
            Scanner klukija = new Scanner(ktiedosto);
            Scanner vlukija = new Scanner(vtiedosto); 
            String merkkijono = "";
            while (klukija.hasNextLine()) {
                String rivi = klukija.nextLine()+" : "+vlukija.nextLine();
                System.out.println(rivi);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui.");
            return false;
        }

    }

}
