/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.prefs.Preferences;
import politiecode.Interface.IdbConnect;

/**
 *
 * @author rickd
 */
public class Medewerker implements IdbConnect {

    private Connection conn;

    /**
     *
     * @return bool
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
     * @param Naam
     * @param Wachtwoord
     * @return bool
     */
    public boolean CheckInlog(String Naam, String Wachtwoord) {
        try (
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM medewerker WHERE Naam = ? and Wachtwoord = ?")) {
            preparedStatement.setString(1, Naam);
            preparedStatement.setString(2, Wachtwoord);
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
     *Deze functie haalt het Id van de medeweker op en slaat deze op in de prefs zodat ik deze later kan gebruiken
     * @param Naam
     * @param Wachtwoord
     */
    public void IdOpslaan(String Naam, String Wachtwoord) {
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs;
            if (stmt.execute("SELECT Id FROM medewerker Where Naam = '" + Naam + "' and Wachtwoord = '" + Wachtwoord + "'")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    String Id = rs.getString("Id");
                    Preferences prefs = Preferences.userNodeForPackage(politiecode.Controller.Medewerker.class);
                    prefs.put("MedewerkerId", Id);
                }
            }
        } catch (SQLException e) {

        }
    }

}
