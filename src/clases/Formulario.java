
package clases;

import java.sql.Date;





/**
 *
 * @author elianahgx
 */
public class Formulario {

    public String sede;
    public String pasantia;

    public Formulario() {
    }
    

    public Formulario( String sede, String pasantia) {

        this.sede = sede;
        this.pasantia = pasantia;
    }


    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPasantia() {
        return pasantia;
    }

    public void setPasantia(String pasantia) {
        this.pasantia = pasantia;
    }
    
    
    
    
    
}
