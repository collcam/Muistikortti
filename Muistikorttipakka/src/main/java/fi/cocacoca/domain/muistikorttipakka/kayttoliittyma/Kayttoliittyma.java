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
public class Kayttoliittyma implements Runnable, ActionListener {

    private Testi t;
    private Muistikortti kortti;
    private Muistikorttipakka pakka;
    private JButton lisaysNappi, poistoNappi, testiNappi, vastaaNappi, muokkaaPakkaa, tiedostonHakuNappi, tiedostonTekoNappi, tallennaPakkaNappi;
    private JPanel alkupaneeli, muokkauspaneeli, cpanel, testauspaneeli;
    private JLabel vOtsikko, kOtsikko, ohjaus, ohjaus2, testikysymys, testipalaute;
    private JTextField testikentta, vastauskentta, kysymyskentta;
    private File tiedosto;
    CardLayout c1;
    Scanner lukija;
    JFileChooser fc;
    JFrame frame;

    /**
     * Konstruktori on tällä hetkellä liian pitkä ja tämä on tarkoitus siirtää
     * omaan luokkaansa Konstruktori siis tällä hetkellä rakentaa graaffisen
     * käyttöliittymän
     */
    public Kayttoliittyma() {
        pakka = new Muistikorttipakka();
        frame = new JFrame("Muistikorttisovellus");
        c1 = new CardLayout();
        fc = new JFileChooser();
    }

    @Override
    public void run() {
        //controlPaneelien luonti
        cpanel = new JPanel();
        alkupaneeli = new JPanel();
        muokkauspaneeli = new JPanel();
        testauspaneeli = new JPanel();
        cpanel.setLayout(c1);

        //alkupaneelin luonti
        ohjaus = new JLabel("muokataanko pakkaa vai testakaanko?");
        tiedostonHakuNappi = new JButton("Hae Pakka");
        tiedostonTekoNappi = new JButton("Tee uusi pakka");
        muokkaaPakkaa = new JButton("Muokkaa pakkaa");
        alkupaneeli.add(ohjaus);
        alkupaneeli.add(tiedostonTekoNappi);
        alkupaneeli.add(tiedostonHakuNappi);
        alkupaneeli.add(muokkaaPakkaa);

        //muokkauspaneelin luonti
        kOtsikko = new JLabel("Kysymys:");
        vOtsikko = new JLabel("Vastaus:");
        kysymyskentta = new JTextField(40);
        vastauskentta = new JTextField(40);
        tallennaPakkaNappi = new JButton("tallenna pakka");
        lisaysNappi = new JButton("lisää kortti");
        poistoNappi = new JButton("poista kortti");
        testiNappi = new JButton("Testaukseen siirtyminen");
        ohjaus2 = new JLabel("lisää tai poista kortteja tai siirry testiin.                                                  ");
        muokkauspaneeli.add(ohjaus2);
        muokkauspaneeli.add(kOtsikko);
        muokkauspaneeli.add(kysymyskentta);
        muokkauspaneeli.add(vOtsikko);
        muokkauspaneeli.add(vastauskentta);
        muokkauspaneeli.add(lisaysNappi);
        muokkauspaneeli.add(poistoNappi);
        muokkauspaneeli.add(testiNappi);
        muokkauspaneeli.add(tallennaPakkaNappi);

        //Testauspaneelin luonti
        testikysymys = new JLabel("");
        vastaaNappi = new JButton("vastaa");
        testikentta = new JTextField(40);
        testipalaute = new JLabel("");
        testauspaneeli.add(testikysymys);
        testauspaneeli.add(testikentta);
        testauspaneeli.add(vastaaNappi);
        testauspaneeli.add(testipalaute);

        //lisää paneelit controlPaneelille ja controlPanel JFrameen 
        cpanel.add(alkupaneeli, "aloitus");
        cpanel.add(muokkauspaneeli, "pakan muokkaus");
        cpanel.add(testauspaneeli, "testi");

        frame.add(cpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(560, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //kuuntelijat
        muokkaaPakkaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tiedosto != null) {
                    ohjaus.setText("Kirjoita kysymys ja vastaus ja valitse haluatko etsiä ja poistaa kortin vai lisätä sen. \n Kun olet valmis paina tallennusnappia.");
                    c1.show(cpanel, "pakan muokkaus");
                } else {
                    ohjaus.setText("Et voi muokata pakkaa ennen kuin olet valinnut sellaisen.");
                }
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
        tallennaPakkaNappi.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object aiheuttaja = e.getSource();

        if (aiheuttaja instanceof JButton) {
            aiheuttaja = (JButton) e.getSource();
        } else {
            return;
        }

        if (aiheuttaja == tiedostonTekoNappi) {
            try {
                fc.setDialogTitle("Luo uusi Muistipakkatiedosto");
                int userSelection = fc.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    tiedosto = fc.getSelectedFile();
                    pakka.setTiedosto(tiedosto);
                    pakka.tallennaPakka();
                    ohjaus.setText("Perustettiin pakka");
                }
            } catch (Exception a) {
                ohjaus.setText("Yritä uudelleen tiedostoa ei tehty.");
            }
        }
        if (aiheuttaja == tiedostonHakuNappi) {
            try {
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    tiedosto = fc.getSelectedFile();
                    pakka.setTiedosto(tiedosto);
                    ohjaus.setText("valittu tiedosto nimeltä: " + tiedosto.getName());
                    pakka.haeKorttipakka(tiedosto);
                }

            } catch (Exception n) {
                ohjaus.setText("Tiedostoa ei haettu,yritä uudelleen");
            }
        }
        if (aiheuttaja == tallennaPakkaNappi) {
            pakka.tallennaPakka();
        }
        if (aiheuttaja == lisaysNappi) {
            if (!vastauskentta.getText().equalsIgnoreCase("") && !kysymyskentta.getText().equalsIgnoreCase("")) {
                kortti = new Muistikortti(kysymyskentta.getText(), vastauskentta.getText());
                if (pakka.etsiKorttiTiedoilla(kortti.getKysymys(), kortti.getVastaus())) {
                    ohjaus2.setText("Kortti on jo pakassa.                                                             ");
                } else {
                    pakka.lisaaKortti(kortti);
                    ohjaus2.setText("Kortti lisätty. Voit jatkaa lisäilyä ja poistoja tai siirtyä testiin.                  ");
                    kysymyskentta.setText("");
                    vastauskentta.setText("");
                }
            }
        }
        if (aiheuttaja == poistoNappi) {
            if (!vastauskentta.getText().equalsIgnoreCase("") && !kysymyskentta.getText().equalsIgnoreCase("")) {
                if (pakka.poistaKorttiTiedoilla(kysymyskentta.getText(), vastauskentta.getText()) == true) {
                    ohjaus2.setText("Kortti postettiin, voit lisätä tai poistaa lisää kortteja tai jatkaa testiin.      ");
                    kysymyskentta.setText("");
                    vastauskentta.setText("");
                } else {
                    kysymyskentta.setText("");
                    vastauskentta.setText("");
                    ohjaus.setText("Korttia ei löydy pakasta.");
                }
            }
        }
        if (aiheuttaja == vastaaNappi) {
            Muistikortti kortti = pakka.jaaKortti();

            if (kortti != null) {
                testikysymys.setText("Kysymys: " + kortti.getKysymys());

                System.out.println(testikentta.getText());

                if (Testi.testaa(testikentta.getText(), kortti) == false) {
                    testipalaute.setText("Väärin!");
                    pakka.vastattuVaarin();
                } else {
                    testipalaute.setText("Oikein!");
                    pakka.vastattuOikein(kortti);
                }
            }

            testikentta.setText("");

            kortti = pakka.jaaKortti();

            if (kortti != null) {
                testikysymys.setText("Kysymys: " + kortti.getKysymys());
            } else {
                JOptionPane.showMessageDialog(this.frame,
                        "Läpäisit testin! Oot aika boss.",
                        "Muistikorttisovellus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }
}
