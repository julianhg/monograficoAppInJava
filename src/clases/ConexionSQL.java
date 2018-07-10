/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author elianahgx
 */
public class ConexionSQL {
    
    Connection con = null;
    //String DB = "pruebaDB"; 
    //String url = "jdbc:mysql://127.0.0.1:3306/"+DB+"?useSSL=false";
    //String user = "root";
    //String password = "amordoce12";
    //String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public void conectar(){
        
      
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/monograficoDB?useSSL=false","root", "amordoce12");
                if (con != null) {
                    System.out.println("Conexión a base de datos  OK\n");
                }
            } catch (SQLException ex) {
                   System.out.println("EXEPCION 1");
                    System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println("EXEPCION 2");
                System.out.println(ex.getMessage());
                System.out.println("EXEPCION 22");
            }
    }
    
    
    public void desconectar() {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
    
    
    
}
