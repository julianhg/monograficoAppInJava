
package clases;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;



/**
 *
 * @author elianahgx
 */
public class DAOmono extends ConexionSQL {

    public DAOmono() {
    }

        
        Date d = new java.util.Date();

  
    
    public void agregarDoc(ArchivosDoc doc){
        this.conectar();
        PreparedStatement ps = null;
        
        
        try {
            String sql = "insert into documento (foto, recNotas, kardex, cedula, reciboPago) values(?, ?, ?, ?, ?); ";
            ps = this.con.prepareStatement(sql);
        
            ps.setBytes(1, doc.getFoto());
            ps.setBytes(2, doc.getRecNotas());
            ps.setBytes(3, doc.getKardex());
            ps.setBytes(4, doc.getCedula());
            ps.setBytes(5, doc.getRecibo());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                this.desconectar();
            } catch (Exception ex) {
                
            }
        }
    }
    
    public void modificarDoc(){
        
    }
    
    public void eliminarDoc(){
        
    }
    
    public void listarDoc(){
        
    }
    
    public void agregarFormulario(Estudiante estu){
        this.conectar();
        PreparedStatement ps = null;
        String sql = "insert into estudiantes (fecha, matricula, nombre, apellido, cedula, FKcarrera, telefono, FKnacionalidad, pasantia, FKsede, email, FKdocumentos) values(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        //String sql = "insert into estudiante (idestudiante) values(?);";
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        //System.out.println("utilDate:" + utilDate);
        

        try {
            ps = this.con.prepareStatement(sql);
            
           
            ps.setDate(1, sqlDate); 
            ps.setString(2, estu.getMatricula());
            ps.setString(3, estu.getNombre());
            ps.setString(4, estu.getApellido());
            ps.setString(5, estu.getCedula());
            ps.setString(6, estu.getCarrera()); 
            ps.setString(7, estu.getTelefono());
            ps.setString(8, estu.getNacionalidad()); 
            ps.setString(9, estu.getPasantia());
            ps.setString(10, estu.getSede()); 
            ps.setString(11, estu.getCorreo());
            ps.setInt(12,estu.getIdDocumento() );
       
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                this.desconectar();
            } catch (Exception ex) {
                
            }
        }
    }
    
}
