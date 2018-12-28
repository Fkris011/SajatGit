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
public class Kacsa extends Allatka {

    public Kacsa(int etel, int ital) {
        super(etel, ital);
    }

    @Override
    public void uszik(double tavolsag) {

        double etelszukseglet = 1;
        double italszukseglet = 0;

        if (tavolsag <= 0) {
            System.out.println("Egy kacsa sem tud hátrafelé úszni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult kacsa nem tud úszni.");
        } else if ((this.getEtel() / tavolsag) >= 1) {
            System.out.println(this + " Kacsa leúszta a: " + tavolsag + " távolságot.");

            this.eszik(-etelszukseglet * tavolsag);
            this.iszik(5 * (int) (tavolsag / 1));
        } else {
            this.elajul();
        }
    }

    @Override
    public void fut(int tavolsag) {

        double etelszukseglet = 7;
        double italszukseglet = 5;

        if (tavolsag <= 0) {
            System.out.println("Egy kacsa sem tud hátrafelé futni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult kacsa nem tud futni.");
        } else if ((this.getEtel() - (tavolsag * etelszukseglet) > 0) && ((this.getItal() - (tavolsag * italszukseglet)) > 0)) {
            this.eszik(-1 * tavolsag * etelszukseglet);
            this.iszik(-1 * tavolsag * italszukseglet);
            System.out.println(this + " Kacsa lefutotta a: " + tavolsag + " távolságot.");
        } else {
            this.elajul();
        }
    }

    @Override
    public void repul(int tavolsag) {

        double etelszukseglet = 5;
        double italszukseglet = 4;

        if (tavolsag <= 0) {
            System.out.println("Egy kacsa sem tud hátrafelé repülni.");
        } else if (this.isElajult()) {
            System.out.println("Egy elájult kacsa nem tud repülni.");
        } else if ((this.getEtel() - (tavolsag * etelszukseglet) > 0) && ((this.getItal() - (tavolsag * italszukseglet)) > 0)) {
            this.eszik(-1 * tavolsag * etelszukseglet);
            this.iszik(-1 * tavolsag * italszukseglet);
            System.out.println(this + " Kacsa lerepülte a: " + tavolsag + " távolságot.");
        } else {
            this.elajul();
        }
    }

    @Override
    protected void elajul() {
        super.elajul();
        System.out.println(this + " kacsa elájult.");
    }

}
