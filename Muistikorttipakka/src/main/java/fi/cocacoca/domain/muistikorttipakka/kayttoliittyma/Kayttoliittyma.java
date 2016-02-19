/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.cocacoca.domain.muistikorttipakka.kayttoliittyma;

import fi.cocacoca.domain.muistikorttipakka.Muistikortti;
import fi.cocacoca.domain.muistikorttipakka.Muistikorttipakka;
import fi.cocacoca.domain.muistikorttipakka.Testi;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Luokka on käyttöliittymä joka on tarkoitus jakaa tulevalla viikolla
 * osiin.Tarkoitus on että graaffinen käyttöliittymä rakennetaan toisessa
 * luokassa ja että käyttöliittymään jää vain itse Muistikorttipelin ohjaus.
 *
 * @author cocacoca
 */
public class Kayttoliittyma extends JFrame implements ActionListener {

    private Testi t;
    private Muistikortti kortti;
    private Muistikorttipakka pakka = new Muistikorttipakka();
    private JButton lisaysNappi, poistoNappi, testiNappi, vastaaNappi, muokkaaPakkaa, tiedostonHakuNappi, tiedostonTekoNappi;
    private JPanel alkupaneeli, muokkauspaneeli, cpanel, testauspaneeli;
    private JLabel vOtsikko, kOtsikko, ohjaus, tarkistus, testikysymys;
    private JTextField testikentta, vastauskentta, kysymyskentta;
    private CardLayout c1 = new CardLayout();
    private String vastaus;
    private Scanner lukija;
    private JFileChooser fc;

    /**
     * Konstruktori on tällä hetkellä liian pitkä ja tämä on tarkoitus siirtää
     * omaan luokkaansa Konstruktori siis tällä hetkellä rakentaa graaffisen
     * käyttöliittymän
     */
    public Kayttoliittyma() {
        vastaus = "";
        fc = new JFileChooser();

        //paneelien luonti
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(480, 290);
        cpanel = new JPanel();
        alkupaneeli = new JPanel();
        muokkauspaneeli = new JPanel();
        testauspaneeli = new JPanel();

        cpanel.setLayout(c1);

        //alkupaneeli
        ohjaus = new JLabel("muokataanko pakkaa vai testakaanko?");
        tiedostonHakuNappi = new JButton("Hae Pakka");
        tiedostonTekoNappi = new JButton("Tee uusi pakka");
        muokkaaPakkaa = new JButton("Muokkaa pakkaa");
        alkupaneeli.add(ohjaus);
        alkupaneeli.add(tiedostonTekoNappi);
        alkupaneeli.add(tiedostonHakuNappi);
        alkupaneeli.add(muokkaaPakkaa);

        //muokkauspaneeli
        kOtsikko = new JLabel("Kysymys:");
        vOtsikko = new JLabel("Vastaus:");
        kysymyskentta = new JTextField(40);
        vastauskentta = new JTextField(40);
        lisaysNappi = new JButton("lisää kortti");
        poistoNappi = new JButton("poista kortti");
        testiNappi = new JButton("Testaukseen siirtyminen");
        ohjaus = new JLabel("lisää tai poista kortteja tai siirry testiin.");
        muokkauspaneeli.add(ohjaus);
        muokkauspaneeli.add(kOtsikko);
        muokkauspaneeli.add(kysymyskentta);
        muokkauspaneeli.add(vOtsikko);
        muokkauspaneeli.add(vastauskentta);
        muokkauspaneeli.add(lisaysNappi);
        muokkauspaneeli.add(poistoNappi);
        muokkauspaneeli.add(testiNappi);

        //Testauspaneeli
        testikysymys = new JLabel("");

        vastaaNappi = new JButton("vastaa");
        testikentta = new JTextField(40);

        testauspaneeli.add(testikysymys);
        testauspaneeli.add(testikentta);
        testauspaneeli.add(vastaaNappi);

        //lisää paneelit CardLayoutille
        cpanel.add(alkupaneeli, "aloitus");
        cpanel.add(muokkauspaneeli, "pakan muokkaus");
        cpanel.add(testauspaneeli, "testi");

        c1.show(cpanel, "aloitus");
        this.add(cpanel);

        //kuuntelijat
        muokkaaPakkaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ohjaus.setText("Kirjoita kysymys ja vastaus ja valitse haluatko etsiä ja poistaa kortin vai lisätä sen. \n Kun olet valmis paina tallennusnappia.");
                c1.show(cpanel, "pakan muokkaus");

            }
        });

        testiNappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                testikysymys.setText("Kysymys: " + pakka.jaaKortti().getKysymys());
                c1.show(cpanel, "testi");

            }

        });

        poistoNappi.addActionListener(this);
        vastaaNappi.addActionListener(this);
        lisaysNappi.addActionListener(this);
        tiedostonHakuNappi.addActionListener(this);
        tiedostonTekoNappi.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object aiheuttaja = e.getSource();
        if (aiheuttaja == tiedostonTekoNappi) {

            try {
                fc.showSaveDialog(null);
                pakka.setTiedosto(fc.getSelectedFile());
                pakka.tallennaPakka();
                ohjaus.setText("Perustettiin pakka nimeltä: " + fc.getSelectedFile().getName());
                ohjaus.repaint();

            } catch (Exception a) {
                ohjaus.setText("Yritä uudelleen teidostoa ei tehty.");
                ohjaus.repaint();
            }

        }

        if (aiheuttaja == tiedostonHakuNappi) {
            fc.showOpenDialog(null);
            try {
                pakka.haeKorttipakka(fc.getSelectedFile());
                ohjaus.setText("Haettu pakka nimeltä: " + fc.getName());
            } catch (FileNotFoundException n) {
                ohjaus.setText("Tiedostoa ei haettu.");
                ohjaus.repaint();
            }

        }

        if (aiheuttaja == lisaysNappi) {
            if (!vastauskentta.getText().equalsIgnoreCase("") && !kysymyskentta.getText().equalsIgnoreCase("")) {
                kortti = new Muistikortti(kysymyskentta.getText(), vastauskentta.getText());
                pakka.lisaaKortti(kortti);
                ohjaus.setText("Kortti lisätty. Voit jatkaa lisäilyä ja poistoja tai siirtyä testiin.");
                kysymyskentta.setText("");
                vastauskentta.setText("");
                kysymyskentta.repaint();
                vastauskentta.repaint();
                ohjaus.repaint();
                pakka.tallennaPakka();
            }

        }
        if (aiheuttaja == poistoNappi) {

            if (!vastauskentta.getText().equalsIgnoreCase("") && !kysymyskentta.getText().equalsIgnoreCase("")) {

                if (pakka.poistaKorttiTiedoilla(kysymyskentta.getText(), vastauskentta.getText()) == true) {
                    ohjaus.setText("Kortti postettiin, voit lisätä tai poistaa lisää kortteja tai jatkaa testiin.");
                    ohjaus.repaint();
                    kysymyskentta.setText("");
                    vastauskentta.setText("");
                    kysymyskentta.repaint();
                    vastauskentta.repaint();
                    pakka.tallennaPakka();
                } else {
                    kysymyskentta.setText("");
                    vastauskentta.setText("");
                    kysymyskentta.repaint();
                    vastauskentta.repaint();
                    ohjaus.setText("Korttia ei löydy pakasta.");
                    ohjaus.repaint();
                }

            }

        }
        if (aiheuttaja == vastaaNappi) {
            if (pakka.jaaKortti() != null) {
                testikysymys.setText("Kysymys: " + pakka.jaaKortti().getKysymys());

                if (Testi.testaa(testikentta.getText(), kortti) == false) {
                    pakka.vastattuVaarin();
                } else {
                    pakka.vastattuOikein(kortti);
                }
            } else {
                testikysymys.setText("Läpäisit testin!");
            }
            testikysymys.repaint();
        }
    }
}
