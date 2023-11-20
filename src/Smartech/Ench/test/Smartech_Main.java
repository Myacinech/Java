/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.test;

import Smartech.Ench.entities.Enchere;
import Smartech.Ench.entities.Proposition;
import Smartech.Ench.services.Enchere_CRUD;
import Smartech.Ench.services.Proposition_CRUD;
import Smartech.Ench.tools.MyBD;

/**
 *
 * @author yacin
 */
public class Smartech_Main {
    public static void main(String[] args) {
        MyBD mc  ;
        mc = new MyBD();
       /*Enchere_CRUD ECR= new  Enchere_CRUD();
       Enchere Enc;
       Enc = new Enchere();
       ECR.ajouterEnchere();
       ECR.ajouterEnchere2(Enc);*/
       Proposition_CRUD PCR = new Proposition_CRUD();
       Proposition PCRe;
       PCRe =new Proposition();
       PCR.ajouterProposition();
       //PCR.ajouterProposition2(PCRe);
       }
    
}