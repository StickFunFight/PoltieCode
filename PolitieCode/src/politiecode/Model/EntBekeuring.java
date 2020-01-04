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

    public EntBekeuring(String Kenteken, String Reden, String Datum, int MedewerkerId) {
        this.Kenteken = Kenteken;
        this.Reden = Reden;
        this.Datum = Datum;
        this.MedewerkerId = MedewerkerId;
    }

    public String getKenteken() {
        return Kenteken;
    }

    public void setKenteken(String Kenteken) {
        this.Kenteken = Kenteken;
    }

    public String getReden() {
        return Reden;
    }

    public void setReden(String Reden) {
        this.Reden = Reden;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    public int getMedewerkerId() {
        return MedewerkerId;
    }

    public void setMedewerkerId(int MedewerkerId) {
        this.MedewerkerId = MedewerkerId;
    }

    @Override
    public String toString() {
        return "EntBekeuring{" + "Kenteken=" + Kenteken + ", Reden=" + Reden + ", Datum=" + Datum + ", MedewerkerId=" + MedewerkerId + '}';
    }

}
