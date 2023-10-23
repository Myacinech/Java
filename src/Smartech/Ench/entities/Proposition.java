/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.entities;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yacin
 */
public class Proposition {
    private String nom_prestataire;
    private String numero_telephone;
    private String mail;
    private String Titre;
    private double montant;
    private String message;

    public Proposition(String nom_prestataire, String numero_telephone, String mail, String Titre, double montant, String message) {
        this.nom_prestataire = nom_prestataire;
        this.numero_telephone = numero_telephone;
        this.mail = mail;
        this.Titre = Titre;
        this.montant = montant;
        this.message = message;
    }

    public String getNom_prestataire() {
        return nom_prestataire;
    }

    public void setNom_prestataire(String nom_prestataire) {
        this.nom_prestataire = nom_prestataire;
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

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
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
        return "Proposition{" + "nom_prestataire=" + nom_prestataire + ", numero_telephone=" + numero_telephone + ", mail=" + mail + ", Titre=" + Titre + ", montant=" + montant + ", message=" + message + '}';
    }

    
    
}
