/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smartech.Ench.tools;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yacin
 */
public class MyBD {

    private static MyBD instance;
    private Connection connection;

    
    public static synchronized MyBD getInstance() {
        if (instance == null) {
            instance = new MyBD();
        }
        return instance;
    }
    
    /*public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public String url="jdbc:mysql://localhost:3306/env";
    public String  login="root";
    public  String pwd="";
    Connection cnx ; 
    
    
    public MyBD(){
       
        
       
        try {
            cnx = DriverManager.getConnection(url,login,pwd);
        System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    public Connection getCnx(){
        return cnx ;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}