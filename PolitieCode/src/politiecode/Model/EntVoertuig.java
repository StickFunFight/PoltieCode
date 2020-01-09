/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Model;

/**
 *
 * @author Rick
 */
public class EntVoertuig {

    public String Kenteken;
    public String VoertuigSoort;
    public String Merk;
    public String Handelsbenaming;
    public String Eerste_kleur;
    public String Tweede_kleur;
    public String Vervaldatum_apk;

    /**
     *
     * @param Kenteken
     * @param VoertuigSoort
     * @param Merk
     * @param Handelsbenaming
     * @param Eerste_kleur
     * @param Tweede_kleur
     * @param Vervaldatum_apk
     */
    public EntVoertuig(String Kenteken, String VoertuigSoort, String Merk, String Handelsbenaming, String Eerste_kleur, String Tweede_kleur, String Vervaldatum_apk) {
        this.Kenteken = Kenteken;
        this.VoertuigSoort = VoertuigSoort;
        this.Merk = Merk;
        this.Handelsbenaming = Handelsbenaming;
        this.Eerste_kleur = Eerste_kleur;
        this.Tweede_kleur = Tweede_kleur;
        this.Vervaldatum_apk = Vervaldatum_apk;
    }

    @Override
    public String toString() {
        return Kenteken;
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
     * @return VoertuigSoort
     */
    public String getVoertuigSoort() {
        return VoertuigSoort;
    }

    /**
     *
     * @param VoertuigSoort
     */
    public void setVoertuigSoort(String VoertuigSoort) {
        this.VoertuigSoort = VoertuigSoort;
    }

    /**
     *
     * @return Merk
     */
    public String getMerk() {
        return Merk;
    }

    /**
     *
     * @param Merk
     */
    public void setMerk(String Merk) {
        this.Merk = Merk;
    }

    /**
     *
     * @return Handelsbenaming
     */
    public String getHandelsbenaming() {
        return Handelsbenaming;
    }

    /**
     *
     * @param Handelsbenaming
     */
    public void setHandelsbenaming(String Handelsbenaming) {
        this.Handelsbenaming = Handelsbenaming;
    }

    /**
     *
     * @return Eerste_kleur
     */
    public String getEerste_kleur() {
        return Eerste_kleur;
    }

    /**
     *
     * @param Eerste_kleur
     */
    public void setEerste_kleur(String Eerste_kleur) {
        this.Eerste_kleur = Eerste_kleur;
    }

    /**
     * 
     * @return Tweede_kleur
     */
    public String getTweede_kleur() {
        return Tweede_kleur;
    }

    /**
     *
     * @param Tweede_kleur
     */
    public void setTweede_kleur(String Tweede_kleur) {
        this.Tweede_kleur = Tweede_kleur;
    }

    /**
     *
     * @return Vervaldatum_apk
     */
    public String getVervaldatum_apk() {
        return Vervaldatum_apk;
    }

    /**
     *
     * @param Vervaldatum_apk
     */
    public void setVervaldatum_apk(String Vervaldatum_apk) {
        this.Vervaldatum_apk = Vervaldatum_apk;
    }

}
