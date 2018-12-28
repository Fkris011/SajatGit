/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kacsakommando;

/**
 *
 * @author f_kri
 */
public class Sas extends Allatka {

    public Sas(int etel, int ital) {
        super(etel, ital);
    }

    @Override
    public void uszik(double tavolsag) {

    }

    @Override
    public void fut(int tavolsag) {
        
        double etelszukseglet = 5;
        double italszukseglet = 3;
        
        if (tavolsag <= 0) {
            System.out.println("Egy sas sem tud hátrafelé futni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult sas nem tud futni.");
        } else if ((this.getEtel() - (tavolsag * etelszukseglet) > 0) && ((this.getItal() - (tavolsag * italszukseglet)) > 0)) {
            this.eszik(etelszukseglet * tavolsag);
            this.iszik(italszukseglet * tavolsag);
            System.out.println(this + " Sas lefutotta a: " + tavolsag + " távolságot.");
        } else {
            this.elajul();
        }
    }

    @Override
    public void repul(int tavolsag) {
        
        double etelszukseglet = 0.5;
        double italszukseglet = 0.5;
        
        if (tavolsag <= 0) {
            System.out.println("Egy sas sem tud hátrafelé repülni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult sas nem tud repülni.");
        } else if ((this.getEtel() - (tavolsag * etelszukseglet) > 0) && ((this.getItal() - (tavolsag * italszukseglet)) > 0)) {
            this.eszik(etelszukseglet * tavolsag);
            this.iszik(italszukseglet * tavolsag);
            System.out.println(this + " Sas lerepülte a: " + tavolsag + " távolságot.");
        } else {
            this.elajul();
        }
    }

    @Override
    protected void elajul() {
        super.elajul();
        System.out.println(this + " sas elájult.");
    }

}
