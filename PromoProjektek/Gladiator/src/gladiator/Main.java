/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiator;

import java.util.Random;

/**
 *
 * @author f_kri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arena katakombak = new Arena("katakomba");
        katakombak.addFirst("Mókika",(byte) 7);
        
        for (int i = 0; i < 3 ; i++) {
            katakombak.valogat();
            katakombak.tornaIndul();    
        }
        

        katakombak.listHallOfFame();

    }
}
