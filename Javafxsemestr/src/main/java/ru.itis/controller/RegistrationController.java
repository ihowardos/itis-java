package ru.itis.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ru.itis.controller.MainController.changePage;

/**
 * Created by kair4 on 06.05.2017.
 */
public class RegistrationController {
    private final String AUTH_URL = "http://localhost:8080/auth";

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button signUpButton;

    @FXML
    private Button back;

    @FXML
    private void signUp () {
        if (password.getText().equals(confirmPassword.getText())) {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            Map map = new HashMap<String, String>();
            map.put("Content-Type", "application/json");
            headers.setAll(map);
            Map body = new HashMap();
            body.put("firstName",firstname.getText());
            body.put("lastName",lastname.getText());
            body.put("email",email.getText());
            body.put("password",password.getText());
            HttpEntity<?> request = new HttpEntity<>(body,headers);
            ResponseEntity<?> response = new RestTemplate().postForEntity(AUTH_URL, request, String.class);
            signUpButton.setOnMouseClicked(this::signUpOnAction);
            back.setOnMouseClicked(this::back);
        }


    }

    private void signUpOnAction(MouseEvent mouseEvent) {
        changePage(mouseEvent,"/fxml/allPrisoners.fxml",RegistrationController.class);
    }


    public void back(MouseEvent mouseEvent) {
        changePage(mouseEvent,"/fxml/main.fxml",RegistrationController.class);
    }
}
