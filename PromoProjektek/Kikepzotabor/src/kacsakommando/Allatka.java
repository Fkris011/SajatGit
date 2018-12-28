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
public class Allatka implements IAllat{

    private double etel;
    private double ital;
    private boolean elajult;


    public Allatka(int etel, int ital) {
        this.etel = etel;
        this.ital = ital;
        this.elajult = false;
    }

    public double getEtel() {
        return etel;
    }

    private void setEtel(double etel) {
        this.etel = etel;
    }

    public double getItal() {
        return ital;
    }

    private void setItal(double ital) {
        this.ital = ital;
    }

    public boolean isElajult() {
        return elajult;
    }

    private void setElajult(boolean elajult) {
        this.elajult = elajult;
    }

    public void eszik(double mennyiseg) {
        
        if ((this.getEtel() + mennyiseg) <= 100) {
            this.setEtel(this.getEtel() + mennyiseg);
        }
    }

    public void iszik(double mennyiseg) {
        if ((this.getItal() + mennyiseg) <= 100) {
            this.setItal(this.getItal() + mennyiseg);
        }

    }
    
    protected void elajul(){
        this.setElajult(true);
    }

    @Override
    public void uszik(double tavolsag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fut(int tavolsag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void repul(int tavolsag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
    
}
