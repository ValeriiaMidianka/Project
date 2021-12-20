package com.example.addressbook;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( Application.class.getResource("addressbook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        scene.getStylesheets().clear();
        File file = new File("/Users/Роман/IdeaProjects/Addressbook/src/main/java/com/example/addressbook/my.css");
        String file_s = file.toURI().toString();
        scene.getStylesheets().add(file_s);

        stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.setTitle("Адресна книга");

        Controller controller = fxmlLoader.getController();
        controller.setNewStage(stage);

        stage.setScene(scene);
        stage.show();

        test();

        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }

    public void test(){
        CollectionAddressBook addressBook = new CollectionAddressBook();
        addressBook.fillTestData();
        addressBook.print();
    }

    void logout(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");
        alert.setContentText("Ви дійсно бажаєте вийти?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Ви успішно вийшли з програми");
            stage.close();
        }

    }
}