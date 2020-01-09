/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Model;

/**
 *
 * @author rickd
 */
public class EntBekeuring {
    
    public String Kenteken;
    public String Reden;
    public String Datum;
    public int MedewerkerId;

    /**
     *
     * @param Kenteken
     * @param Reden
     * @param Datum
     * @param MedewerkerId
     */
    public EntBekeuring(String Kenteken, String Reden, String Datum, int MedewerkerId) {
        this.Kenteken = Kenteken;
        this.Reden = Reden;
        this.Datum = Datum;
        this.MedewerkerId = MedewerkerId;
    }

    /**
     *
     * @return Kenteken
     */
    public String getKenteken() {
        return Kenteken;
    }

    /**
     *
     * @param Kenteken
     */
    public void setKenteken(String Kenteken) {
        this.Kenteken = Kenteken;
    }

    /**
     *
     * @return Reden
     */
    public String getReden() {
        return Reden;
    }

    /**
     *
     * @param Reden
     */
    public void setReden(String Reden) {
        this.Reden = Reden;
    }

    /**
     *
     * @return Datum
     */
    public String getDatum() {
        return Datum;
    }

    /**
     *
     * @param Datum
     */
    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    /**
     *
     * @return MedewerkerId
     */
    public int getMedewerkerId() {
        return MedewerkerId;
    }

    /**
     *
     * @param MedewerkerId
     */
    public void setMedewerkerId(int MedewerkerId) {
        this.MedewerkerId = MedewerkerId;
    }

    @Override
    public String toString() {
        return "EntBekeuring{" + "Kenteken=" + Kenteken + ", Reden=" + Reden + ", Datum=" + Datum + ", MedewerkerId=" + MedewerkerId + '}';
    }

}
