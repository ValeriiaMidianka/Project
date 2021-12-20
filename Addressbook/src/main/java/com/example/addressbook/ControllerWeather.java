package com.example.addressbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONObject;

public class ControllerWeather {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private Text temp_info;

    @FXML
    private Text temp_max;

    @FXML
    private Text temp_min;

    @FXML
    private Button getData;

    @FXML
    private Text temp_feels;

    @FXML
    private Text pressure;

    @FXML
    private AnchorPane anchPane;


    @FXML
    void initialize() {
        getData.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if(!getUserCity.equals("")) {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=521e6dc32a13191b840727cf8b238550&units=metric");

                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    temp_info.setText("Temperature: " + obj.getJSONObject("main").getDouble("temp"));
                    temp_feels.setText("Feel: " + obj.getJSONObject("main").getDouble("feels_like"));
                    temp_max.setText("Maximum: " + obj.getJSONObject("main").getDouble("temp_max"));
                    temp_min.setText("Minimum: " + obj.getJSONObject("main").getDouble("temp_min"));
                    pressure.setText("Pressure: " + obj.getJSONObject("main").getDouble("pressure"));
                }
            }
        });
    }


    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("City not found!");
        }
        return content.toString();
    }

    @FXML
    void contextExit(ActionEvent event) {
        Stage stage = (Stage) anchPane.getScene ().getWindow ();
        System.out.println("Ви успішно вийшли з програми");
        stage.close();

    }

}