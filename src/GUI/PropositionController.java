/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Proposition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author yacin
 */
public class PropositionController implements Initializable {

    @FXML
    private TableView<Proposition> table;
    @FXML
    private TableColumn<Proposition, String> tdNom;
    @FXML
    private TableColumn<Proposition, String> tdIdEntr;
    @FXML
    private TableColumn<Proposition, String> tdTel;
    @FXML
    private TableColumn<Proposition, String> tdMail;
    @FXML
    private TableColumn<Proposition, String> tdTitre;
    @FXML
    private TableColumn<Proposition, Double> tdMontant;
    @FXML
    private TableColumn<Proposition, String> tdMessage;
    @FXML
    private Button BtnAjouter;
    @FXML
    private Button BtnModifier;
    @FXML
    private Button BtnSupprimer;

    private void BtnAjouter() {
    	String query = "insert into proposition values("+tdNom.getText()+",'"+tdIdEntr.getText()+"','"+tdTel.getText()+"',"+tdMail.getText()+","+tdTitre.getText()+","+tdMontant.getText()+","+tdMessage.getText()+" )";
    	executeQuery(query);
    	afficherProposition();
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void BtnModifier() {
    String query = "UPDATE proposition SET Nom='"+tdNom.getText()+"',Id='"+tdIdEntr.getText()+"',Tel="+tdTel.getText()+",Mail="+tdMail.getText()+",Montant="+tdMontant.getText()+ ",Message="+tdMessage.getText()+" WHERE ID="+tdIdEntr.getText()+"";
    executeQuery(query);
	afficherProposition();
    }
    
    private void BtnSupprimer() {
    	String query = "DELETE FROM proposition WHERE ID="+tdIdEntr.getText()+"";
    	executeQuery(query);
    	afficherProposition();
    }
    public void afficherProposition() {
    	ObservableList<Proposition> list;
        list = getPropositionList();
    	
    	tdNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    	tdIdEntr.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	tdTel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
    	tdMail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
    	tdTitre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        tdMontant.setCellValueFactory(new PropertyValueFactory<>("Montant"));
        tdMessage.setCellValueFactory(new PropertyValueFactory<>("Message"));
    	
    	TableView.setItems(list);
    }
    

    public void executeQuery(String query) {
    	Connection conn = getConnection();
    	Statement st;
    	try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    private ObservableList<Proposition> getPropositionList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
