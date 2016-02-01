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
