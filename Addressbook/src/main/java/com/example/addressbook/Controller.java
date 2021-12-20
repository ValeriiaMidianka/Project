package com.example.addressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class Controller {

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private TableView<Person> tableAddressBook;

    @FXML
    private TextField txtSearch;

    @FXML
    private Label labelCount;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<Person, String> columnPip;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private VBox scenePane;


    private Stage stage;

    private Stage newStage;
    private Stage editDialogStage;
    private Parent root;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private ControllerModalWindow controllerModalWindow;

    public void setNewStage(Stage newStage) {

        this.newStage = newStage;
    }

    CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    public void initialize(){

         try {
             fxmlLoader.setLocation( Controller.class.getResource("/com/example/addressbook/ModalWindow.fxml"));
             root = fxmlLoader.load();
             controllerModalWindow = fxmlLoader.getController();
         } catch (IOException e) {
            e.printStackTrace();
        }

        columnPip.setCellValueFactory(new PropertyValueFactory<Person,String>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));


        addressBookImpl.fillTestData();
        backupList = FXCollections.observableArrayList();
        backupList.addAll(addressBookImpl.getPersonList());
        tableAddressBook.setItems(addressBookImpl.getPersonList());

    }

    @FXML
     void openbtnAdd(ActionEvent event) throws IOException {

        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()){
            case "btnAdd":
                controllerModalWindow.setPerson(new Person());
                showDialog();
                addressBookImpl.add(controllerModalWindow.getPerson());
                break;
            case "btnEdit":
                controllerModalWindow.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "btnDelete":
                addressBookImpl.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                break;
        }
    }


    public void showDialog(){
        editDialogStage = new Stage();
        Scene scene1 = new Scene ( root );
        editDialogStage.setScene(scene1);
        scene1.getStylesheets().clear();
        File file = new File("/Users/Роман/IdeaProjects/Addressbook/src/main/java/com/example/addressbook/my.css");
        String file_s = file.toURI().toString();
        scene1.getStylesheets().add(file_s);

        //stage.setScene(new Scene(root));
        editDialogStage.setTitle("Редагування");
        editDialogStage.setMinHeight(170);
        editDialogStage.setMinWidth(600);
        editDialogStage.setResizable(false);
        editDialogStage.initOwner(newStage);
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.showAndWait ();
    }


    @FXML
    void logout(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");
        alert.setContentText("Ви дійсно бажаєте вийти?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Ви успішно вийшли з програми");
            stage.close();
        }

    }


    @FXML
    void openKN(ActionEvent event) throws IOException, URISyntaxException {
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("KN");
      /* Image icon = new Image (getClass ().getResource ( "/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/img/icon2.png" ).toURI ().toString ());
        stage.getIcons().add(icon);
       stage.setResizable(false);*/

        stage.setScene(scene);

        stage.show();

    }

    public void openbtnDelete(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()){
            case "btnAdd":
                controllerModalWindow.setPerson(new Person());
                showDialog();
                addressBookImpl.add(controllerModalWindow.getPerson());
                break;
            case "btnEdit":
                controllerModalWindow.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "btnDelete":
                addressBookImpl.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                break;
        }
    }

    public void openbtnEdit(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()){
            case "btnAdd":
                controllerModalWindow.setPerson(new Person());
                showDialog();
                addressBookImpl.add(controllerModalWindow.getPerson());
                break;
            case "btnEdit":
                controllerModalWindow.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "btnDelete":
                addressBookImpl.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                break;
        }
    }

    @FXML
    void contextDelete(ActionEvent event) {
        addressBookImpl.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
    }

    @FXML
    void contextExit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");
        alert.setContentText("Ви дійсно бажаєте вийти?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Ви успішно вийшли з програми");
            stage.close();
        }

    }

    @FXML
    void menuExit(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("Ви успішно вийшли з програми");
        stage.close();
    }

    @FXML
    void menuDelete(ActionEvent event) {
        addressBookImpl.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
    }

    @FXML
    void menuAdd(ActionEvent event) {
        controllerModalWindow.setPerson(new Person());
        showDialog();
        addressBookImpl.add(controllerModalWindow.getPerson());
    }

    private ObservableList<Person> backupList;

    @FXML
    void actionSearch(ActionEvent event) {
        addressBookImpl.getPersonList ().clear ();

        for (Person person : backupList){
            if(person.getPip().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||

                    person.getPhone().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
                addressBookImpl.getPersonList().add(person);
            }
        }

    }

}