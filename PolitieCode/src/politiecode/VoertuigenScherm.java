/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politiecode;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import politiecode.Controller.Voertuig;

/**
 *
 * @author rickd
 */
public class VoertuigenScherm {

    Voertuig Voertuig = new Voertuig();
    
    public VoertuigenScherm(Stage stage, Scene scene) {
        Pane root = new Pane();
        Scene nieuwScene = new Scene(root, 1280, 720);
        nieuwScene.getStylesheets().add(this.getClass().getResource("StyleSheet/Style.css").toExternalForm());

        TextField TxtKenteken = new TextField();
        Button BtnKenteken = new Button("Zoeken");

        TxtKenteken.setLayoutX(500);
        TxtKenteken.setLayoutY(10);
        TxtKenteken.getStyleClass().add("TextField");
        TxtKenteken.setPrefSize(300, 40);

        BtnKenteken.setLayoutX(810);
        BtnKenteken.setLayoutY(10);
        BtnKenteken.getStyleClass().add("btn--default");
        BtnKenteken.setPrefSize(100, 30);

        ListView list = new ListView();
        list.setLayoutX(10);
        list.setLayoutY(60);
        list.setPrefSize(300, 600);
        list.getStyleClass().add("ListView");

        BtnKenteken.setOnAction(e -> {
         
           String Kenteken = TxtKenteken.getText();
           if(Voertuig.connectDb()){
               if(Voertuig.CheckKenteken(Kenteken.toUpperCase()) != true){
                  Voertuig.VoertuigInvoeren(Kenteken.toUpperCase()); 
               }else{
                   System.out.println("Bestaat al");
               } 
           }
         });
        
        root.getChildren().addAll(TxtKenteken, BtnKenteken, list);
        stage.setScene(nieuwScene);
    }

}
