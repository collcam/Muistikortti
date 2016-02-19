/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

/**
 **Luokka tallentaa ArrayListiin Muistikortteja ja kutsuu
 * PakanTallennus-luokkaa tallentaakseen pakan teidostoon.
 *
 */
import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;
import fi.cocacoca.domain.muistikorttipakka.Muistikortti;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Muistikorttipakka {

    private File f;
    private ArrayList<Muistikortti> arrayPakka = new ArrayList<>();
    private String syote;
    private Muistikortti kortti;
    private ArrayList<Muistikortti> vastattuOikein = new ArrayList<>();

    public Muistikorttipakka(Muistikortti kortti) {

        arrayPakka.add(kortti);

    }

    public Muistikorttipakka() {

        kortti = new Muistikortti();

    }

    public ArrayList<Muistikortti> haeKorttipakka(File f) throws FileNotFoundException {
        this.f = f;
        return PakkojenKasittelija.load(f);
    }

    /**
     * Metodi tallentaa arraylistin tiedostoon.
     *
     * @return totuusarvo onnistuiko tallennus vai ei
     */
    public boolean tallennaPakka() {

        return PakkojenKasittelija.tallennaPakka(arrayPakka, f);
    }

    public void setTiedosto(File f) {
        this.f = f;

    }

    /**
     * Metodi lisää parametrinä annetun kortin korttipakkaan.
     *
     * @param kortti
     */
    public void lisaaKortti(Muistikortti kortti) {

        arrayPakka.add(kortti);

    }

    public ArrayList<Muistikortti> tulostapakka() {
        return arrayPakka;

    }

    /**
     * Metodi poistaa parametrinä annetun kortin arrayLististä.
     *
     * @param kortti
     * @return totuusarvo poistettiinko korttia.
     */
    public boolean poistaKortti(Muistikortti kortti) {
        return arrayPakka.remove(kortti);

    }

    /**
     * Metodi etsii annetun kortin pakasta.
     *
     * @param k
     * @return totuusarvo siitä löytyikö parametsinä annettua korttia
     */
    public boolean etsiKortti(Muistikortti k) {
        for (Muistikortti m : arrayPakka) {
            if (arrayPakka.contains(k)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Metodi etsii kortin sen kysymysken ja vastauksen perusteella ja poistaa
     * sen pakasta.
     *
     * @param kysymys
     * @param vastaus
     * @return totuusarvo siitä poistettiinko kortti
     */
    public boolean poistaKorttiTiedoilla(String kysymys, String vastaus) {

        for (int i = 0; i < arrayPakka.size(); i++) {

            if (arrayPakka.get(i).getKysymys().equals(kysymys) && arrayPakka.get(i).getVastaus().equals(vastaus)) {
                return poistaKortti(arrayPakka.get(i));

            }
        }
        return false;
    }

    public int korttienLkm() {
        return arrayPakka.size();

    }

    public Muistikortti jaaKortti() {
        if (!arrayPakka.isEmpty()) {
            return arrayPakka.get(0);
        }
        return null;

    }

    public void vastattuVaarin() {
        Collections.shuffle(arrayPakka);

    }

    public void vastattuOikein(Muistikortti kortti) {
        vastattuOikein.add(kortti);
        arrayPakka.remove(kortti);
    }

}
