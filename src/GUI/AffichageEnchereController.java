/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Smartech.Ench.entities.Enchere;
import Smartech.Ench.tools.MyBD;
import groovy.util.ObservableList;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import javafx.scene.control.Button;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author yacin
 */
public class AffichageEnchereController implements Initializable {
    //private connection cnx = MyBD.getInstance().getcnx();

    @FXML
    private Button BtnRetour;
    @FXML
    private TableView<String> table;
    @FXML
    private TableColumn<Enchere, String> tdTitre;
    @FXML
    private TableColumn<Enchere, String> tdId;
    @FXML
    private TableColumn<Enchere, String> tdDescription;
    @FXML
    private TableColumn<Enchere, String> tdDateDebut;
    @FXML
    private TableColumn<Enchere, String> tdDateFin;
    @FXML
    private TableColumn<Enchere, String> tdOffreInitial;
    private javafx.collections.ObservableList <Enchere> Encherelist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */ 
    @Override
     public void initialize(URL url, ResourceBundle rb) {
                     
                try {
          
            String query = "SELECT * FROM enchere";
            PreparedStatement ste = new MyBD().getCnx().prepareStatement(query);
            ResultSet rs = ste.executeQuery(query);
            
            
            while (rs.next()){
                tbTitre.setCellValueFactory(new PropertyValueFactory<Enchere,String>("Titre"));
                tbId.setCellValueFactory(new PropertyValueFactory<Enchere,String>("Id"));
                tbDescription.setCellValueFactory(new PropertyValueFactory<Enchere,String>("Description"));
                tbDateDebut.setCellValueFactory(new PropertyValueFactory<Enchere,String>("dateDebut"));
                tbDateFin.setCellValueFactory(new PropertyValueFactory<Enchere,String>("dateFin"));
                tbOffreinitial.setCellValueFactory(new PropertyValueFactory<Enchere,String>("offre_initial"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffichageEnchereController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Encheredistribution.setData(data);
        
        
            }


    @FXML
    private void Retour(ActionEvent event) {
        
    }

    /**
     * @return the BtnRetour
     */
    public Button getBtnRetour() {
        return BtnRetour;
    }

    /**
     * @param BtnRetour the BtnRetour to set
     */
    public void setBtnRetour(Button BtnRetour) throws PropertyVetoException {
        javafx.scene.control.Button oldBtnRetour = this.BtnRetour;
        vetoableChangeSupport.fireVetoableChange(PROP_BTNRETOUR, oldBtnRetour, BtnRetour);
        this.BtnRetour = BtnRetour;
        propertyChangeSupport.firePropertyChange(PROP_BTNRETOUR, oldBtnRetour, BtnRetour);
    }

    /**
     * @return the table
     */
    public TableView<String> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(TableView<String> table) throws PropertyVetoException {
        javafx.scene.control.TableView<java.lang.String> oldTable = this.table;
        vetoableChangeSupport.fireVetoableChange(PROP_TABLE, oldTable, table);
        this.table = table;
        propertyChangeSupport.firePropertyChange(PROP_TABLE, oldTable, table);
    }

    /**
     * @return the tdTitre
     */
    public TableColumn<Enchere, String> getTdTitre() {
        return tdTitre;
    }

    /**
     * @param tdTitre the tdTitre to set
     */
    public void setTdTitre(TableColumn<Enchere, String> tdTitre) throws PropertyVetoException {
        javafx.scene.control.TableColumn<Smartech.Ench.entities.Enchere, java.lang.String> oldTdTitre = this.tdTitre;
        vetoableChangeSupport.fireVetoableChange(PROP_TDTITRE, oldTdTitre, tdTitre);
        this.tdTitre = tdTitre;
        propertyChangeSupport.firePropertyChange(PROP_TDTITRE, oldTdTitre, tdTitre);
    }

    /**
     * @return the tdId
     */
    public TableColumn<Enchere, String> getTdId() {
        return tdId;
    }

    /**
     * @param tdId the tdId to set
     */
    public void setTdId(TableColumn<Enchere, String> tdId) throws PropertyVetoException {
        javafx.scene.control.TableColumn<Smartech.Ench.entities.Enchere, java.lang.String> oldTdId = this.tdId;
        vetoableChangeSupport.fireVetoableChange(PROP_TDID, oldTdId, tdId);
        this.tdId = tdId;
        propertyChangeSupport.firePropertyChange(PROP_TDID, oldTdId, tdId);
    }

    /**
     * @return the tdDescription
     */
    public TableColumn<Enchere, String> getTdDescription() {
        return tdDescription;
    }

    /**
     * @param tdDescription the tdDescription to set
     */
    public void setTdDescription(TableColumn<Enchere, String> tdDescription) throws PropertyVetoException {
        javafx.scene.control.TableColumn<Smartech.Ench.entities.Enchere, java.lang.String> oldTdDescription = this.tdDescription;
        vetoableChangeSupport.fireVetoableChange(PROP_TDDESCRIPTION, oldTdDescription, tdDescription);
        this.tdDescription = tdDescription;
        propertyChangeSupport.firePropertyChange(PROP_TDDESCRIPTION, oldTdDescription, tdDescription);
    }

    /**
     * @return the tdDateDebut
     */
    public TableColumn<Enchere, String> getTdDateDebut() {
        return tdDateDebut;
    }

    /**
     * @param tdDateDebut the tdDateDebut to set
     */
    public void setTdDateDebut(TableColumn<Enchere, String> tdDateDebut) throws PropertyVetoException {
        javafx.scene.control.TableColumn<Smartech.Ench.entities.Enchere, java.lang.String> oldTdDateDebut = this.tdDateDebut;
        vetoableChangeSupport.fireVetoableChange(PROP_TDDATEDEBUT, oldTdDateDebut, tdDateDebut);
        this.tdDateDebut = tdDateDebut;
        propertyChangeSupport.firePropertyChange(PROP_TDDATEDEBUT, oldTdDateDebut, tdDateDebut);
    }

    /**
     * @return the tdDateFin
     */
    public TableColumn<Enchere, String> getTdDateFin() {
        return tdDateFin;
    }

    /**
     * @param tdDateFin the tdDateFin to set
     */
    public void setTdDateFin(TableColumn<Enchere, String> tdDateFin) throws PropertyVetoException {
        javafx.scene.control.TableColumn<Smartech.Ench.entities.Enchere, java.lang.String> oldTdDateFin = this.tdDateFin;
        vetoableChangeSupport.fireVetoableChange(PROP_TDDATEFIN, oldTdDateFin, tdDateFin);
        this.tdDateFin = tdDateFin;
        propertyChangeSupport.firePropertyChange(PROP_TDDATEFIN, oldTdDateFin, tdDateFin);
    }

    /**
     * @return the tdOffreInitial
     */
    public TableColumn<Enchere, String> getTdOffreInitial() {
        return tdOffreInitial;
    }

    /**
     * @param tdOffreInitial the tdOffreInitial to set
     */
    public void setTdOffreInitial(TableColumn<Enchere, String> tdOffreInitial) throws PropertyVetoException {
        javafx.scene.control.TableColumn<Smartech.Ench.entities.Enchere, java.lang.String> oldTdOffreInitial = this.tdOffreInitial;
        vetoableChangeSupport.fireVetoableChange(PROP_TDOFFREINITIAL, oldTdOffreInitial, tdOffreInitial);
        this.tdOffreInitial = tdOffreInitial;
        propertyChangeSupport.firePropertyChange(PROP_TDOFFREINITIAL, oldTdOffreInitial, tdOffreInitial);
    }

    /**
     * @return the Encherelist
     */
    public javafx.collections.ObservableList <Enchere> getEncherelist() {
        return Encherelist;
    }

    /**
     * @param Encherelist the Encherelist to set
     */
    public void setEncherelist(javafx.collections.ObservableList <Enchere> Encherelist) throws PropertyVetoException {
        javafx.collections.ObservableList<Smartech.Ench.entities.Enchere> oldEncherelist = this.Encherelist;
        vetoableChangeSupport.fireVetoableChange(PROP_ENCHERELIST, oldEncherelist, Encherelist);
        this.Encherelist = Encherelist;
        propertyChangeSupport.firePropertyChange(PROP_ENCHERELIST, oldEncherelist, Encherelist);
    }
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final transient VetoableChangeSupport vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
    public static final String PROP_BTNRETOUR = "BtnRetour";
    public static final String PROP_TABLE = "table";
    public static final String PROP_TDTITRE = "tdTitre";
    public static final String PROP_TDID = "tdId";
    public static final String PROP_TDDESCRIPTION = "tdDescription";
    public static final String PROP_TDDATEDEBUT = "tdDateDebut";
    public static final String PROP_TDDATEFIN = "tdDateFin";
    public static final String PROP_TDOFFREINITIAL = "tdOffreInitial";
    public static final String PROP_ENCHERELIST = "Encherelist";
    
}
