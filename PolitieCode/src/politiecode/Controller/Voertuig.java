/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Controller;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import politiecode.Interface.IdbConnect;
import politiecode.Model.EntVoertuig;

/**
 *
 * @author rickd
 */
public class Voertuig implements IdbConnect {

    private Connection conn;
    EntVoertuig HetVoertuig;

    /**
     *
     * @return
     */
    @Override
    public boolean connectDb() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/politiecode?" + "user=root&password=");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     *
     * @param Kenteken
     * @param Voertuigsoort
     * @param merk
     * @param Handelsbenaming
     * @param Eerste_kleur
     * @param Tweede_kleur
     * @param Vervaldatum_apk
     * @return Bool
     */
    public boolean NieuwVoertuig(String Kenteken, String Voertuigsoort, String merk, String Handelsbenaming, String Eerste_kleur, String Tweede_kleur, String Vervaldatum_apk) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO Voertuig VALUES ('" + Kenteken + "','" + Voertuigsoort + "','" + merk + "', '" + Handelsbenaming + "','" + Eerste_kleur + "','" + Tweede_kleur + "','" + Vervaldatum_apk + "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     *
     * @param Kennteken
     */
    public void VoertuigInvoeren(String Kennteken) {
        try {
            URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken=" + Kennteken);
            JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
            JSONArray Auto = new JSONArray(tokener);

            for (int i = 0; i < Auto.length(); ++i) {
                JSONObject Json = Auto.getJSONObject(i);

                String Kenteken = Json.getString("kenteken");
                String Voertuigsoort = Json.getString("voertuigsoort");
                String merk = Json.getString("merk");
                String Handelsbenaming = Json.getString("handelsbenaming");
                String Eerste_kleur = Json.getString("eerste_kleur");
                String Tweede_kleur = Json.getString("tweede_kleur");
                String Vervaldatum_apk = Json.getString("vervaldatum_apk");

                NieuwVoertuig(Kenteken, Voertuigsoort, merk, Handelsbenaming, Eerste_kleur, Tweede_kleur, Vervaldatum_apk);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     *
     * @param Kenteken
     * @return bool
     */
    public boolean CheckKenteken(String Kenteken) {
        try (
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Voertuig WHERE Kenteken = ?")) {
            preparedStatement.setString(1, Kenteken);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @return LijstKenteken
     */
    public ObservableList<EntVoertuig> VulLijstKenteken() {
        try {
            Statement stmt = this.conn.createStatement();
            ObservableList<EntVoertuig> LijstKenteken = FXCollections.observableArrayList();
            ResultSet rs;
            if (stmt.execute("SELECT Kenteken FROM Voertuig")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    EntVoertuig HetKenteken = new EntVoertuig(rs.getString("Kenteken"),"DummyData","DummyData","DummyData","DummyData","DummyData","DummyData");
                    LijstKenteken.add(HetKenteken);
                }
            }
            return LijstKenteken;
        } catch (SQLException e) {
            return null;
        }
    }
    
    /**
     *
     * @param Kenteken
     * @param Voertuigsoort
     * @param merk
     * @param Handelsbenaming
     * @param Eerste_kleur
     * @param Tweede_kleur
     * @param Vervaldatum_apk
     * @return Bool
     */
    public boolean UpdateVoertuig(String Kenteken, String Voertuigsoort, String merk, String Handelsbenaming, String Eerste_kleur, String Tweede_kleur, String Vervaldatum_apk) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("update Voertuig set Kenteken = '" + Kenteken + "', Voertuigsoort = '" + Voertuigsoort + "',Merk = '" + merk + "', Handelsbenaming = '" + Handelsbenaming + "', Eerste_kleur = '" + Eerste_kleur + "',Tweede_kleur = '" + Tweede_kleur + "',Vervaldatum_apk = '" + Vervaldatum_apk + "'");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    /**
     *
     * @param Kennteken
     */
    public void VoertuigUpdate(String Kennteken) {
        try {
            URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken=" + Kennteken);
            JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
            JSONArray Auto = new JSONArray(tokener);

            for (int i = 0; i < Auto.length(); ++i) {
                JSONObject Json = Auto.getJSONObject(i);

                String Kenteken = Json.getString("kenteken");
                String Voertuigsoort = Json.getString("voertuigsoort");
                String merk = Json.getString("merk");
                String Handelsbenaming = Json.getString("handelsbenaming");
                String Eerste_kleur = Json.getString("eerste_kleur");
                String Tweede_kleur = Json.getString("tweede_kleur");
                String Vervaldatum_apk = Json.getString("vervaldatum_apk");

                UpdateVoertuig(Kenteken, Voertuigsoort, merk, Handelsbenaming, Eerste_kleur, Tweede_kleur, Vervaldatum_apk);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    /**
     *
     * @param Kenteken
     * @return Bool
     */
    public boolean DeleteVoertuig(String Kenteken) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("Delete from Voertuig where Kenteken = '" + Kenteken + "'");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    /**
     *
     * @param eKenteken
     * @return Bool
     */
    public EntVoertuig GeefVoertuig(String eKenteken) {
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs;
            if (stmt.execute("SELECT * FROM Voertuig where Kenteken = '" + eKenteken + "'")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                   HetVoertuig = new EntVoertuig(rs.getString("Kenteken"),rs.getString("Voertuigsoort"),rs.getString("Merk"),rs.getString("Handelsbenaming"),rs.getString("Eerste_kleur"),rs.getString("Tweede_kleur"),rs.getString("Vervaldatum_apk"));
                }
            }
            return HetVoertuig;
        } catch (SQLException e) {
            return null;
        }
    }

}
