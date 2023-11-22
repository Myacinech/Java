package Smartech.Ench.test;

import Smartech.Ench.services.Enchere_CRUD;
import Smartech.Ench.services.Proposition_CRUD;
import Smartech.Ench.tools.MyBD;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import Smartech.Ench.entities.Enchere;
import Smartech.Ench.entities.Proposition;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yacin
 */

public class Smartech_Main {
    public static void main(String[] args) {
        MyBD mc = new MyBD();

       Enchere_CRUD enchereCRUD = new Enchere_CRUD();

        // Add an Enchere
        enchereCRUD.ajouterEnchere();

        // Display Encheres
        System.out.println("Affichage des Encheres:");
        for (Enchere enchere : enchereCRUD.afficherEnchere()) {
            System.out.println(enchere);
        }

        // Modify an Enchere (replace 'ID_TO_MODIFY' with the actual ID)
       /* Integer idToModify = 12;
        Enchere enchereToModify = new Enchere();
        enchereToModify.setid("7");  // Set the actual ID
        enchereToModify.setTitre("yacinee");
        enchereToModify.setDescription("this is us ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateDebut = sdf.parse("2023-02-20");
            Date dateFin = sdf.parse("2025-03-20");
            enchereToModify.setDateDebut(dateDebut);
            enchereToModify.setDateFin(dateFin);
        } catch (ParseException e) {
        }

        enchereToModify.setOffre_initial(300000);
        enchereCRUD.modifierEnchere(enchereToModify, idToModify);
        

        // Display Encheres after modification
        System.out.println("Affichage des Encheres après modification:");
        for (Enchere enchere : enchereCRUD.afficherEnchere()) {
            System.out.println(enchere);
        }
*/
        // Delete an Enchere (replace 'ID_TO_DELETE' with the actual ID)
        String idToDelete = "11";
        enchereCRUD.supprimerEnchere(idToDelete);

        // Display Encheres after deletion
        System.out.println("Affichage des Encheres après suppression:");
        for (Enchere enchere : enchereCRUD.afficherEnchere()) {
            System.out.println(enchere);
        }
        
        
        Proposition_CRUD propositionCRUD = new Proposition_CRUD();

        // Add a Proposition
        propositionCRUD.ajouterProposition();

        // Display Propositions
        System.out.println("Affichage des Propositions:");
        propositionCRUD.afficherProposition().forEach((proposition) -> {
            System.out.println(proposition);
        });
       /* System.out.println("Affichage des Proposition :");
        propositionCRUD.afficherProposition().forEach((proposition) -> {
            System.out.println(proposition);
        });*/

           // Uncomment the following line and set the actual ID value
           

          // Create a Proposition object with the modifications
          Integer idTModify = 64;
          Proposition propositionTModify = new Proposition();
          propositionTModify.setid_prestataire(5);
          propositionTModify.setId_Entreprise("7");
          propositionTModify.setNumero_telephone("123");
          propositionTModify.setMail("trav@esprit.tn");
          propositionTModify.setTitre("voirie3");
          propositionTModify.setMontant(300000);
          propositionTModify.setMessage("je suivrai");

          // Call the modifierProposition method
           propositionCRUD.modifierProposition(propositionTModify, idTModify);


        // Delete a Proposition (replace 'ID_TO_DELETE' with the actual ID)
        String idTDelete = "2";
        propositionCRUD.supprimerProposition(idTDelete);

        // Display Propositions after deletion
        System.out.println("Affichage des Propositions après suppression:");
        for (Proposition proposition : propositionCRUD.afficherProposition()) {
            System.out.println(proposition);
        }

        // Search for Propositions containing a certain value
        String searchValue = "5";
        try {
            List<Proposition> searchResults = propositionCRUD.rechercherProposition(searchValue);
            System.out.println("Résultats de la recherche pour '" + searchValue + "':");
            for (Proposition proposition : searchResults) {
                System.out.println(proposition);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la recherche de la proposition : " + ex.getMessage());
        }
        
        
    }
}
