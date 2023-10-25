/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
    private TableColumn<?, ?> tdNom;
    @FXML
    private TableColumn<?, ?> tdId;
    @FXML
    private TableColumn<?, ?> tdMail;
    @FXML
    private TableColumn<?, ?> tdTitre;
    @FXML
    private TableColumn<?, ?> tdMontant;
    @FXML
    private TableColumn<?, ?> tdMessage;
    @FXML
    private TableColumn<?, ?> tdNumero_telephone;

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
