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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yacin
 */
public class Enchere_CRUD 
        
{

    public void ajouterEnchere() {
        String requete;
        requete = "INSERT INTO Enchere (Titre, Description, dateDebut, dateFin, offre_initial) VALUES ('Voirie3', 'travaux de chaussée d''un quartier résidentiel', '2023-02-10', '2023-03-10', 250000);";
        try {
            Statement st = (Statement) new MyBD().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Enchere ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterEnchere2(Enchere e) {
        try {
            String requete2;
            requete2 = "INSERT INTO Enchere (Titre, Description, dateDebut, dateFin, offre_initial) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = new MyBD().getCnx().prepareStatement(requete2);

            pst.setString(1, e.getTitre());
            pst.setString(2, e.getDescription());
            pst.setDate(3, (Date) e.getDateDebut());
            pst.setDate(4, (Date) e.getDateFin());
            pst.setDouble(5, e.getOffre_initial());
            pst.executeUpdate();
            System.out.println("Votre Enchere a été ajoutée avec succès ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Enchere> afficherEnchere() {
        List<Enchere> MyList = new ArrayList<>();
        try {
            String req3;
            req3 = "SELECT * FROM Enchere";
            Statement st = (Statement) new MyBD().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req3);

            while (rs.next()) {
                Enchere e = new Enchere();
                e.setTitre(rs.getString("Titre"));
                e.setDescription(rs.getString("Description"));
                e.setDateDebut(rs.getDate("dateDebut"));
                e.setDateFin(rs.getDate("dateFin"));
                e.setOffre_initial(rs.getDouble("offre_initial"));
                MyList.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }

 public static int modifierEnchere(Enchere e, Integer d) {
    try {
        MyBD mc = new MyBD();
        String sql = "UPDATE enchere SET `Titre`=?, `Description`=?, `dateDebut`=?, `dateFin`=?, `offre_initial`=? WHERE `id`=?";
        PreparedStatement pst = mc.getCnx().prepareStatement(sql);

        pst.setString(1, e.getTitre());
        pst.setString(2, e.getDescription());

        // Check if the date values are not null before setting them
        if (e.getDateDebut() != null) {
            pst.setDate(3, new java.sql.Date(e.getDateDebut().getTime()));
        } else {
            pst.setNull(3, java.sql.Types.DATE);
        }
        if (e.getDateFin() != null) {
            pst.setDate(4, new java.sql.Date(e.getDateFin().getTime()));
        } else {
            pst.setNull(4, java.sql.Types.DATE);
        }
        pst.setDouble(5, e.getOffre_initial());
        pst.setInt(6, d);

        return pst.executeUpdate();
    } catch (SQLException ex) {
        System.err.println("Erreur lors de la modification de l'enchère : " + ex.getMessage());
        return 0;
    }
}


    public void supprimerEnchere(String c) {
        try {
            String req5;
            req5 = "DELETE FROM `enchere` WHERE `enchere`.`Id` = ?";
            PreparedStatement ste = new MyBD().getCnx().prepareStatement(req5);
            ste.setString(1, c);
            ste.executeUpdate();
            System.out.println("L'enchère a été supprimée avec succès ");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Enchere> rechercherEnchere(String d) {
        List<Enchere> resultats = new ArrayList<>();
        List<Enchere> encheres = afficherEnchere();

        for (Enchere enchere : encheres) {
            if (enchere.getTitre().contains(d)) {
                resultats.add(enchere);
            }
        }
        return resultats;
    }
}


