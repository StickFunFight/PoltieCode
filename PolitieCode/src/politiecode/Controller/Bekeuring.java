/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.Preferences;

/**
 *
 * @author rickd
 */
public class Bekeuring {

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

    public boolean NieuweBoete(String Kenteken, String Reden) {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
            String formattedDate = sdf.format(date);
            
            Preferences prefs = Preferences.userNodeForPackage(politiecode.Controller.Medewerker.class);
            String MedewerkerId = prefs.get("MedewerkerId","");
            
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO Bekeuring VALUES (0,'" + Kenteken + "','" + Reden + "','" + formattedDate + "', '" + MedewerkerId + "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}
