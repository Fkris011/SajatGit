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
public class KepzettGladiator extends Gladiator {

    private Fegyvernem fegyvernem;
    private String becenev;

    public KepzettGladiator(byte ev, Szarmazas szarmazas, String becenev, 
            Fegyvernem fegyvernem) {
        super(ev, szarmazas);
        setBecenev(becenev);
        this.fegyvernem=fegyvernem;
    }

    public Fegyvernem getFegyvernem() {
        return fegyvernem;
    }

    public String getBecenev() {
        return becenev;
    }
    
     public final void setBecenev(String becenev) {
        if (becenev.length()>=3 && becenev.length()<=15) {
            this.becenev = becenev;
        }else{
            throw new IllegalArgumentException("falkjf");
        }
        
    }

    @Override
    protected void felszabadit() {
        super.felszabadit();
        System.out.println(this.getBecenev() + " -> FELSZABADÍTVA ( Juhuuu, pingvinhaver)");
    }
     
     

    @Override
    public void oregszik() {
        if (this.getEv() > 6) {
            this.setEv((byte) (this.getEv() + 1));

        }
        super.oregszik();
    }

    @Override
    public String toString() {
        return "KepzettGladiator{" + "fegyvernem=" + fegyvernem +
                ", becenev=" + becenev +" "+ super.toString();
    }
    
    
}
