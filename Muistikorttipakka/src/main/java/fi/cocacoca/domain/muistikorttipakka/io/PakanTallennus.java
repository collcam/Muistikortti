/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.io;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cocacoca
 */
public class PakanTallennus {

    private File tiedosto;

    public PakanTallennus() {
        this.tiedosto = new File("Muistikorttipakka");

    }

    public boolean tallennaPakka(ArrayList<Muistikortti> korttipakka) {

        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(tiedosto));
            for (Muistikortti korttipakka1 : korttipakka) {
                output.write(korttipakka1.getKysymys() + "\n");
                output.write(korttipakka1.getVastaus() + "\n");
            }
            output.close();

            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public String getTiedosto() {
        return tiedosto.getAbsolutePath();
    }
}
