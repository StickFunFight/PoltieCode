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
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author rickd
 */
public class Voertuig {

    private Connection conn;

    public boolean connectDb() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/politiecode?" + "user=root&password=");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

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
}
