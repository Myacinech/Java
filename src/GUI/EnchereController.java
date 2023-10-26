/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Enchere;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
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
    private void BtnAjouter() {
    	String query = "insert into enchere values("+tdTitre.getText()+",'"+tdID.getText()+"','"+tdDecsrp.getText()+"',"+tdDD.getText()+","+tdDF.getText()+","+tdOffre.getText()+")";
    	executeQuery(query);
	afficherProposition();
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
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","admin");
    		return conn;
    	}
    	catch (SQLException e){
    		return null;
    	}
    }
    public ObservableList<Enchere> getenchereList(){
    	ObservableList<Enchere> enchereList = FXCollections.observableArrayList();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM enchere ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = (ResultSet) st.executeQuery(query);
			Enchere enchere;
			while(rs.next()) {
				enchere = new Enchere(rs.getInt("Titre"),rs.getString("Id"),rs.getString("Author"),rs.getInt("Year"),rs.getInt("Pages"));
				enchereList.add(enchere);
				}
		} catch (SQLException e) {
		}
    	return enchereList;
    }

    public void executeQuery(String query) {
    	Connection conn = getConnection();
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
