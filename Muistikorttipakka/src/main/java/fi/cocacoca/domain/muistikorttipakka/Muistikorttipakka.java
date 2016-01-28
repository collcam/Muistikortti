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

    public void tallennaPakka(String tiedostonNimi) {
        kysymysTiedosto = new File(tiedostonNimi);
        vastausTiedosto = new File(tiedostonNimi + "Vastaus");
        assert kysymysTiedosto.canWrite();
        assert vastausTiedosto.canWrite();
        try  {
            BufferedWriter output = new BufferedWriter(new FileWriter(kysymysTiedosto));
            for (int i = 0; i < korttipakka.size(); i++) {
                output.write(korttipakka.get(i).getKysymys());
            }
            BufferedWriter output2 = new BufferedWriter(new FileWriter(vastausTiedosto));
            for(int a= 0;a< korttipakka.size();a++) {
                output2.write(korttipakka.get(a).getVastaus());
            }
        } catch (IOException kirjoitusOngelma){
                System.out.println("Kirjoittaminen ei onnistunut");
                }
      
    } public void lisaaKortti(String kysymys, String vastaus) {
       
            kortti.setKysymys(kysymys);
      
            kortti.setVastaus(vastaus);
        
        korttipakka.add(kortti);
        System.out.println("Kortti lisätty");
    }

    public void tulostapakka() {
        for (Muistikortti k : korttipakka) {
            System.out.println(k);
        }
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
