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
public class EntMedewerker {
    
    public String Naam;
    public String Wachtwoord;

    /**
     *
     * @param Naam
     * @param Wachtwoord
     */
    public EntMedewerker(String Naam, String Wachtwoord) {
        this.Naam = Naam;
        this.Wachtwoord = Wachtwoord;
    }

    /**
     *
     * @return
     */
    public String getNaam() {
        return Naam;
    }

    /**
     *
     * @param Naam
     */
    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    /**
     *
     * @return
     */
    public String getWachtwoord() {
        return Wachtwoord;
    }

    /**
     *
     * @param Wachtwoord
     */
    public void setWachtwoord(String Wachtwoord) {
        this.Wachtwoord = Wachtwoord;
    }

    @Override
    public String toString() {
        return "EntMedewerker{" + "Naam=" + Naam + ", Wachtwoord=" + Wachtwoord + '}';
    }
    
    
}
