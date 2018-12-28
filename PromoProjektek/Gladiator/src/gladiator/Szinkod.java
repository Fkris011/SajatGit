/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladiator;

/**
 *
 * @author f_kri
 */
public enum Szinkod {
    Sarga(0),
    Piros(1),
    Fekete(2);

    private int ertek;

    private Szinkod(int ertek) {
        this.ertek = ertek;
    }

    public int getErtek() {
        return ertek;
    }

}
