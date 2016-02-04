/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.IO;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Muistikorttipakka;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cocacoca
 */
public class PakanTallennus {

    private File kysymysTiedosto;
    private File vastausTiedosto;

    public PakanTallennus(String MuistikorttipakkaKysymys, String MuistikorttipakkaVastaus) {
        this.kysymysTiedosto = new File(MuistikorttipakkaKysymys);
        this.vastausTiedosto = new File(MuistikorttipakkaVastaus);
    }
    
    
    

    public boolean tallennaPakka(ArrayList<Muistikortti> korttipakka) {
        
   
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(kysymysTiedosto));
            for (Muistikortti korttipakka1 : korttipakka) {
                output.write(korttipakka1.getKysymys() + "\n");
            }
            output.close();
            BufferedWriter output2 = new BufferedWriter(new FileWriter(vastausTiedosto));
            for (Muistikortti korttipakka1 : korttipakka) {
                output2.write(korttipakka1.getVastaus() + "\n");
            }

            output2.close();
            return true;
        } catch (Exception e) {
            System.out.println("Kirjoittaminen ei onnistunut");
            return false;
        }
        

    }public ArrayList lueMuistikorttipakkaTiedosto(String knimi, String vnimi) {
        
       ArrayList<String> tulostaja=new ArrayList<>();
        
        try {  
            if (!kysymysTiedosto.exists() || !vastausTiedosto.exists()) {
             
                return tulostaja;
            }
            Scanner klukija = new Scanner(kysymysTiedosto);
            Scanner vlukija = new Scanner(vastausTiedosto); 
            String merkkijono = "";
            while (klukija.hasNextLine()) {
                String rivi = klukija.nextLine()+":"+vlukija.nextLine();
                tulostaja.add(rivi);
                
            }
            return tulostaja;
        } catch (Exception e) {
            
            return tulostaja;
        }

    }
}
