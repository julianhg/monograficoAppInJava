/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author elianahgx
 */
public class LocalizaIdDoc extends ConexionSQL {
    public int auto_increment(String sql) {
        int id = 1;
        this.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = this.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("idmaximo" + ex.getMessage());
            id = 1;
        } finally {
            try {
                ps.close();
                rs.close();
                this.desconectar();
            } catch (Exception ex) {
            }
        }
        return id;
    }

    public static void main(String[] args) {
    }

}

   
