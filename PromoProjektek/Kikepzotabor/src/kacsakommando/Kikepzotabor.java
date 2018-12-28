/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kacsakommando;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f_kri
 */
public class Kikepzotabor {

    List<Allatka> ujoncok;

    public Kikepzotabor() {
        this.ujoncok = new ArrayList<>();
    }

    public void hozzaad(Allatka allatkaToAdd) {
        ujoncok.add(allatkaToAdd);
    }

    public void torol(Allatka allatkaToDelete) {
        ujoncok.remove(allatkaToDelete);
    }

    public void etetes(double etelmennyiseg) {
        for (int i = 0; i < ujoncok.size(); i++) {
            ujoncok.get(i).eszik(etelmennyiseg);
        }
    }

    public void itatas(double italmennyiseg) {
        for (int i = 0; i < ujoncok.size(); i++) {
            ujoncok.get(i).iszik(italmennyiseg);
        }
    }

    public void futas(int tavolsag) {
        for (int i = 0; i < ujoncok.size(); i++) {
            ujoncok.get(i).fut(tavolsag);
        }

        for (int i = 0; i < ujoncok.size(); i++) {
            if (ujoncok.get(i).isElajult()) {
                torol(ujoncok.get(i));
            }
        }
    }
    
    public void uszas(int tavolsag) {
        for (int i = 0; i < ujoncok.size(); i++) {
            ujoncok.get(i).uszik(tavolsag);
        }

        for (int i = 0; i < ujoncok.size(); i++) {
            if (ujoncok.get(i).isElajult()) {
                torol(ujoncok.get(i));
            }
        }
    }
    
    public void repules(int tavolsag) {
        for (int i = 0; i < ujoncok.size(); i++) {
            ujoncok.get(i).repul(tavolsag);
        }

        for (int i = 0; i < ujoncok.size(); i++) {
            if (ujoncok.get(i).isElajult()) {
                torol(ujoncok.get(i));
            }
        }
    }
    
    public int tulelokSzama (){
        return ujoncok.size();
    }
    
    public List<Allatka> tulelokListaja () {
        return ((List<Allatka>)((ArrayList<Allatka>)ujoncok).clone());
    }

}
