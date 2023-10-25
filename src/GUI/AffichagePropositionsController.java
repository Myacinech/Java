/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Proposition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author yacin
 */
public class AffichagePropositionsController implements Initializable {

    @FXML
    private Button BtnRetour;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<Proposition, String> tdNom;
    @FXML
    private TableColumn<Proposition, String> tdId;
    @FXML
    private TableColumn<Proposition, String> tdMail;
    @FXML
    private TableColumn<Proposition, String> tdTitre;
    @FXML
    private TableColumn<Proposition, Double> tdMontant;
    @FXML
    private TableColumn<Proposition, String> tdMessage;
    @FXML
    private TableColumn<Proposition, String> tdNumero_telephone;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Retour(ActionEvent event) {
    }

    
}
