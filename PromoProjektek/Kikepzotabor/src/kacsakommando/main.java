/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kacsakommando;


import java.util.Random;

/**
 *
 * @author f_kri
 */
public class main {

    private static Random random = new Random();
    private static final int SEREG_MERETE = 100;
    private static final int TIPUS = 3;

    public static void main(String[] args) {

        Kikepzotabor elsoKikepzotabor = new Kikepzotabor();
        sorozas(SEREG_MERETE, elsoKikepzotabor);
        eredmenyKiir(elsoKikepzotabor);
        gyakorlatozas(elsoKikepzotabor);
        eredmenyKiir(elsoKikepzotabor);

    }

    private static int veletlenszeruGeneralas(int limit) {
        Random rnd = new Random();
        return (rnd.nextInt(limit) + 1);
    }

    private static void sorozas(int letszam, Kikepzotabor tabor) {
        for (int i = 0; i < letszam; i++) {
            int esely = random.nextInt(TIPUS);
            Allatka temp = null;
            switch (esely) {
                case 0:
                    temp = new Kacsa(100, 100);
                    break;
                case 1:
                    temp = new Sas(100, 100);
                    break;
                case 2:
                    temp = new Roka(100, 100);
                    break;
            }
            tabor.hozzaad(temp);

        }
    }

    private static void gyakorlatozas(Kikepzotabor elsoKikepzotabor) {

        while (elsoKikepzotabor.tulelokSzama() > 20) {
            int tevekenyseg = random.nextInt(5);
            switch (tevekenyseg) {
                case 0:
                    System.out.println("Eves");
                    elsoKikepzotabor.etetes((double) random.nextInt(30) + 20);
                    break;
                case 1:
                    System.out.println("Ivas");
                    elsoKikepzotabor.itatas((double) random.nextInt(30) + 20);
                    break;
                case 2:
                    System.out.println("Futas");
                    elsoKikepzotabor.futas(random.nextInt(20) + 10);
                    break;
                case 3:
                    System.out.println("Uszas");
                    elsoKikepzotabor.uszas(random.nextInt(20) + 10);
                    break;
                case 4:
                    System.out.println("Repules");
                    elsoKikepzotabor.repules(random.nextInt(20) + 10);
                    break;
            }


        }
    }

    private static void eredmenyKiir(Kikepzotabor tabor) {
          int roka=0, sas=0;
          for (Allatka allat : tabor.tulelokListaja()) {
              if (allat instanceof Sas) {
                  sas++;
              }else if (allat instanceof Roka) {
                  roka++;
              }
        }
          System.out.println("Sas: "+sas+System.lineSeparator()+
                  "Róka: "+roka+System.lineSeparator()+
                  "Kacsa: "+(tabor.tulelokSzama()-sas-roka));
    }
}
