/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.services;
import Smartech.Ench.entities.Proposition;
import Smartech.Ench.entities.Enchere;
import Smartech.Ench.tools.MyBD;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yacin
 */

public class Proposition_CRUD {


    public void ajouterProposition() {
        String requete;
        requete = "INSERT INTO proposition (id_prestataire, Id_Entreprise, numero_telephone, Mail, Titre, Montant, Message) VALUES (5, 12, 12354789, 'travaux@esprit.tn', 'voirie1', 250000, 'je suivrai les règles et le cahier de charge');";
        try (PreparedStatement pst = MyBD.getInstance().getCnx().prepareStatement(requete)) {
            pst.executeUpdate();
            System.out.println("Proposition ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'ajout de la proposition : " + ex.getMessage());
        }
    }

    public void ajouterProposition2(Proposition p, Enchere e) {
        
        
        
        try {
        
            String req = "INSERT INTO proposition (id_prestataire, Id_Entreprise, numero_telephone, Mail, Titre, Montant, Message) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = MyBD.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, p.getid_prestataire());
            pst.setString(2, p.getId_Entreprise());
            pst.setString(3, p.getNumero_telephone());
            pst.setString(4, p.getMail());
            pst.setString(5, p.getTitreEnchere(e));
            pst.setDouble(6, p.getMontant());
            pst.setString(7, p.getMessage());
            pst.executeUpdate();
            System.out.println("Votre proposition a été ajoutée avec succès ");
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'ajout de la proposition : " + ex.getMessage());
        }
    }

    public List<Proposition> afficherProposition() {
        List<Proposition> myList = new ArrayList<>();
        try {
            String req = "SELECT * FROM Proposition";
            try (Statement st = (Statement) MyBD.getInstance().getCnx().createStatement();
                 ResultSet rs = st.executeQuery(req)) {

                while (rs.next()) {
                    Proposition p = new Proposition();
                    p.setid_prestataire(rs.getInt("id_prestataire"));
                    p.setId_Entreprise(rs.getString("Id_Entreprise"));
                    p.setNumero_telephone(rs.getString("numero_telephone"));
                    p.setMail(rs.getString("Mail"));
                    p.setMontant(rs.getDouble("Montant"));
                    p.setMessage(rs.getString("Message"));
                    myList.add(p);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'affichage des propositions : " + ex.getMessage());
        }
        return myList;
    }

   public void modifierProposition(Proposition p, Integer idprestataire) {
    try {
        Enchere e = null; 
        String sql = "UPDATE proposition SET id_prestataire=?, Numero_telephone=?, Mail=?, Titre=?, Montant=?, Message=? WHERE Id_Prestataire=?";
        
        try (PreparedStatement pst = MyBD.getInstance().getCnx().prepareStatement(sql)) {
            pst.setInt(1, p.getid_prestataire());
            pst.setString(2, p.getId_Entreprise());
            pst.setString(3, p.getNumero_telephone());
            pst.setString(4, p.getMail());
            pst.setString(5, p.getTitreEnchere(e));
            pst.setDouble(6, p.getMontant());
            pst.setString(7, p.getMessage());
            pst.setInt(8, idprestataire);
            
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("La proposition a été modifiée avec succès");
            } else {
                System.out.println("Aucune modification n'a été effectuée. Vérifiez l'ID de la proposition.");
            }
        }
    } catch (SQLException ex) {
        System.err.println("Erreur lors de la modification de la proposition : " + ex.getMessage());
    }
}


    public void supprimerProposition(String IDprestataire) {
        try {
            String req = "DELETE FROM proposition WHERE id_prestataire=?";
            try (PreparedStatement ste = MyBD.getInstance().getCnx().prepareStatement(req)) {
                ste.setString(1, IDprestataire);
                ste.executeUpdate();
                System.out.println("La proposition a été supprimée avec succès ");
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la suppression de la proposition : " + ex.getMessage());
        }
    }

    public static List<Proposition> getAllPropositions() throws SQLException {
        List<Proposition> propositions = new ArrayList<>();
        String req = "SELECT * FROM Proposition";
        try (Statement stm = (Statement) MyBD.getInstance().getCnx().createStatement();
             ResultSet rst = stm.executeQuery(req)) {

            while (rst.next()) {
                Proposition proposition = new Proposition(
                        rst.getInt("id_prestataire"),
                        rst.getString("Id_Entreprise"),
                        rst.getString("numero_telephone"),
                        rst.getString("Mail"),
                        rst.getString("Titre"),
                        rst.getDouble("Montant"),
                        rst.getString("Message")
                );

                propositions.add(proposition);
            }
        }
        return propositions;
    }

    public List<Proposition> rechercherProposition(String d) throws SQLException {
        List<Proposition> resultats = new ArrayList<>();
        List<Proposition> propositions;
        propositions = getAllPropositions();

        for (Proposition proposition : propositions) {
            if (proposition.getId_Entreprise().contains(d)) {
                resultats.add(proposition);
            }
        }
        return resultats;
    }

    
} 
