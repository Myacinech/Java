/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.services;

import Smartech.Ench.entities.Enchere;
import Smartech.Ench.tools.MyBD;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yacin
 */
public class Enchere_CRUD 
        
{
    
    public void ajouterEnchere(){
        String requete; 
        requete = "INSERT INTO Enchere (Titre, Id, Description, dateDebut, dateFin, offre_initial) VALUES ('Voirie', 12354789, 'travaux de chaussée d''un quartier résidentiel', '2023-02-10', '2023-03-10', 250000);";
        Statement st ;
        try {
            st = (Statement) new MyBD().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Enchere ajoute avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterEnchere2(Enchere e ){
        try {
        String requete2; 
        requete2 = "INSERT INTO Enchere (Titre, Id, Description, dateDebut, dateFin, offre_initial) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement pst;
        pst = new MyBD().getCnx().prepareStatement(requete2);
        pst.setString(1,e.getTitre());
        pst.setString(2,e.getId());
        pst.setString(3,e.getDescription());
        pst.setDate(4, (Date) e.getDateDebut());
        pst.setDate(5, (Date) e.getDateFin());
        pst.setDouble(6,e.getOffre_initial());
        pst.executeUpdate();
        System.out.println("votre Enchere a été ajoute avec succès ");
                    } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<Enchere> afficherEnchere(){
        return null;
        
    }
    public void modifierEnchere(){
        
    }
    public void supprimerEnchere(){
        
    }
    public void rechercherEnchere(){
        
    }
}