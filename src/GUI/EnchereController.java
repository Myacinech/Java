/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Enchere;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author yacin
 */
public class EnchereController implements Initializable {

    @FXML
    private TableView<Enchere> table;
    @FXML
    private TableColumn<Enchere, String> tdTitre;
    @FXML
    private TableColumn<Enchere, String> tdID;
    @FXML
    private TableColumn<Enchere, String> tdDecsrp;
    @FXML
    private TableColumn<Enchere, String> tdDD;
    @FXML
    private TableColumn<Enchere, String> tdDF;
    @FXML
    private TableColumn<Enchere, Double> tdOffre;
    @FXML
    private DatePicker datefin;
    @FXML
    private DatePicker datedebut;
    @FXML
    private Button BtnAjouter;
    @FXML
    private Button BtnModifier;
    @FXML
    private Button BtnSupprimer;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
