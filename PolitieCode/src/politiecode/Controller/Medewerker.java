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

/**
 *
 * @author rickd
 */
public class Medewerker {

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

    public boolean CheckInlog(String Naam, String Wachtwoord) {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (
                // Step 2:Create a statement using connection object
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
}
