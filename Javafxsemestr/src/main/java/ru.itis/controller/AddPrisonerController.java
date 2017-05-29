package ru.itis.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.itis.dto.PrisonerDto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static ru.itis.controller.MainController.changePage;

/**
 * Created by kair4 on 18.05.2017.
 */
public class AddPrisonerController {
    private static final String PRISONER_ADD_URL = "http://localhost:8080/boss/"+MainController.currnetBoss.getId()+"/prisoner/add";
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField cameraNumber;

    @FXML
    private TextField birthDay;

    @FXML
    private TextField sex;

    @FXML
    private TextField closingDate;

    @FXML
    private TextField relativeInf;

    @FXML
    private TextField personality;

    @FXML
    private TextField hierarchy;

    @FXML
    private Button back;

    public void back(MouseEvent mouseEvent) {
        changePage(mouseEvent,"/fxml/allPrisoners.fxml",RegistrationController.class);
    }

    public void addPrisoner(MouseEvent mouseEvent) {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            Map map = new HashMap<String, String>();
            map.put("Content-Type", "application/json");
            map.put("Auth-Token",MainController.token);
            headers.setAll(map);
            Map body = new HashMap();
            body.put("firstName",firstname.getText());
            body.put("lastName",lastname.getText());
            body.put("birthDay",birthDay.getText());
            body.put("sex",sex.getText());
            body.put("closingDate",closingDate.getText());
            body.put("relativeInf",relativeInf.getText());
            body.put("personality",personality.getText());
            body.put("hierarchyName",hierarchy.getText());
            body.put("cameraNumber",cameraNumber.getText());
            HttpEntity<?> request = new HttpEntity<>(body,headers);
            ResponseEntity<?> response = new RestTemplate().exchange(PRISONER_ADD_URL, HttpMethod.POST,request, PrisonerDto.class);
            if (response.getStatusCode().value()==200){
                changePage(mouseEvent,"/fxml/allPrisoners.fxml",RegistrationController.class);

            }
    }
}
