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
public class Roka extends Allatka {

    public Roka(int etel, int ital) {
        super(etel, ital);
    }

    @Override
    public void uszik(double tavolsag) {

        double etelszukseglet = 6;
        double italszukseglet = 2;

        if (tavolsag <= 0) {
            System.out.println("Egy róka sem tud hátrafelé úszni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult róka nem tud úszni.");
        } else if ((this.getEtel() - (tavolsag * etelszukseglet) > 0) && ((this.getItal() - (tavolsag * italszukseglet)) > 0)) {
            this.eszik(-1 * tavolsag * etelszukseglet);
            this.iszik(-1 * tavolsag * italszukseglet);
            System.out.println(this + " Róka leúszta a: " + tavolsag + " távolságot.");
            this.iszik(5 * (int) (tavolsag / 1));
        } else {
            this.elajul();
        }
    }

    @Override
    public void fut(int tavolsag) {

        double etelszukseglet = 1;
        double italszukseglet = 1;

        if (tavolsag <= 0) {
            System.out.println("Egy róka sem tud hátrafelé futni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult róka nem tud futni.");
        } else if ((this.getEtel() - (tavolsag * etelszukseglet) > 0) && ((this.getItal() - (tavolsag * italszukseglet)) > 0)) {
            this.eszik(-etelszukseglet * tavolsag);
            this.iszik(-italszukseglet * tavolsag);
            System.out.println(this + " Róka lefutotta a: " + tavolsag + " távolságot.");
        } else {
            this.elajul();
        }
    }

    @Override
    public void repul(int tavolsag) {

    }

    @Override
    protected void elajul() {
        super.elajul();
        System.out.println(this + " róka elájult.");
    }

}
