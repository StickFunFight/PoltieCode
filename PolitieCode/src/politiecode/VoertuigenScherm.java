/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import politiecode.Controller.Alert;
import politiecode.Controller.Bekeuring;
import politiecode.Controller.Voertuig;
import politiecode.Model.EntVoertuig;

/**
 *
 * @author rickd
 */
public class VoertuigenScherm {

    Voertuig Voertuig = new Voertuig();
    Bekeuring boete = new Bekeuring();
    Alert popUp = new Alert();
    String eKenteken;

    public VoertuigenScherm(Stage stage, Scene scene) {

        Pane root = new Pane();
        Scene nieuwScene = new Scene(root, 1280, 720);
        root.getStylesheets().add(this.getClass().getResource("StyleSheet/Style.css").toExternalForm());

        TextField TxtKenteken = new TextField();
        Label LblKenteken = new Label("Kenteken:");
        TextField TxteKenteken = new TextField();
        Label LblVoertuigsoort = new Label("Soort Voertuig:");
        TextField TxtVoertuigsoort = new TextField();
        Label LblMerk = new Label("Merk:");
        TextField TxtMerk = new TextField();
        Label LblModel = new Label("Model:");
        TextField Txthandelsbenaming = new TextField();
        Label LblKleur = new Label("Kleur:");
        TextField TxtKleur = new TextField();
        Label LblKleur2 = new Label("Tweede kleur:");
        TextField TxtKleurTwee = new TextField();
        Label LblVerval = new Label("Verval apk:");
        TextField TxtVervalDatum = new TextField();

        Button BtnKenteken = new Button("Zoeken");
        Button BtnVerwijderen = new Button("Verwijderen");
        Button BtnBekeuring = new Button("Bekeuring");

        TxtKenteken.setLayoutX(500);
        TxtKenteken.setLayoutY(10);
        TxtKenteken.getStyleClass().add("TextField");
        TxtKenteken.setPrefSize(300, 40);

        LblKenteken.setLayoutX(380);
        LblKenteken.setLayoutY(135);
        LblKenteken.getStyleClass().add("Label");

        TxteKenteken.setLayoutX(500);
        TxteKenteken.setLayoutY(130);
        TxteKenteken.getStyleClass().add("TextField");
        TxteKenteken.setPrefSize(400, 40);

        LblVoertuigsoort.setLayoutX(330);
        LblVoertuigsoort.setLayoutY(205);
        LblVoertuigsoort.getStyleClass().add("Label");

        TxtVoertuigsoort.setLayoutX(500);
        TxtVoertuigsoort.setLayoutY(200);
        TxtVoertuigsoort.getStyleClass().add("TextField");
        TxtVoertuigsoort.setPrefSize(400, 40);

        LblMerk.setLayoutX(430);
        LblMerk.setLayoutY(275);
        LblMerk.getStyleClass().add("Label");

        TxtMerk.setLayoutX(500);
        TxtMerk.setLayoutY(270);
        TxtMerk.getStyleClass().add("TextField");
        TxtMerk.setPrefSize(400, 40);

        LblModel.setLayoutX(425);
        LblModel.setLayoutY(345);
        LblModel.getStyleClass().add("Label");

        Txthandelsbenaming.setLayoutX(500);
        Txthandelsbenaming.setLayoutY(340);
        Txthandelsbenaming.getStyleClass().add("TextField");
        Txthandelsbenaming.setPrefSize(400, 40);

        LblKleur.setLayoutX(430);
        LblKleur.setLayoutY(415);
        LblKleur.getStyleClass().add("Label");

        TxtKleur.setLayoutX(500);
        TxtKleur.setLayoutY(410);
        TxtKleur.getStyleClass().add("TextField");
        TxtKleur.setPrefSize(400, 40);

        LblKleur2.setLayoutX(345);
        LblKleur2.setLayoutY(485);
        LblKleur2.getStyleClass().add("Label");

        TxtKleurTwee.setLayoutX(500);
        TxtKleurTwee.setLayoutY(480);
        TxtKleurTwee.getStyleClass().add("TextField");
        TxtKleurTwee.setPrefSize(400, 40);

        LblVerval.setLayoutX(375);
        LblVerval.setLayoutY(555);
        LblVerval.getStyleClass().add("Label");

        TxtVervalDatum.setLayoutX(500);
        TxtVervalDatum.setLayoutY(550);
        TxtVervalDatum.getStyleClass().add("TextField");
        TxtVervalDatum.setPrefSize(400, 40);

        BtnVerwijderen.setVisible(false);
        BtnVerwijderen.setLayoutX(10);
        BtnVerwijderen.setLayoutY(680);
        BtnVerwijderen.getStyleClass().add("BtnVerwijder");

        BtnKenteken.setLayoutX(810);
        BtnKenteken.setLayoutY(10);
        BtnKenteken.getStyleClass().add("btn--default");
        BtnKenteken.setPrefSize(120, 40);

        BtnBekeuring.setLayoutX(750);
        BtnBekeuring.setLayoutY(620);
        BtnBekeuring.getStyleClass().add("btn--default");
        BtnBekeuring.setPrefSize(150, 40);
        BtnBekeuring.setVisible(false);

        ListView<EntVoertuig> list = new ListView<>();

        list.setLayoutX(10);
        list.setLayoutY(60);
        list.setPrefSize(300, 600);
        list.getStyleClass().add("list-view");

        list.setOnMouseClicked(e -> {
            try {
                EntVoertuig HetVoertuig = list.getSelectionModel().getSelectedItem();
                eKenteken = HetVoertuig.getKenteken();
                BtnVerwijderen.setVisible(true);
                BtnBekeuring.setVisible(true);

                EntVoertuig hetVoertuig = Voertuig.GeefVoertuig(eKenteken);
                TxteKenteken.setText(hetVoertuig.getKenteken());
                TxtVoertuigsoort.setText(hetVoertuig.getVoertuigSoort());
                TxtMerk.setText(hetVoertuig.getMerk());
                Txthandelsbenaming.setText(hetVoertuig.getHandelsbenaming());
                TxtKleur.setText(hetVoertuig.getEerste_kleur());
                TxtKleurTwee.setText(hetVoertuig.getTweede_kleur());
                TxtVervalDatum.setText(hetVoertuig.getVervaldatum_apk());

            } catch (Exception ex) {
                popUp.PopUPWarning("Er ging iets mis!" + ex);
            }
        });

        BtnVerwijderen.setOnAction(e -> {
            if (Voertuig.connectDb()) {
                Voertuig.DeleteVoertuig(eKenteken);
                list.setItems(Voertuig.VulLijstKenteken());
                BtnVerwijderen.setVisible(false);
            } else {
                popUp.PopUPWarning("Er is geen database Connectie!");
            }
        });

        BtnKenteken.setOnAction(e -> {
            String Kenteken = TxtKenteken.getText();

            try {

                if (Voertuig.connectDb()) {
                    if (Voertuig.CheckKenteken(Kenteken.toUpperCase()) != true) {
                        Voertuig.VoertuigInvoeren(Kenteken.toUpperCase());
                        list.setItems(Voertuig.VulLijstKenteken());

                        EntVoertuig hetVoertuig = Voertuig.GeefVoertuig(Kenteken);
                        TxteKenteken.setText(hetVoertuig.getKenteken());
                        TxtVoertuigsoort.setText(hetVoertuig.getVoertuigSoort());
                        TxtMerk.setText(hetVoertuig.getMerk());
                        Txthandelsbenaming.setText(hetVoertuig.getHandelsbenaming());
                        TxtKleur.setText(hetVoertuig.getEerste_kleur());
                        TxtKleurTwee.setText(hetVoertuig.getTweede_kleur());
                        TxtVervalDatum.setText(hetVoertuig.getVervaldatum_apk());
                        BtnBekeuring.setVisible(true);
                    } else {
                        EntVoertuig hetVoertuig = Voertuig.GeefVoertuig(Kenteken);
                        TxteKenteken.setText(hetVoertuig.getKenteken());
                        TxtVoertuigsoort.setText(hetVoertuig.getVoertuigSoort());
                        TxtMerk.setText(hetVoertuig.getMerk());
                        Txthandelsbenaming.setText(hetVoertuig.getHandelsbenaming());
                        TxtKleur.setText(hetVoertuig.getEerste_kleur());
                        TxtKleurTwee.setText(hetVoertuig.getTweede_kleur());
                        TxtVervalDatum.setText(hetVoertuig.getVervaldatum_apk());
                        BtnBekeuring.setVisible(true);
                    }
                }
            } catch (Exception ex) {
                popUp.PopUPWarning("Er ging iets mis!" + ex);
            }
        });

        BtnBekeuring.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String HetKenteken = TxteKenteken.getText();
                GridPane gridPane = new GridPane();
                Stage stage = new Stage();

                Label LblKenteken = new Label("Kenteken");
                Label LblReden = new Label("Reden");

                LblKenteken.getStyleClass().add("Label");
                LblReden.getStyleClass().add("Label");

                TextField TxtKenteken = new TextField(HetKenteken);
                TextField TxtReden = new TextField();

                TxtKenteken.getStyleClass().add("TextField");
                TxtReden.getStyleClass().add("TextField");

                Button BtnOpslaan = new Button("Opslaan");
                Button BtnCancel = new Button("Annuleren");

                BtnCancel.getStyleClass().add("btn--default");
                BtnOpslaan.getStyleClass().add("btn--default");

                gridPane.setMinSize(400, 200);
                gridPane.setPadding(new Insets(10, 10, 10, 10));
                gridPane.setVgap(5);
                gridPane.setHgap(5);
                gridPane.setAlignment(Pos.CENTER);

                gridPane.add(LblKenteken, 0, 0);
                gridPane.add(TxtKenteken, 1, 0);

                gridPane.add(LblReden, 0, 1);
                gridPane.add(TxtReden, 1, 1);

                gridPane.add(BtnOpslaan, 0, 2);
                gridPane.add(BtnCancel, 1, 2);

                stage.setTitle("Bekeuring");
                gridPane.getStylesheets().add(this.getClass().getResource("StyleSheet/Style.css").toExternalForm());
                stage.setScene(new Scene(gridPane, 700, 500));
                stage.show();

                BtnCancel.setOnAction(e -> {
                    stage.close();
                });

                BtnOpslaan.setOnAction(e -> {
                    if (boete.connectDb()) {
                        boete.NieuweBoete(HetKenteken, TxtReden.getText());
                        popUp.PopUpConfirm("Opgelsagen!");
                        stage.close();
                    }
                });
            }
        });

        if (Voertuig.connectDb()) {
            list.setItems(Voertuig.VulLijstKenteken());
        }

        root.getChildren().addAll(TxtKenteken, TxteKenteken, TxtVoertuigsoort, TxtMerk, Txthandelsbenaming, TxtKleur, TxtKleurTwee, TxtVervalDatum, BtnKenteken, BtnVerwijderen, list,
                LblKenteken, LblVoertuigsoort, LblMerk, LblModel, LblKleur, LblKleur2, LblVerval, BtnBekeuring);
        stage.setScene(nieuwScene);

    }
}
