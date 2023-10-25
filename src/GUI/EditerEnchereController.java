/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Proposition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author yacin
 */
public class EditerEnchereController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void BtnSupprimer() {
    	String query = "DELETE FROM Proposition WHERE ID="+idField.getText()+"";
    	executeQuery(query);
    	showProposition();
    }
    
    public void showProposition() {
    	ObservableList<Proposition> list = getPropositionList();
    	
    	idColumn.setCellValueFactory(new PropertyValueFactory<Proposition,String>("id"));
    	titleColumn.setCellValueFactory(new PropertyValueFactory<Proposition,String>("title"));
    	authorColumn.setCellValueFactory(new PropertyValueFactory<Proposition,String>("author"));
    	yearColumn.setCellValueFactory(new PropertyValueFactory<Proposition,String>("year"));
    	pagesColumn.setCellValueFactory(new PropertyValueFactory<Proposition,Double>("pages"));
    	
    	TableView.setItems(list);
    }
}
