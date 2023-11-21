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
    
    private String id;
    private String Titre;
    private String Description;
    private Date dateDebut;
    private Date dateFin;
    private double offre_initial;
    

    public Enchere( String id,String Titre, String Description, Date dateDebut, Date dateFin, double offre_initial) {
        
        
        this.id=id;
        this.Titre = Titre;
        this.Description = Description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.offre_initial = offre_initial;
    }

    public Enchere() {
    }
    
     public Enchere(String Titre, String Description, Date dateDebut, Date dateFin, double offre_initial) {
        this.Titre = Titre;
        this.Description = Description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.offre_initial = offre_initial;
    }

    public Enchere(int aInt, String string, String string0, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }
    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
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
        return "Enchere{ Titre=" + Titre + ", Description=" + Description + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", offre_initial=" + offre_initial + '}';
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    
}
