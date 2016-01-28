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
        System.out.println(m);
        m.lisaaKortti(k);
        m.lisaaKortti(kokeiluKortti);
      m.tallennaPakka();
      SelaaMuistikorttipakka s=new SelaaMuistikorttipakka();
      System.out.println(s.lueMuistikorttipakkaTiedosto("MuistikorttipakkaKysymys", "MuistikorttipakkaVastaus"));
      
      
    }
}
