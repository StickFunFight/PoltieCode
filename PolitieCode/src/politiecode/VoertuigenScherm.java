/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rickd
 */
public class VoertuigenScherm {

    public VoertuigenScherm(Stage stage, Scene scene) {

        Pane root = new Pane();
        Scene nieuwScene = new Scene(root, 1280, 720);
        nieuwScene.getStylesheets().add(this.getClass().getResource("StyleSheet/Style.css").toExternalForm());
        stage.setScene(nieuwScene);
    }

}
