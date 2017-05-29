package ru.itis.controller;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.itis.dto.PrisonerDto;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.itis.controller.MainController.changePage;


/**
 * Created by kair4 on 06.05.2017.
 */
public class AllPrisonersController {
    private final String ALL_PRISONERS_URL = "http://localhost:8080/boss/"+MainController.currnetBoss.getId()+"/prisoners";
    private final String PRISONER_DELETE_URL = "http://localhost:8080/boss/"+MainController.currnetBoss.getId()+"/prisoner/";
    @FXML
    private TableView<PrisonerDto> allPrisoners;
    @FXML
    private TableColumn<PrisonerDto, Long> id;
    @FXML
    private TableColumn<PrisonerDto,String> firstName;
    @FXML
    private TableColumn<PrisonerDto,String> lastName;
    @FXML
    private TableColumn<PrisonerDto,Date> birthDay;
    @FXML
    private TableColumn<PrisonerDto,String> sex;
    @FXML
    private TableColumn<PrisonerDto,Date> closingDate;
    @FXML
    private TableColumn<PrisonerDto,String> relativesInf;
    @FXML
    private TableColumn<PrisonerDto,String> personality;
    @FXML
    private TableColumn<PrisonerDto,String> hierarchy;
    @FXML
    private TableColumn<PrisonerDto,Long> camera;

    @FXML
    private Button add;

    @FXML
    private Button delete;


    private void fillColumnTipe() {
        firstName.setCellValueFactory(new PropertyValueFactory<PrisonerDto, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<PrisonerDto, String>("lastName"));
        birthDay.setCellValueFactory(new PropertyValueFactory<PrisonerDto, Date>("birthDay"));
        sex.setCellValueFactory(new PropertyValueFactory<PrisonerDto, String>("sex"));
        closingDate.setCellValueFactory(new PropertyValueFactory<PrisonerDto, Date>("closingDate"));
        relativesInf.setCellValueFactory(new PropertyValueFactory<PrisonerDto, String>("relativeInf"));
        personality.setCellValueFactory(new PropertyValueFactory<PrisonerDto, String>("personality"));
        hierarchy.setCellValueFactory(new PropertyValueFactory<PrisonerDto, String>("hierarchyName"));
        camera.setCellValueFactory(new PropertyValueFactory<PrisonerDto, Long>("cameraNumber"));
        id.setCellValueFactory(new PropertyValueFactory<PrisonerDto, Long>("id"));
    }

    @FXML
    private void fillTable () throws IOException {
        fillColumnTipe();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("Auth-Token",MainController.token);
        headers.setAll(map);
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<?> response = new RestTemplate().exchange(ALL_PRISONERS_URL, HttpMethod.GET,request,List.class);
        ObservableList<PrisonerDto> data = allPrisoners.getItems();
        List<PrisonerDto> prisonerDtos= (List<PrisonerDto>) response.getBody();
        for(int i =0;i<prisonerDtos.size();i++){
            PrisonerDto p = mapper.convertValue(prisonerDtos.get(i), PrisonerDto.class);
            data.add(p);
        }
        allPrisoners.setItems(data);

    }


    public void addNewPrisoner(MouseEvent mouseEvent) {
        changePage(mouseEvent,"/fxml/addPrisoner.fxml",AllPrisonersController.class);
    }

    public void deletePrisoner(MouseEvent mouseEvent) {
        ObservableList<PrisonerDto> selectedPrisoner,allPrisoner;
        allPrisoner=allPrisoners.getItems();
        selectedPrisoner = allPrisoners.getSelectionModel().getSelectedItems();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("Auth-Token",MainController.token);
        headers.setAll(map);
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(PRISONER_DELETE_URL+selectedPrisoner.get(0).getId()+"/delete",request, List.class);
        selectedPrisoner.forEach(allPrisoner::remove);
    }

    public void logOut(MouseEvent mouseEvent) {
        changePage(mouseEvent,"/fxml/main.fxml",AllPrisonersController.class);
        MainController.token=null;
        MainController.currnetBoss=null;
    }
}
