/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.io;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Main;
import fi.cocacoca.domain.muistikorttipakka.kayttoliittyma.Kayttoliittyma;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cocacoca
 */
public class PakkojenKasittelija {

    public static ArrayList<Muistikortti> load(File file) throws FileNotFoundException {
        Scanner lukija = new Scanner(file);
        ArrayList<Muistikortti> a = new ArrayList<Muistikortti>();
        while (lukija.hasNextLine()) {

            String[] split = lukija.nextLine().split(";");
            a.add(new Muistikortti(split[0], split[1]));
        }
        return a;
    }

    public static boolean tallennaPakka(ArrayList<Muistikortti> korttipakka, File tiedosto) {

        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(tiedosto));
            for (Muistikortti korttipakka1 : korttipakka) {
                output.write(korttipakka1.getKysymys() + ";" + korttipakka1.getVastaus());

            }
            output.close();

            return true;
        } catch (Exception e) {

            return false;
        }
    }

}
