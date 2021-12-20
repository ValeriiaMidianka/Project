package com.example.addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMainWindow {

    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane anchorPane;


    @FXML
    void about(MouseEvent event) {
        borderPane.setCenter ( anchorPane );

    }
    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load ( getClass ().getResource ( page+".fxml" ) );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        borderPane.setCenter ( root );
    }


    @FXML
    void openLabs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OtherLabs.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("Other Labs");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void openWeather(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("weather.fxml"));
        Scene scene = new Scene(root, 400, 600);
        Stage stage = new Stage();
        stage.setResizable ( false );

        stage.setTitle("Weather");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void openVideo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("video.fxml"));
        Scene scene = new Scene(root, 730, 600);
        Stage stage = new Stage();
        stage.setResizable ( false );

        stage.setTitle("Video Player");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void openAudio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("audio.fxml"));
        Scene scene = new Scene(root, 600, 200);
        Stage stage = new Stage();
        stage.setResizable ( false );

        stage.setTitle("Audio Player");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void openTest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene scene = new Scene(root, 900, 500);
        Stage stage = new Stage();
        stage.setResizable ( false );

        stage.setTitle("Тести з програмування");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }




    @FXML
    void contextExit(ActionEvent event) {
        Stage stage = (Stage) borderPane.getScene ().getWindow ();
        System.out.println("Ви успішно вийшли з програми");
        stage.close();
    }


}


