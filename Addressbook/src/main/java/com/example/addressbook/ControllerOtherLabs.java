package com.example.addressbook;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControllerOtherLabs {
    @FXML
    private CheckBox ChBSklad;

    @FXML
    private CheckBox ChBSDruz;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private Label LbTrueAnswer;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label lblChoiceBox;

    @FXML
    private Label lblcomboBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton RadioBtnCode;

    @FXML
    private RadioButton RadioBtnProp;

    @FXML
    private RadioButton RadioBtnLay;

    @FXML
    private RadioButton RadioBtnHier;

    @FXML
    private Label lblRadioButton;

    @FXML
    private Label labelDate;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private HBox hBox;

    @FXML
    private Slider mySlider;

    @FXML
    private Label labelSlider;

    private Stage stage;

    @FXML
    void openOtherLabs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OtherLabs.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("Other Labs");
        // Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        // stage.getIcons().add(icon);
        //stage.setResizable(false);


        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void getDate(ActionEvent event) {
        LocalDate localDate = datePicker.getValue();
        String dateF = localDate.format(DateTimeFormatter.ofPattern("dd.MM.YY."));
        labelDate.setText(dateF);

    }

    @FXML
    void changeBackground(ActionEvent event) {
        Color myColor = colorPicker.getValue();
        hBox.setBackground(new Background(new BackgroundFill(myColor, null, null)));

    }

    private ToggleGroup radiotoggleGroup;

    int score;

    public void initialize(){

        LbTrueAnswer.setText("");

        lblChoiceBox.setText("");
        choiceBox.getItems().addAll("Правильно","Неправильно");

        lblcomboBox.setText("");
        comboBox.getItems().addAll("BorderPane", "AnchorPane","Vbox", "Hbox");

        lblChoiceBox.setText ( " " );


        lblRadioButton.setText("");
        radiotoggleGroup = new ToggleGroup();
        this.RadioBtnProp.setToggleGroup(radiotoggleGroup);
        this.RadioBtnLay.setToggleGroup(radiotoggleGroup);
        this.RadioBtnHier.setToggleGroup(radiotoggleGroup);
        this.RadioBtnCode.setToggleGroup(radiotoggleGroup);


        score = (int) mySlider.getValue();
        labelSlider.setText(score + " балів");

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                score = (int) mySlider.getValue();
                labelSlider.setText(score + " балів");

            }
        });

     }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
         if (ChBPogod.isSelected() && ChBGnuch.isSelected() && ChBSDruz.isSelected()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь правильна!");
            alert.setContentText("Дякую, за спробу!");

            alert.showAndWait();

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь неправильна!");
            alert.setContentText("Спробуйте ще раз!");
            alert.showAndWait();

        }

    }


    @FXML
    void choiceBoxAnswer(ActionEvent event) {
        if (choiceBox.getValue() == "Неправильно"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь правильна!");
            alert.setContentText("Дякую, за спробу!");

            alert.showAndWait();

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь неправильна!");
            alert.setContentText("Спробуйте ще раз!");
            alert.showAndWait();

        }

    }

    @FXML
    void comboBoxPressed(ActionEvent event) {
        if (comboBox.getValue () == "BorderPane") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь правильна!");
            alert.setContentText("Дякую, за спробу!");

            alert.showAndWait();

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь неправильна!");
            alert.setContentText("Спробуйте ще раз!");
            alert.showAndWait();

        }

    }

    @FXML
    void RadioAnswer(ActionEvent event){
        if(this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnProp)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь правильна!");
            alert.setContentText("Дякую, за спробу!");

            alert.showAndWait();

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Результати!");
            alert.setHeaderText("Ваша відповідь неправильна!");
            alert.setContentText("Спробуйте ще раз!");
            alert.showAndWait();
        }
    }

    @FXML
    void contextExit(ActionEvent event) {
        stage = (Stage) hBox.getScene().getWindow();
        System.out.println("Ви успішно вийшли з програми");
        stage.close();
    }
}
