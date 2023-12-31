/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.entities;
/**
 *
 * @author yacin
 */
public class Proposition {
    private String Id ;
    private int id_prestataire;
    private String Id_Entreprise; 
    private String numero_telephone;
    private String mail;
    private String Titre;
    private double montant;
    private String message;

    public Proposition(String Id , int id_prestataire, String Id_Entreprise, String numero_telephone, String mail, String Titre, double montant, String message) {
         this.Id = Id;
        this.id_prestataire = id_prestataire;
        this.Id_Entreprise = Id_Entreprise;
        this.numero_telephone = numero_telephone;
        this.mail = mail;
        this.Titre = Titre;
        this.montant = montant;
        this.message = message;
    }
    public Proposition( int id_prestataire, String Id_Entreprise, String numero_telephone, String mail, String Titre, double montant, String message) {
        this.id_prestataire = id_prestataire;
        this.Id_Entreprise = Id_Entreprise;
        this.numero_telephone = numero_telephone;
        this.mail = mail;
        this.Titre = Titre;
        this.montant = montant;
        this.message = message;
    }

    public Proposition() {
    }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getId_Entreprise() {
        return Id_Entreprise;
    }

    public void setId_Entreprise(String Id_Entreprise) {
        this.Id_Entreprise = Id_Entreprise;
    }
    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Méthode pour accéder à l'attribut Titre de la classe Enchere
     private Enchere enchere;
     public String getTitreEnchere() {
        if (enchere != null) {
            return enchere.getTitre();
        } else {
            return "No associated Enchere";
        }
    }

    
    public void setTitre( String Titre) {
        this.Titre=Titre;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
      @Override
    public String toString() {
        return "Proposition{id_prestataire=" + id_prestataire + ", Id_Entreprise=" + Id_Entreprise + ", numero_telephone=" + numero_telephone + ", mail=" + mail + ", Titre=" + Titre + ", montant=" + montant + ", message=" + message + '}';
    }

    public void ajouterProposition() {
    }

    public void ajouterProposition2(Proposition PCR, Enchere e ) {
    }

    public int getid_prestataire() {
       return id_prestataire;
    }

    public void setid_prestataire(int id_prestataire) {

        this.id_prestataire= id_prestataire;    
    }
  
}
