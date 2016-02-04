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
import java.util.ArrayList;

public class Muistikorttipakka {

    private ArrayList<Muistikortti> korttipakka = new ArrayList<>();
    private String syote;

    private Muistikortti kortti;

    public Muistikorttipakka(Muistikortti kortti) {

        korttipakka.add(kortti);

    }

    public Muistikorttipakka() {

        kortti = new Muistikortti();

    }

    public void tallennaPakka() {
        new PakanTallennus("MuistikorttipakkaKysymys", "MuistikorttipakkaVastaus")
                .tallennaPakka(korttipakka);
    }

    public void lisaaKortti(Muistikortti kortti) {

        korttipakka.add(kortti);
       
    }

    public ArrayList tulostapakka() {
        return korttipakka;
        
    }

    public boolean poistaKortti(Muistikortti kortti) {
       return korttipakka.remove(kortti);
        
        }

    

    public String etsiKortti(Muistikortti k) {
        for (Muistikortti m : korttipakka) {
            if (korttipakka.contains(k)) {
                return "löytyi";
            }
        }
        return "ei löydy";
    }

    public int korttienLkm() {
        return korttipakka.size();
    }

}
