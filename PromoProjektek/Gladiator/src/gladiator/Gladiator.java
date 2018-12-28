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
public class Gladiator {

    private byte ev;
    private Szinkod szinkod;
    private boolean szabad; // alap hamis
    private Szarmazas szarmazas;

    public Gladiator(byte ev, Szarmazas szarmazas) {
        this.ev = ev;
        this.szarmazas = szarmazas;
        szabad = false;

    }

    public byte getEv() {
        return ev;
    }

    public Szinkod getSzinkod() {
        return szinkod;
    }

    public boolean isSzabad() {
        return szabad;
    }

    public void setEv(byte ev) {
        this.ev = ev;
    }

    public void setSzinkod(Szinkod szinkod) {
        this.szinkod = szinkod;
    }

    public void setSzabad(boolean szabad) {
        this.szabad = szabad;
    }

    public Szarmazas getSzarmazas() {
        return szarmazas;
    }

    public void setSzarmazas(Szarmazas szarmazas) {
        this.szarmazas = szarmazas;
    }

    public void oregszik() {
        /* Ha meghívódik növeli 1-gyel az ev értékét, de csak
addig míg 10 éve nem gladiátor valaki, ekkor ugyanis felszabadítják
meghívjuk a Felszabadit() metódust. Meghívja továbbá a Fejlodik()
metódust. */
        byte evekSzama = this.getEv();

        switch (evekSzama) {

            case 1:
                System.out.println(evekSzama + "/--/");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 2:
                System.out.println(evekSzama + "/--/");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 3:
                System.out.println(evekSzama + "/--/");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 4:
                System.out.println(evekSzama + "/--/");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 5:
                System.out.println(evekSzama + "/--/");
                System.out.println(getSzinkod());
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 6:
                System.out.println(evekSzama + "/--/");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 7:
                System.out.println(evekSzama + "/--/");
                System.out.println("7");
                System.out.println(getSzinkod());
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 8:
                System.out.println(evekSzama + "/--/");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 9:
                System.out.println(evekSzama + "/--/");
                System.out.println("9");
                pluszEgyEv();
                fejlodik(evekSzama);
                break;
            case 10:
                System.out.println(evekSzama + "/--/");
                felszabadit();

                break;
            case -1:
                System.out.println("A gladiátor már nem harcolhat, felszabadult!");
                break;

        }

    }

    private void pluszEgyEv() {
        this.setEv((byte) (this.getEv() + 1));
    }

    private void fejlodik(byte evekSzama) {
//        if (evekSzama < 3 ) {
//            this.setSzinkod(Szinkod.Sarga);
        if (evekSzama >= 3 && evekSzama < 6) {
            this.setSzinkod(Szinkod.Piros);
        } else if (evekSzama >= 6) {
            this.setSzinkod(Szinkod.Fekete);
        }
    }

    protected void felszabadit() {
        this.setSzabad(true);

    }

    private int gladiatorTapasztalat() {
        switch (this.getEv()) {
            case 1: return 0;
            case 2: return 0;
            case 3: return 1;
            case 4:return 1;
            case 5:return 1;
            case 6: return 2;
            case 7:return 2;
            case 8:return 2;
            case 9:return 2;
            case 10:return 2;
        }
        
        return -1;

    }

    public int jobbGladiator(Gladiator ellenfel) {
//        return szinkod.getErtek() - ellenfel.szinkod.getErtek(); // ha 0, döntetlen, ha nagyob, mint 0, akkor az első nyert, ha kisebb, akkor a második
        return this.gladiatorTapasztalat() - ellenfel.gladiatorTapasztalat();
    }

    @Override
    public String toString() {
        return "ev=" + ev + ", szabad=" + szabad + ", szinkod=" + szinkod + ", szarmazas=" + szarmazas + '}';
    }
}
