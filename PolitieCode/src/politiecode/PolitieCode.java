/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import politiecode.Controller.Alert;
import politiecode.Controller.Medewerker;

/**
 *
 * @author rickd
 */
public class PolitieCode extends Application {

    Medewerker db = new Medewerker();
    Alert popUp = new Alert();

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add(this.getClass().getResource("StyleSheet/Style.css").toExternalForm());
        primaryStage.setTitle("PolitieCode");
        primaryStage.setScene(scene);

        Button btnInloggen = new Button("Inloggen");
        TextField TxtNaam = new TextField("Rick");
        TextField TxtWachtwoord = new TextField("Rick");

        btnInloggen.getStyleClass().add("btn--default");
        TxtNaam.getStyleClass().add("TextField");
        TxtWachtwoord.getStyleClass().add("TextField");

        Label LblFout = new Label("Wachtwoord/Naam klopt niet!");
        LblFout.setVisible(false);
        LblFout.getStyleClass().add("label--error");

        btnInloggen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String Naam = TxtNaam.getText();
                String Wachtwoord = TxtWachtwoord.getText();
                try {
                    if (db.connectDb()) {
                        if (db.CheckInlog(Naam, Wachtwoord) == true) {
                            VoertuigenScherm VoertuigenScherm = new VoertuigenScherm(primaryStage, scene);

                        } else {
                            LblFout.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    popUp.PopUP("Er ging iets mis!"+ e);
                }
            }
        });

        TxtNaam.setLayoutX(500);
        TxtNaam.setLayoutY(200);
        TxtNaam.setPrefSize(300, 50);

        TxtWachtwoord.setLayoutX(500);
        TxtWachtwoord.setLayoutY(260);
        TxtWachtwoord.setPrefSize(300, 50);

        btnInloggen.setLayoutX(500);
        btnInloggen.setLayoutY(320);

        LblFout.setLayoutX(610);
        LblFout.setLayoutY(330);

        root.getChildren().addAll(TxtNaam, TxtWachtwoord, btnInloggen, LblFout);

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
