package ru.itis.controller;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import javafx.scene.control.TextField;
import ru.itis.dto.BossDataForRegistrationDto;
import ru.itis.dto.BossDto;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kair4 on 01.05.2017.
 */
public class MainController {
    public static String token;
    public static BossDto currnetBoss;
    private final String LOGIN_URL = "http://localhost:8080/login";

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label errorLabel;
    @FXML
    private Button singUpButton;



    @FXML private void login (MouseEvent mouseEvent) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("password",password.getText());
        map.put("email",login.getText());
        headers.setAll(map);
        HttpEntity<?> request = new HttpEntity<>(headers);
        try {
            if (!login.getText().equals("") && !password.getText().equals("")) {
                ResponseEntity<?> response = new RestTemplate().postForEntity(LOGIN_URL, request, String.class);
                HttpHeaders responseHeaders = response.getHeaders();
                if (response.getStatusCode().value() == 200) {
                    token = responseHeaders.get("Auth-Token").get(0);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    currnetBoss = mapper.readValue((String) response.getBody(), BossDto.class);
                    changePage(mouseEvent,"/fxml/allPrisoners.fxml",MainController.class);
                }
            }
        } catch (Exception e) {
            login.setText("");
            password.setText("");
            errorLabel.setText("Incorrect login or password");
        }

    }


    @FXML
    private void toSingUp (MouseEvent mouseEvent){
        changePage(mouseEvent,"/fxml/registration.fxml",MainController.class);
    }





    public static void changePage(Event event, String fxmlFile, Class c) {
        Parent homePageParent = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            homePageParent = (Parent) loader.load(c.getClass().getResourceAsStream(fxmlFile));
            Scene homePageScene = new Scene(homePageParent);
            Stage appStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(homePageScene);
            appStage.centerOnScreen();
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
