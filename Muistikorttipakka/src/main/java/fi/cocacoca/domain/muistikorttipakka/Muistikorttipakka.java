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
import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;


public class Muistikorttipakka {

    private File kysymysTiedosto;
    private File vastausTiedosto;
    private ArrayList<Muistikortti> korttipakka = new ArrayList<>();
    private String syote;
    private Scanner lukija;
    private Muistikortti kortti;

    public Muistikorttipakka(Muistikortti kortti) {
        
        korttipakka.add(kortti);
        lukija=new Scanner(System.in);
        
    }

    public Muistikorttipakka() {
        lukija=new Scanner(System.in);
        kortti=new Muistikortti();
        
    }

    public void tallennaPakka() {
        kysymysTiedosto = new File("MuistikorttipakkaKysysmys");
        vastausTiedosto = new File("MuistikorttipakkaVastaus");
        assert kysymysTiedosto.canWrite();
        assert vastausTiedosto.canWrite();
        try  {
            BufferedWriter output = new BufferedWriter(new FileWriter(kysymysTiedosto));
            for (Muistikortti korttipakka1 : korttipakka) {
                output.write(korttipakka1.getKysymys()+"\n");
            } output.close();
            BufferedWriter output2 = new BufferedWriter(new FileWriter(vastausTiedosto));
            for (Muistikortti korttipakka1 : korttipakka) {
                output2.write(korttipakka1.getVastaus()+"\n");
            }
           
            output2.close();
        } catch (IOException kirjoitusOngelma){
                System.out.println("Kirjoittaminen ei onnistunut");
                }
      
    } public void lisaaKortti(Muistikortti kortti) {
       
            
        
        korttipakka.add(kortti);
        System.out.println("Kortti lisätty");
    }

    public ArrayList tulostapakka() {
        return korttipakka;
       // for (Muistikortti k : korttipakka) {
        //    System.out.println(k);
        //}
    }

    public void poistaKortti(Muistikortti kortti) {

        if (korttipakka.remove(kortti) == true) {
            System.out.println("Kortti poistettu.");
        } else {
            System.out.println("Korttia ei poistettu.");
        }

    }public String etsiKortti(Muistikortti k){
        for(Muistikortti m : korttipakka){
            if(korttipakka.contains(k)){
              return "löytyi";  
            }
        } return "ei löydy";
    }public int korttienLkm(){
        return korttipakka.size();
    }


}
