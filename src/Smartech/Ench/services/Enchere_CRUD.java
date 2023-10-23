/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.services;

import Smartech.Ench.entities.Enchere;

/**
 *
 * @author yacin
 */
public class Enchere_CRUD {
    
    public void Ajouter_Enchere(String Titre,String Id, String description, String dateDebut, String dateFin, double offre_initial) {
        Enchere nouvelleEnchere = new Enchere(Titre,Id, description, dateDebut, dateFin, offre_initial);
        Enchere.add(nouvelleEnchere);
    }
   public void Ajouter_Enchere(){
       String requete ="INSERT INTO enchere (Titre,Id, description) VALUES ('dupont','25635485','offre de voirie divers' )"
               
       
   }
    public void Ajouter_Enchere2(){
        
    }
    public void List<Enchere> AfficheEnchere(){
        
    }
}
