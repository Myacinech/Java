/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.services;
import Smartech.Ench.entities.Proposition;
import Smartech.Ench.tools.MyBD;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yacin
 */
public class Proposition_CRUD {
    
    public void ajouterProposition(){
        String requete; 
        requete = "INSERT INTO proposition (nom_prestataire,Id_Entreprise, numero_telephone, Mail, Titre, Montant, Message) VALUES ('Voirie', 12,12354789, 'travaux@esprit.tn', 'voirie1', 250000,' je suivrai les regles et le cahier de charge' );";
        Statement st ;
        try {
            st = (Statement) new MyBD().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("¨Proposition ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterProposition2(Proposition p ){
        try {
        String req; 
        req = "INSERT INTO proposition (nom_prestataire,Id_Entreprise, numero_telephone, Mail, Titre, Montant, Message) VALUES (?, ?, ?, ?, ?, ?,?);";
        PreparedStatement pst;
        pst = new MyBD().getCnx().prepareStatement(req);
        pst.setString(1,p.getNom_prestataire());
        pst.setString(2,p.getId_Entreprise());
        pst.setString(3,p.getNumero_telephone());
        pst.setString(4,p.getMail());
        pst.setString(5, p.getTitre());
        pst.setDouble(6, p.getMontant());
        pst.setString(7,p.getMessage());
        pst.executeUpdate();
        System.out.println("votre Proposition a été ajoutée avec succès ");
                    } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<Proposition> afficherProposition(){
        List<Proposition> myList;
        myList = new ArrayList<>();
    try {
        String req3;
        req3 = " SELECT * FROM Proposition";
        Statement st = (Statement) new MyBD().getCnx().createStatement();
        ResultSet rs;
            rs = st.executeQuery (req3);
            while (rs.next());
                Proposition p; 
            p = new Proposition();
            p.setId_Entreprise(re.get);
        } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    return myList;
        
        
    }
    public void modifierProposition(){
        
    }
    public void supprimerProposition(){
        
    }
    public void rechercherProposition(){
        
    }
}