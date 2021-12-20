package com.example.addressbook;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class ControllerVideo {

    @FXML
    private MediaView mediaView;

    @FXML
    private Button playButton;

    @FXML
    private VBox vBox;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Label labelSlider;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    int score;

    public void initialize(){
        file = new File ( "Місто весни.mp4" );
        media = new Media ( file.toURI ().toString () );
        mediaPlayer = new MediaPlayer ( media );

        mediaView.setMediaPlayer ( mediaPlayer );

        volumeSlider.valueProperty ().addListener ( new ChangeListener<Number> () {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume ( volumeSlider.getValue () * 0.01 );

                score = (int) volumeSlider.getValue();
                labelSlider.setText("Volume " + score + " %");
            }
        } );
    }

    @FXML
    void playAction(ActionEvent event) {
        mediaPlayer.play ();

    }

    @FXML
    void pauseAction(ActionEvent event) {
        mediaPlayer.pause ();

    }

    @FXML
    void resetAction(ActionEvent event) {
        mediaPlayer.seek ( Duration.seconds ( 0.0 ) );

    }

    @FXML
    void contextExit(ActionEvent event) {
        Stage stage = (Stage) vBox.getScene ().getWindow ();
        System.out.println("Ви успішно вийшли з програми");
        stage.close();
    }

}

