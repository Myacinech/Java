/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.services;

import Smartech.Ench.entities.Enchere;
import Smartech.Ench.tools.MyBD;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author yacin
 */
public class Enchere_CRUD 
        
{
    
    public void ajouterEnchere(Enchere e ){
        String requete = "INSERT INTO Enchere (Titre, Id, Description, dateDebut, dateFin, prix_initial) VALUES  ('Voirie','12354789',' travaux de chaussee d'un quartier residentiel','10/02/2023','10/03/2023','250000')"; 
        Statement st= new MyBD().getCnx().createStatement()
    }
    
    public void ajouterEnchere(Enchere e ){
        
    }
    public List<Enchere> afficherEnchere(){
        
    }
    public void modifierEnchere(){
        
    }
    public void supprimerEnchere(){
        
    }
    public void rechercherEnchere(){
        
    }
}