/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.entities;

import java.util.Date;

/**
 *
 * @author yacin
 */
public class Enchere{
    private String Titre;
    private String Id; 
    private String Description;
    private Date dateDebut;
    private Date dateFin;
    private double offre_initial;
    

    public Enchere(String Titre, String Id, String Description, Date dateDebut, Date dateFin, double offre_initial) {
        this.Titre = Titre;
        this.Id = Id;
        this.Description = Description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.offre_initial = offre_initial;
    }

    public Enchere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Enchere(int aInt, String string, String string0, String string1, int aInt0, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getOffre_initial() {
        return offre_initial;
    }

    public void setOffre_initial(double offre_initial) {
        this.offre_initial = offre_initial;
    }

    @Override
    public String toString() {
        return "Enchere{" + "Titre=" + Titre + ", Id=" + Id + ", Description=" + Description + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", offre_initial=" + offre_initial + '}';
    }
      
    
}
