package com.example.addressbook;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class ControllerAudio {

    @FXML
    private Slider volumeSlider;

    @FXML
    private Label labelName;

    @FXML
    private VBox vBox;

    @FXML
    private Label labelSlider;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    private File[] files;
    private ArrayList<File> songs = new ArrayList<> ();
    private int s;

    int score;

    public void initialize(){
        file = new File ( "music" );
        files = file.listFiles ();

        for (File f: files){
            songs.add ( f );

        }

        media = new Media ( songs.get ( s ).toURI ().toString () );
        mediaPlayer = new MediaPlayer ( media );

        volumeSlider.valueProperty ().addListener ( new ChangeListener<Number> () {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume ( volumeSlider.getValue () * 0.01 );

                score = (int) volumeSlider.getValue();
                labelSlider.setText(score + "%");
            }
        } );
    }

    @FXML
    void playAction(ActionEvent event) {
        mediaPlayer.play ();
        labelName.setText ( songs.get ( s ).getName () );

    }

    @FXML
    void pauseAction(ActionEvent event) {
        mediaPlayer.pause ();

    }

    @FXML
    void nextAction(ActionEvent event) {
        if (s < songs.size () - 1){
            s++;
            mediaPlayer.stop ();

            media = new Media ( songs.get ( s ).toURI ().toString () );
            mediaPlayer = new MediaPlayer ( media );
            mediaPlayer.play ();
            labelName.setText ( songs.get ( s ).getName () );

        } else {
            s = 0;

            mediaPlayer.stop ();

            media = new Media ( songs.get ( s ).toURI ().toString () );
            mediaPlayer = new MediaPlayer ( media );
            mediaPlayer.play ();
            labelName.setText ( songs.get ( s ).getName () );
        }

    }

    @FXML
    void previousAction(ActionEvent event) {
        if (s > 0){
            s--;
            mediaPlayer.stop ();

            media = new Media ( songs.get ( s ).toURI ().toString () );
            mediaPlayer = new MediaPlayer ( media );
            mediaPlayer.play ();
            labelName.setText ( songs.get ( s ).getName () );

        } else {
            s = songs.size () - 1;

            mediaPlayer.stop ();

            media = new Media ( songs.get ( s ).toURI ().toString () );
            mediaPlayer = new MediaPlayer ( media );
            mediaPlayer.play ();
            labelName.setText ( songs.get ( s ).getName () );
        }

    }

    @FXML
    void contextExit(ActionEvent event) {
        Stage stage = (Stage) vBox.getScene ().getWindow ();
        System.out.println("Ви успішно вийшли з програми");
        stage.close();
    }


}
