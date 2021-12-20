package com.example.addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ControllerTest {
    @FXML
    private ToggleGroup answers;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Button answerBtn;

    @FXML
    private AnchorPane anchorPane;

    private Stage stage;



   private Questions[] questions = new Questions[] {
           new Questions("Який метод спрацьовує одразу ж після загрузки fxml-файлу у контролері?", new String[] {"@FXML", "setOnAction", "FXMLLoader.load()", "initialize()"}),
           new Questions("Дана панель надає п'ять частин, в яких розміщуються компоненти: верхня, нижня, ліва, права та центральна.", new String[] {"Grid Pane", "Stack Pane", "Flow Pane", "Border Pane"}),
           new Questions("Для того, щоб добавити дію (виконання/метод) до якогось елемента потрібно зайти у меню", new String[] {"Properties/On Action", "Properties/fx:id", "Code/fx:id", "Code/On Action"}),
           new Questions("Меню, яке містить спкцифічні команди, що можуть бути застосовані до об'єкту, на який наведено курсор.", new String[] {"CustomMenu", "SeparatorMenu", "MenuBar", "ContextMenu"}),
           new Questions("Колекція, яка зберігає виключно унікальні значення це - ", new String[] {"Set", "Collection", "Map", "List"}),
           new Questions("Клас-обгортка це про:", new String[] {"add.Listener", "ArrayList", "PropertyValueFactory", "ObservableList"})
   };


    private int nowQuestion = 0, correctAnswers;

    private String nowCorrectAnswer;

    @FXML
    public void initialize() {

        nowCorrectAnswer = questions[nowQuestion].correctAnswer();


        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Відповідь правильна!");
                    correctAnswers++;
                } else
                    System.out.println("Відповідь  не правильна!");

                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);


                    question_text.setText("Ви відповіли правильно на " + correctAnswers + " з " + questions.length + " питань!");
                } else {
                    nowQuestion++;

                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());

                    String[] answers = questions[nowQuestion].getAnswers();

                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });
    }
    @FXML
    void exit(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");
        alert.setContentText("Ви дійсно бажаєте закрити програму?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("Ви успішно закрили програму");
            stage.close();
        }

    }
}
