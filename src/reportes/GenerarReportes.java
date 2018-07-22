/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import clases.ConexionSQL_1;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
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
public class GenerarReportes {
    
    
    public void generarReporte(String nombreArchivo, String param) throws Exception {
        ConexionSQL_1 con = new ConexionSQL_1();
        Connection conn = con.getConexion();
        String ubicacionReporte="";
        try {
            
            
            ubicacionReporte = System.getProperty("user.dir") +"/src/reportes/" + nombreArchivo;
            
            Map parametro = new HashMap();
            parametro.put("carreraParam", param);
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacionReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, conn);
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
