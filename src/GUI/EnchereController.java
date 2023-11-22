/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Enchere;
import Smartech.Ench.tools.MyBD;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.resource.cci.ResultSet;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.controller;

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
    @FXML
    private TableColumn<?, ?> tdid;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // It's better to initialize with empty list instead of null
        ObservableList<Enchere> list = FXCollections.observableArrayList();
        table.setItems(list);

        // Set up cell value factories for columns
        tdTitre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        tdID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tdDecsrp.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tdDD.setCellValueFactory(new PropertyValueFactory<>("DateDebut"));
        tdDF.setCellValueFactory(new PropertyValueFactory<>("DateFin"));
        tdOffre.setCellValueFactory(new PropertyValueFactory<>("Offre"));
    }
        @FXML
        private void BtnAjouter(ActionEvent event ) throws SQLException 
        
        {
        
            try {
        
                String query = "INSERT INTO enchere (Titre, ID, Description, DateDebut, DateFin, Offre) VALUES (?, ?, ?, ?, ?, ?)";

        
                MyBD connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Set the values for the placeholders in the query
        preparedStatement.setString(1, tdTitre.getText());
        preparedStatement.setString(2, tdID.getText());
        preparedStatement.setString(3, tdDecsrp.getText());
        preparedStatement.setString(4, tdDD.getText());
        preparedStatement.setString(5, tdDF.getText());
        preparedStatement.setDouble(6, Double.parseDouble(tdOffre.getText())); // Assuming Offre is of type double

        // Execute the update
        preparedStatement.executeUpdate();

        // Close the prepared statement
        preparedStatement.close();

        // Refresh the displayed data
        afficherProposition();
    } catch (NumberFormatException e) {
                

    }
}

    
      @FXML
    private void addservice(ActionEvent event) {
       try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterService.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) btnajouterservice.getScene().getWindow(); // Obtenir la fenêtre actuelle
        stage.setScene(scene);
    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }
    private void BtnModifier() {
    String query = "UPDATE enchere SET Titre='"+tdTitre.getText()+"',Description='"+tdDecsrp.getText()+"',datedebut="+tdDD.getText()+",datefin="+tdDF.getText()+",Offre="+tdOffre.getText()+ " WHERE ID="+tdID.getText()+"";
    executeQuery(query);
	afficherProposition();
    }
    
    private void BtnSupprimer() {
    	String query = "DELETE FROM enchere WHERE ID="+tdID.getText()+"";
    	executeQuery(query);
    	afficherProposition();
    }
    public void afficherProposition() {
    	ObservableList<Enchere> list;
        list = getEnchereList();
    	
    	tdTitre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
    	tdID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	tdDecsrp.setCellValueFactory(new PropertyValueFactory<>("Description"));
    	tdDD.setCellValueFactory(new PropertyValueFactory<>("DateDebut"));
    	tdDF.setCellValueFactory(new PropertyValueFactory<>("DateFin"));
        tdOffre.setCellValueFactory(new PropertyValueFactory<>("Offre"));
            	
    	table.setItems(list);
    }
    public MyBD getConnection() {
    	MyBD conn;
    	try {
    		conn = (MyBD) DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","admin");
    		return conn;
    	}
    	catch (SQLException e){
    		return null;
    	}
    }
    public ObservableList<Enchere> getenchereList(){
    	ObservableList<Enchere> enchereList = FXCollections.observableArrayList();
    	MyBD connection = getConnection();
    	String query = "SELECT * FROM enchere ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = (ResultSet) st.executeQuery(query);
			Enchere enchere;
			while(rs.next()) {
				enchere = new Enchere(rs.getString("Titre"),rs.getInteger("Id"),rs.getString("Author"),rs.getInt("Year"),rs.getInt("Pages"));
				enchereList.add(enchere);
				}
		} catch (SQLException e) {
		}
    	return enchereList;
    }

    public void executeQuery(String query) {
    	MyBD conn = getConnection();
    	Statement st;
    	try {

            st = conn.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
		}
    }

    private ObservableList<Enchere> getEnchereList() {
        return null;
         }
    
}
