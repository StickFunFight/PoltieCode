/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Model;

import java.time.LocalDate;

/**
 *
 * @author rickd
 */
public class EntAuto {

    public String Kenteken;
    public String VoertuigSoort;
    public String Merk;
    public String Handelsbenaming;
    public String Eerste_kleur;
    public String Tweede_kleur;
    public LocalDate Vervaldatum_apk;

    public EntAuto(String Kenteken) {
        this.Kenteken = Kenteken;
    }

    @Override
    public String toString() {
        return Kenteken;
    }
    
    public String getKenteken() {
        return Kenteken;
    }

    public void setKenteken(String Kenteken) {
        this.Kenteken = Kenteken;
    }

    public String getVoertuigSoort() {
        return VoertuigSoort;
    }

    public void setVoertuigSoort(String VoertuigSoort) {
        this.VoertuigSoort = VoertuigSoort;
    }

    public String getMerk() {
        return Merk;
    }

    public void setMerk(String Merk) {
        this.Merk = Merk;
    }

    public String getHandelsbenaming() {
        return Handelsbenaming;
    }

    public void setHandelsbenaming(String Handelsbenaming) {
        this.Handelsbenaming = Handelsbenaming;
    }

    public String getEerste_kleur() {
        return Eerste_kleur;
    }

    public void setEerste_kleur(String Eerste_kleur) {
        this.Eerste_kleur = Eerste_kleur;
    }

    public String getTweede_kleur() {
        return Tweede_kleur;
    }

    public void setTweede_kleur(String Tweede_kleur) {
        this.Tweede_kleur = Tweede_kleur;
    }

    public LocalDate getVervaldatum_apk() {
        return Vervaldatum_apk;
    }

    public void setVervaldatum_apk(LocalDate Vervaldatum_apk) {
        this.Vervaldatum_apk = Vervaldatum_apk;
    }

}
