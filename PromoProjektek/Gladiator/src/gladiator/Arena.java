package gladiator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author f_kri
 *
 */
public class Arena {

    private List<KepzettGladiator> gladiatorKatakombak;
    private final String name;
    private List<KepzettGladiator> dicsőségCsarnoka;

    /* ebben a listában a 10 év harcot megélt, 
    és életben maradt harcosokat tároljuk. Segédmetódusa az addToHallOfFame*/


    public Arena(String name) {
        this.name = name;
        gladiatorKatakombak = new ArrayList<>();
        dicsőségCsarnoka = new ArrayList<>();
        
    }

    public void addFirst(String nameToAdd, byte evekSzama) {
        gladiatorKatakombak.add(new KepzettGladiator(evekSzama, Szarmazas.Romai, nameToAdd , Fegyvernem.Kard));

    }

    private void removeGladiator(KepzettGladiator gladiatorToRemove) { // ezzel a metódussal vesszük ki a váróból a halott gladiátorokat
        gladiatorKatakombak.remove(gladiatorToRemove);
        System.out.println(gladiatorToRemove.getBecenev() + " nevű harcosunk elesett. Hulláját kihúzták a szolgák a katakombákból.");
    }

    private void addToHallOfFame(KepzettGladiator felszabaditottGladiator) { // hozáadás a mindenkori nyertesek listájához
        felszabaditottGladiator.felszabadit();
        dicsőségCsarnoka.add(felszabaditottGladiator);
        gladiatorKatakombak.remove(felszabaditottGladiator);
    }

    private int generateRandom(int maxToGenerate) { // random számgenerálás, segédfüggvény

        Random rnd = new Random();
        return rnd.nextInt(maxToGenerate);
    }

    public void valogat() {
        /*Összeszedjük egy tornára a gladiátorokat. Töltsük fel a
        listát KepzettGladiator példánnyokal úgy, hogy minden egyes tornán
        pontosan 10 induló van, tehát ha az előző torna győztese még nem 10 éve
        rabszolga, akkor ő is részt vesz a következőn és mellé még 9-re van
        szükség. Ha az előző torna győztese elérte a 10 évet, akkor felszabadítják
        és törlésre kerül a listából.*/
     
        int tornanEgyszerreResztvevok = 10;
        
        if (gladiatorKatakombak.isEmpty()) {
            for (int i = 0; i < tornanEgyszerreResztvevok; i++) {
                gladiatorKatakombak.add(gladiatortGeneral());
            }
            
        } else if (gladiatorKatakombak.get(0).getEv() == 10) {
            gladiatorKatakombak.get(0).felszabadit();
            addToHallOfFame(gladiatorKatakombak.get(0));
            for (int i = 0; i < tornanEgyszerreResztvevok; i++) {
                gladiatorKatakombak.add(gladiatortGeneral());
            }
        } else {
            for (int i = 0; i < (tornanEgyszerreResztvevok - 1); i++) {
                gladiatorKatakombak.add(gladiatortGeneral());
            }
        }
    }

    private KepzettGladiator gladiatortGeneral() {
        byte ev = (byte) (generateRandom(5)+1);
        Fegyvernem[] fegyvernemTomb = Fegyvernem.values();
        Fegyvernem fegyvernem = fegyvernemTomb[generateRandom(fegyvernemTomb.length)];
        Szarmazas szarmazas = Szarmazas.values()[generateRandom(Szarmazas.values().length)];
        String becenev = "Ga" + generateRandom(10000);

        KepzettGladiator temp = new KepzettGladiator(ev, szarmazas, becenev, fegyvernem);
        return temp;

    }

    public void tornaIndul() {
        /* Addig harcoljanak párokban a gladiátorok míg csak egy
        marad élve (lista elemszáma = 1) Az egyetlen túlélő öregszik. Az eljárás
        írja ki a torna befejeztével, hogy ki nyert és neki minden adatát, valamint
        azt, hogy van-e „továbbjutó”. */

        KepzettGladiator nyertes;

        while (gladiatorKatakombak.size() != 1) {
            harc();
        }
        nyertes = gladiatorKatakombak.get(0);
        nyertes.oregszik();
        System.out.println(nyertes.toString());

        if (nyertes.getEv() != 10) {
            System.out.println("Van továbbjutó -> " + nyertes.getBecenev());
        }

    }

    public void harc() {
        /* Véletlenszerűen kiválaszt 2 küzdőfelet a listából és a
        tapasztaltabb győz (szinkod alapjan), a vesztes meghal, töröljük a listából
         */
        
        int harcbanResztvevok = 2;
        int elsoGladiatorSzama = generateRandom(gladiatorKatakombak.size());
        int masodikGladiatorSzama = generateRandom(gladiatorKatakombak.size());
        KepzettGladiator nyertes;

        while (elsoGladiatorSzama == masodikGladiatorSzama) {
            masodikGladiatorSzama = generateRandom(gladiatorKatakombak.size());
        }

        KepzettGladiator elsoGladiator = gladiatorKatakombak.get(elsoGladiatorSzama);
        KepzettGladiator masodikGladiator = gladiatorKatakombak.get(masodikGladiatorSzama);

        if (elsoGladiator.jobbGladiator(masodikGladiator) == 0) { // mivel 0 az eredmény, ezért szavazást hírdetünk
            int nyertesGladiator = szavaz(harcbanResztvevok);
            
            if (nyertesGladiator == 1) {
                gladiatorKatakombak.remove(masodikGladiator);
                
            } else if (nyertesGladiator == 2) {
                gladiatorKatakombak.remove(elsoGladiator);
                
            }

        } else if (elsoGladiator.jobbGladiator(masodikGladiator) < 0) { // második gladiátor nyert, elsőt töröljük
            removeGladiator(elsoGladiator);

        } else { // első gladiátor nyer, másodikat töröljük
            removeGladiator(masodikGladiator);
        }
    }

    private int szavaz(int harcbanResztvevok) {
        /* Segédfüggvénye a Harc()-nak.
        Ha egyformán tapasztalt a 2
        gladiátor, a közönség szavaz, hogy ki haljon meg. (véletlen szám
        generálással sorsolás) */
        return (generateRandom(harcbanResztvevok-1)+1);

    }

    public void listHallOfFame() {
        
        System.out.println("-------- HALL OF FAME --------");
        for (int i = 0; i < dicsőségCsarnoka.size(); i++) {
            
            System.out.println("| " +dicsőségCsarnoka.get(i).getBecenev()+" |");
            
        }
        System.out.println("------------------------------");
    }

}
