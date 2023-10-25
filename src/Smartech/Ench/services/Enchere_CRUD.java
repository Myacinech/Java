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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yacin
 */
public class Enchere_CRUD 
        
{
    
    public void ajouterEnchere(){
        String requete; 
        requete = "INSERT INTO Enchere (Titre, Id, Description, dateDebut, dateFin, offre_initial) VALUES ('Voirie3', 123547892111, 'travaux de chaussée d''un quartier résidentiel', '2023-02-10', '2023-03-10', 250000);";
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
    public void modifierEnchere(Enchere e, String d ){
        
        try {
            String sql = "UPDATE enchere SET `Titre`=?,`Description`=?,`dateDebut`=?,`dateFin`=? ,`offre_initial`=? WHERE Id=" + d;
            PreparedStatement ste = new MyBD().getCnx().prepareStatement(sql);
           
            ste.setString(1,e.getTitre());
            ste.setString(2,e.getDescription());
            ste.setDate(3, (Date) e.getDateDebut());
            ste.setDate(4, (Date) e.getDateFin());
            ste.setDouble(5,e.getOffre_initial());
            ste.executeUpdate();
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public void supprimerEnchere(String c){
        
          try {
            
            String req5;
            req5 = "DELETE FROM `enchere` WHERE `enchere`.`Id` = ?" ;
            PreparedStatement ste = new MyBD().getCnx().prepareStatement(req5);
            ste.setString(1,c);
            ste.executeUpdate();
            System.out.println("L'enchère a été supprimée avec succés ");
        
        
        
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

      }  
   
    public List<Enchere> rechercherEnchere( String d){
        List<Enchere> resultats = new ArrayList<>();
        Iterable<Enchere> encheres = null;
        
        for (Enchere enchere : encheres)
        {
            if (enchere.getId().contains(d))
            {
                resultats.add(enchere);
                
            }
        }
           return resultats;
           

        
    }
}
