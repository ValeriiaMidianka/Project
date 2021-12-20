module com.example.addressbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires javafx.media;
    requires controlsfx;


    opens com.example.addressbook to javafx.fxml;
    exports com.example.addressbook;
}