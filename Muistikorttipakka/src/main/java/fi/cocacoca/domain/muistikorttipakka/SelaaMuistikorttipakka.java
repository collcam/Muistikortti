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
import fi.cocacoca.domain.muistikorttipakka.IO.PakanTallennus;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SelaaMuistikorttipakka {

    public File ktiedosto;
    public File vtiedosto;

    public SelaaMuistikorttipakka() {
        
    }

    public ArrayList lueMuistikorttipakkaTiedosto(String knimi, String vnimi) {
       return new PakanTallennus("MuistikorttipakkaKysymys", "MuistikorttipakkaVastaus")
               .lueMuistikorttipakkaTiedosto(knimi, vnimi);

    }

}
