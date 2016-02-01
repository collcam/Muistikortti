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
public class Main {
    public static void main(String[]args){
        Muistikorttipakka m=new Muistikorttipakka();
        Muistikortti k=new Muistikortti("k","v");
         Muistikortti kokeiluKortti =new Muistikortti("toimiiko","etsintä"); 
        Muistikortti k1=new Muistikortti("k","v"); 
        Muistikortti k2=new Muistikortti("k","v");
        System.out.println(m);
        m.lisaaKortti(k);
        m.lisaaKortti(k1);
        m.lisaaKortti(k2);
        m.lisaaKortti(kokeiluKortti);
      m.tallennaPakka();
      SelaaMuistikorttipakka s=new SelaaMuistikorttipakka();
      System.out.println(s.lueMuistikorttipakkaTiedosto("MuistikorttipakkaKysymys", "MuistikorttipakkaVastaus"));
      
      
    }
}
