/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author yacin
 */
public class AjoutEnchereController implements Initializable {

    @FXML
    private Button btnRetour;
    @FXML
    private DatePicker dpdatedebut;
    @FXML
    private DatePicker dpdatefin;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfTitre;

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
    private void offre_initial(MouseEvent event) {
    }
    
}
