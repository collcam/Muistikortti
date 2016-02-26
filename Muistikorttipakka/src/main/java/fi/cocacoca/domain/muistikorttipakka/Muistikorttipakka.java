/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka;

import fi.cocacoca.domain.muistikorttipakka.io.PakkojenKasittelija;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 **Luokka tallentaa ArrayListiin Muistikortteja ja kutsuu
 * PakanTallennus-luokkaa tallentaakseen pakan teidostoon.
 *
 */
public class Muistikorttipakka {

    private File f;
    private ArrayList<Muistikortti> arrayPakka = new ArrayList<>();
    private String syote;
    private Muistikortti kortti;

    /**
     * parametrillinen konstruktori antaa pakkaan suoraan kortin.
     *
     * @param kortti muistikortti
     */
    public Muistikorttipakka(Muistikortti kortti) {

        arrayPakka.add(kortti);

    }

    /**
     * parametritön konstruktori alustaa vain kortin.
     */
    public Muistikorttipakka() {

        kortti = new Muistikortti();

    }

    /**
     * haeKorttipakka kutsuu PakkojenKasittelijan stativ metodia joka hakee
     * korttipakan tiedostosta.
     *
     * @param f tiedosto
     * @throws FileNotFoundException poikkeus
     */
    public void haeKorttipakka(File f) throws FileNotFoundException {

        arrayPakka = PakkojenKasittelija.load(f);
    }

    /**
     * Metodi tallentaa arraylistin tiedostoon.
     *
     * @return totuusarvo onnistuiko tallennus vai ei
     */
    public boolean tallennaPakka() {

        return PakkojenKasittelija.tallennaPakka(arrayPakka, f);
    }

    /**
     * asettaa tiedoston mihin arraylista tallennetaan.
     *
     * @param f tiedosto
     */
    public void setTiedosto(File f) {
        this.f = f;

    }

    /**
     * Metodi lisää parametrinä annetun kortin korttipakkaan.
     *
     * @param kortti muistikortti
     */
    public void lisaaKortti(Muistikortti kortti) {

        arrayPakka.add(kortti);

    }

    /**
     * Metodi poistaa parametrinä annetun kortin arrayLististä.
     *
     * @param kortti muistikortti
     * @return totuusarvo poistettiinko korttia.
     */
    public boolean poistaKortti(Muistikortti kortti) {
        return arrayPakka.remove(kortti);

    }

    /**
     * palauttaa Muistikorttien lukumäärän pakassa.
     *
     * @return pakan koko
     */
    public int korttienLkm() {
        return arrayPakka.size();

    }

    /**
     * Metodi etsii annetun kortin pakasta.
     *
     * @param k muistikortti
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
     * Metodi etsii korttipakasta tietojen perusteella korttia.
     *
     * @param kysymys syöte
     * @param vastaus syöte
     * @return totuusarvo onko pakassa jo kyseistä korttia
     */

    public boolean etsiKorttiTiedoilla(String kysymys, String vastaus) {
        for (int i = 0; i < arrayPakka.size(); i++) {

            if (arrayPakka.get(i).getKysymys().equals(kysymys) && arrayPakka.get(i).getVastaus().equals(vastaus)) {
                return true;

            }
        }
        return false;
    }

    /**
     * Metodi etsii kortin sen kysymysken ja vastauksen perusteella ja poistaa.
     * sen pakasta.
     *
     * @param kysymys kortin kysymys
     * @param vastaus kortin vastaus
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

    /**
     * Jakaa testausta varten uuden kortin pakan päältä.
     *
     * @return muistikortti
     */
    public Muistikortti jaaKortti() {
        if (arrayPakka.isEmpty()) {
            return null;
        }

        return arrayPakka.get(0);

    }

    /**
     * Jos testauksessa vastataan väärin metodia kutsutaan ja pakka sekoitetaan
     * ennen jaaKorttia().
     */
    public void vastattuVaarin() {
        Collections.shuffle(arrayPakka);

    }

    /**
     * Jos testauksessa vastataan oikein siirtyy kortti oikein vastattujen
     * korttipakkaan vastattuOikein. jolloin sitä ei enää testata.
     *
     * @param kortti muistikortti
     */
    public void vastattuOikein(Muistikortti kortti) {
        arrayPakka.remove(kortti);
    }

}
