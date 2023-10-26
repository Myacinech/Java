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
        Statement st = null; 
                st = (Statement) new MyBD().getCnx().createStatement();
        ResultSet rs=null;
            rs = st.executeQuery (req3);
    while (rs.next());
            Proposition p; 
            p = new Proposition();
            p.setNom_prestataire(rs.getString("Nom_prestataire"));
            p.setId_Entreprise(rs.getString("Id_Entreprise"));
            p.setNumero_telephone(rs.getString("numero_telephone"));
            p.setMail(rs.getString("Mail"));
            p.setTitre(rs.getString("Titre"));
            p.setMontant(rs.getDouble("Montant"));
            p.setMessage(rs.getString("Message"));
            myList.add(p);     
        } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    return myList;
        
        
    }
    public void modifierProposition(Proposition p, String d){
        
        
        try {
            String sql = "UPDATE proposition SET `Nom_prestataire`=?,`Numero_telephone`=?,`Mail`=?,`Titre`=? ,`Montant`=?,`Message`=? WHERE Id_Entreprise=" + d;
            PreparedStatement pst = new MyBD().getCnx().prepareStatement(sql);
           
        pst.setString(1,p.getNom_prestataire());
        pst.setString(2,p.getId_Entreprise());
        pst.setString(3,p.getNumero_telephone());
        pst.setString(4,p.getMail());
        pst.setString(5, p.getTitre());
        pst.setDouble(6, p.getMontant());
        pst.setString(7,p.getMessage());
        pst.executeUpdate();
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public void supprimerProposition(String d){
        
        try {
            
            String req5;
            req5 = "DELETE FROM `proposition` WHERE `proposition`.`Id_Entreprise` = ?" ;
            PreparedStatement ste = new MyBD().getCnx().prepareStatement(req5);
            ste.setString(1,d);
            ste.executeUpdate();
            System.out.println("La proposition a été supprimée avec succés ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
        public List<Proposition> rechercherProposition( String d){
        List<Proposition> resultats = new ArrayList<>();
        Iterable<Proposition> propositions = null;
        
        for (Proposition proposition : propositions)
        {
            if (proposition.getId_Entreprise().contains(d))
            {
                resultats.add(proposition); 
            }
        }
           return resultats;     
    }
        
    public void ajouterEnchere(){
        String requete; 
        requete = "INSERT INTO Enchere (Titre, Id, Description, dateDebut, dateFin, offre_initial) VALUES ('Voirie3', 123547892111, 'travaux de chaussée d''un quartier résidentiel', '2023-02-10', '2023-03-10', 250000);";
        Statement st ;
        try {
            st = (Statement) new MyBD().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Proposition ajoute avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterProposition2(Proposition_CRUD PCR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
 }