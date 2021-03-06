
package reportes;

import clases.ConexionSQL_1;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author elianahgx
 */
public class GenerarReportes1Copia {
    
    
    public void generarReporte(String nombreArchivo) throws Exception {
        ConexionSQL_1 con = new ConexionSQL_1();
        Connection conn = con.getConexion();
        String ubicacionReporte = "";
        try {
            
            
            ubicacionReporte = System.getProperty("user.dir") +"/src/reportes/" + nombreArchivo;
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacionReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
        } catch (JRException e) {
            throw e;
        }

    }
    
    
    
    /*
     ConexionSQL_1 con = new ConexionSQL_1();
        Connection conn = con.getConexion();
        InputStream archivoRep = getClass().getResourceAsStream("reportex.jrxml");
        try {
            
            JasperDesign jd = JRXmlLoader.load(archivoRep);
            String sql = "select * from estudiantes";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
            //JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        } ConexionSQL_1 con = new ConexionSQL_1();
        Connection conn = con.getConexion();
        InputStream archivoRep = getClass().getResourceAsStream("reportex.jrxml");
        try {
            
            JasperDesign jd = JRXmlLoader.load(archivoRep);
            String sql = "select * from estudiantes";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
            //JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    */
    
    
    
    
}
