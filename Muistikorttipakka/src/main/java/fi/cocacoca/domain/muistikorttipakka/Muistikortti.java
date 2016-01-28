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
public class Muistikortti {
    public String kysymys;
    public String vastaus;
    public Muistikortti(){
        
    }
    public Muistikortti(String kysymys, String vastaus){
        
        setKysymys(kysymys);
        setVastaus(vastaus);
    }public void setKysymys(String k){
       this.kysymys=k; 
    }public void setVastaus(String v){
        this.vastaus=v;
    }
    public String getVastaus(){
        return vastaus;
    }public String getKysymys(){
        return this.kysymys;
    }public String toString(){
        return getKysymys()+" : "+getVastaus();
    }
    
}
