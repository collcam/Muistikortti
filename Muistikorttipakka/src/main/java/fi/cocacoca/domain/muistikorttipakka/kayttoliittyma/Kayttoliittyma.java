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
    JFrame frame = new JFrame();
    private JButton lisaysNappi, poistoNappi, testiNappi, vastaaNappi, muokkaaPakkaa, tiedostonHakuNappi, tiedostonTekoNappi, tallennaPakkaNappi;
    private JPanel alkupaneeli, muokkauspaneeli, cpanel, testauspaneeli;
    private JLabel vOtsikko, kOtsikko, ohjaus, tarkistus, testikysymys;
    private JTextField testikentta, vastauskentta, kysymyskentta;
    private File tiedosto;
    CardLayout c1 = new CardLayout();
    Scanner lukija;
    JFileChooser fc = new JFileChooser();
    /**
     * Konstruktori on tällä hetkellä liian pitkä ja tämä on tarkoitus siirtää
     * omaan luokkaansa Konstruktori siis tällä hetkellä rakentaa graaffisen
     * käyttöliittymän
     */
    public Kayttoliittyma() {
        //paneelien luonti
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
        tallennaPakkaNappi = new JButton("tallenna pakka");
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
        muokkauspaneeli.add(tallennaPakkaNappi);

        //Testauspaneeli
        testikysymys = new JLabel("");
        vastaaNappi = new JButton("vastaa");
        testikentta = new JTextField(40);
        testauspaneeli.add(testikysymys);
        testauspaneeli.add(testikentta);
        testauspaneeli.add(vastaaNappi);

        //lisää paneelit controlPaneelille ja controlPanel JFrameen 
        cpanel.add(alkupaneeli, "aloitus");
        cpanel.add(muokkauspaneeli, "pakan muokkaus");
        cpanel.add(testauspaneeli, "testi");

        c1.show(cpanel, "aloitus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        frame.add(cpanel);
        frame.setVisible(true);

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
                fc.setDialogTitle("Luo uusi Muistipakkatiedosto");
                int userSelection = fc.showSaveDialog(null);
                if (userSelection == fc.showSaveDialog(null)) {
                    tiedosto = fc.getSelectedFile();
                    pakka.setTiedosto(tiedosto);
                    ohjaus.setText("Perustettiin pakka");
                    ohjaus.repaint();
                }
            } catch (Exception a) {
                ohjaus.setText("Yritä uudelleen teidostoa ei tehty.");
                ohjaus.repaint();
            }
        }
        if (aiheuttaja == tiedostonHakuNappi) {
            try {
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    tiedosto = fc.getSelectedFile();
                    ohjaus.setText("valittu tiedosto nimeltä:: " + tiedosto.getName());
                    ohjaus.repaint();
                    pakka.haeKorttipakka(tiedosto);
                }

            } catch (Exception n) {
                ohjaus.setText("Tiedostoa ei haettu,yritä uudelleen");
                ohjaus.repaint();
            }
        }
        if (aiheuttaja == tallennaPakkaNappi) {
            pakka.tallennaPakka(tiedosto);
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
