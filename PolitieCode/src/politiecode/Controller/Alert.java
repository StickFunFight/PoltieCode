/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode.Controller;

/**
 *
 * @author rickd
 */
public class Alert {
    
     public void PopUP(String Message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert.setContentText(Message);
        alert.showAndWait();
    }
}
