/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.io;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka tallentaa Muistikorttipakkoja ja hakee tiedostosta ArrayListana
 * pakkoja.
 *
 * @author cocacoca
 */
public class PakkojenKasittelija {

    /**
     * Metodi load hakee tiedoston file ja lukee ne muistikorteiksi
     * ArrayListaan.
     *
     * @param file tiedosto
     * @return muistikortit arraylistana
     * @throws FileNotFoundException poikkeus
     */
    public static ArrayList<Muistikortti> load(File file) throws FileNotFoundException {
        Scanner lukija = new Scanner(file);
        ArrayList<Muistikortti> a = new ArrayList<Muistikortti>();
        while (lukija.hasNextLine()) {

            String[] split = lukija.nextLine().split(";");
            a.add(new Muistikortti(split[0], split[1]));
        }
        return a;
    }

    /**
     * tallennaPakka tallentaa korttipakan tiedostoon tekstinä.
     *
     * @param korttipakka muistikorttipakka
     * @param tiedosto file
     * @return totuusarvo onnistuiko pakan tallennus vaiko ei.
     */
    public static boolean tallennaPakka(ArrayList<Muistikortti> korttipakka, File tiedosto) {

        try {
            FileWriter output = new FileWriter(tiedosto);
            for (Muistikortti korttipakka1 : korttipakka) {
                output.write(korttipakka1.getKysymys() + ";" + korttipakka1.getVastaus() + "\n");

            }
            output.close();

            return true;
        } catch (Exception e) {

            return false;
        }
    }

}
