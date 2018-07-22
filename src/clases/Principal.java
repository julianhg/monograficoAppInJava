/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import reportes.GenerarReportes;

/**
 *
 * @author elianahgx
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     * 
     */
    
    Estudiante estudiante = null;
    ArchivosDoc documentos = null;
    ButtonGroup grupoRadio1, grupoRadio2;
    
    
    public Principal() {
        initComponents();
        grupoRadio1 = new ButtonGroup();
        grupoRadio2 = new ButtonGroup();
        
        grupoRadio1.add(radioBtnPasantiaSI);
        grupoRadio1.add(radioBtnPasantiaNO);
        
        grupoRadio2.add(radioBtnPasantiaSIConfirm);
        grupoRadio2.add(radioBtnPasantiaNOConfirm);
        
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        
        //configuracion inicial para componentes
        textFieldFoto.setEnabled(false);
        textFieldKardex.setEnabled(false);
        textFieldNotas.setEnabled(false);
        textFieldCedula.setEnabled(false);
        textFieldRecibo.setEnabled(false);
        
        //instancia estudiante para el formulario
        estudiante = new Estudiante();
        documentos = new ArchivosDoc();
//       
        
      
    }
    //CONCATENAR DIRECCION, SECTOR Y PROVINCIA
    public String concatDireccion(){
        return ""+tFieldDireccion.getText()+", "+tFieldSector.getText()+", "+tFieldProvincia.getSelectedItem().toString()+"";
    }
    
    
    //PARA SELECCIONAR ARCHIVOS DEL COMPUTADOR

    String ruta_nombreArchivo = "";
    File[] ruta_archivo = new File[5];
    String ruta = "";
    
    public void seleccionarArchivo(JTextField tf, int i) {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fichero = new FileNameExtensionFilter("PDF o Imagen", "pdf", "jpge", "jpg", "png");
        j.setFileFilter(fichero);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            //ruta_archivo[i] = null;
            //this.btnAgregarFoto.setText("" + j.getSelectedFile().getName());
            ruta = j.getSelectedFile().getAbsolutePath();
            ruta_archivo[i] = new File(ruta);
            ruta = "";
            ruta_nombreArchivo = j.getSelectedFile().getName();

        } else {
        }
        
        tf.setText(ruta_nombreArchivo);
    }
    
    //GUARDAR PDF EN CLASES ARCHIVOSDOC
    
    public void guardar_documentos(File[] ruta) {
        DAOmono DAOm = new DAOmono();
        
        try {
            byte[] fotoDoc = new byte[(int) ruta[0].length()];
            InputStream input0 = new FileInputStream(ruta[0]);
            input0.read(fotoDoc);
            documentos.setFoto(fotoDoc);
        } catch (IOException ex) {
            documentos.setFoto(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        
        
        try {
            byte[] kardexDoc = new byte[(int) ruta[1].length()];
            InputStream input1 = new FileInputStream(ruta[1]);
            input1.read(kardexDoc);
            documentos.setKardex(kardexDoc);
        } catch (IOException ex) {
            documentos.setKardex(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        
        try {
            byte[] notasDoc = new byte[(int) ruta[2].length()];
            InputStream input2 = new FileInputStream(ruta[2]);
            input2.read(notasDoc);
            documentos.setRecNotas(notasDoc);
        } catch (IOException ex) {
            documentos.setRecNotas(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        
        try {
            byte[] cedulaDoc = new byte[(int) ruta[3].length()];
            InputStream input3 = new FileInputStream(ruta[3]);
            input3.read(cedulaDoc);
            documentos.setCedula(cedulaDoc);
        } catch (IOException ex) {
            documentos.setCedula(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        
        try {
            byte[] reciboDoc = new byte[(int) ruta[4].length()];
            InputStream input4 = new FileInputStream(ruta[4]);
            input4.read(reciboDoc);
            documentos.setRecibo(reciboDoc);
        } catch (IOException ex) {
            documentos.setRecibo(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        
        DAOm.agregarDoc(documentos);
    }
    
    
    public void abrirFichero(String ruta){
    Desktop ficheroAEjecutar=Desktop.getDesktop();
    try {
         ficheroAEjecutar.open(new File(ruta));
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, 
                                       e.getMessage(), 
                                       "Error", 
                                       JOptionPane.ERROR_MESSAGE);
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        panelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelInscripcion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        panelConsulta = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxListaCarr = new javax.swing.JComboBox<>();
        btnVerListado = new javax.swing.JButton();
        panelAyuda = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelRegistro = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        panelProcesoArchivos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        btnAgregarFoto = new javax.swing.JButton();
        btnAgregarKardex = new javax.swing.JButton();
        btnAgregarNotas = new javax.swing.JButton();
        btnAgregarCedula = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnAgregarRecibo = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        textFieldKardex = new javax.swing.JTextField();
        textFieldFoto = new javax.swing.JTextField();
        textFieldRecibo = new javax.swing.JTextField();
        textFieldNotas = new javax.swing.JTextField();
        textFieldCedula = new javax.swing.JTextField();
        panelProcesoForm = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tFieldMatricula = new javax.swing.JTextField();
        tFieldDireccion = new javax.swing.JTextField();
        tFieldApellido = new javax.swing.JTextField();
        tFieldnombre = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        tFieldSector = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        radioBtnPasantiaSI = new javax.swing.JRadioButton();
        radioBtnPasantiaNO = new javax.swing.JRadioButton();
        tFieldNacionalidad = new javax.swing.JTextField();
        tFieldCorreo = new javax.swing.JTextField();
        btnSiguienteForm = new javax.swing.JButton();
        comboBoxCarrera = new javax.swing.JComboBox<>();
        comboBoxSede = new javax.swing.JComboBox<>();
        tFieldTelefono = new javax.swing.JFormattedTextField();
        tFieldCedula = new javax.swing.JFormattedTextField();
        tFieldProvincia = new javax.swing.JComboBox<>();
        panelConfirmacion = new javax.swing.JPanel();
        btnConfirmarReg = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        labelProvincia = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        editarTelefono = new javax.swing.JLabel();
        labelCedula = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelNacionalidad = new javax.swing.JLabel();
        labelRecinto = new javax.swing.JLabel();
        labelMatricula = new javax.swing.JLabel();
        labelPasantia = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelCarrera = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfMatricula = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfNacionalidad = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        tfCedula = new javax.swing.JTextField();
        tfCorreo = new javax.swing.JTextField();
        tfProvincia = new javax.swing.JTextField();
        tfSector = new javax.swing.JTextField();
        labelNombre1 = new javax.swing.JLabel();
        editarCorreo = new javax.swing.JLabel();
        editarMatricula = new javax.swing.JLabel();
        editarDireccion = new javax.swing.JLabel();
        editarSector = new javax.swing.JLabel();
        editarProvincia = new javax.swing.JLabel();
        editarNacionalidad = new javax.swing.JLabel();
        editarRecinto = new javax.swing.JLabel();
        editarNombre = new javax.swing.JLabel();
        editarApellido = new javax.swing.JLabel();
        editarCedula = new javax.swing.JLabel();
        editarCarrera = new javax.swing.JLabel();
        editarPasantia = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelSector = new javax.swing.JLabel();
        comboBoxCarreraConfirm = new javax.swing.JComboBox<>();
        comboBoxSedeConfirm = new javax.swing.JComboBox<>();
        radioBtnPasantiaSIConfirm = new javax.swing.JRadioButton();
        radioBtnPasantiaNOConfirm = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        panelCompletado = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1152, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(74, 119, 186));

        jButton1.setText("LISTA DE ESTUDIANTES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("INICIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("INSCRIPCION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("AYUDA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo uasd.png"))); // NOI18N

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(45, 45, 45))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 720));

        panelMain.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("MONOGRAFICO");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(592, Short.MAX_VALUE))
        );

        panelMain.add(panelInicio, "card2");

        panelInscripcion.setPreferredSize(new java.awt.Dimension(932, 720));
        panelInscripcion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("INSCRIPCION");
        jLabel2.setToolTipText("");
        panelInscripcion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jButton5.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 24)); // NOI18N
        jButton5.setText("REGISTRARSE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelInscripcion.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 220, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Webp.net-resizeimage (3).png"))); // NOI18N
        panelInscripcion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 250, 200));

        panelMain.add(panelInscripcion, "card3");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("LISTADO DE ESTUDIANTES");
        jLabel3.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel6.setText("SELECCIONE CARRERA");

        comboBoxListaCarr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administración", "Agrimensura", "Agronomía", "Arquitectura", "Artes Plásticas", "Bibliotecología", "Bioanálisis", "Biología", "Ciencias Fisilógicas", "Ciencias Geográficas", "Ciencias Morfológicas", "Cine TV-Fotografía", "Comunicación Social", "Contabilidad", "Crítica e Historia del Arte", "Diseño Industrial y Moda", "Economía", "Educación Infantil y Básicas", "Educación Media", "Enfermería", "Escuela de Idiomas", "Estadística", "Farmacia", "Filosofía", "Física", "Física Y Deporte", "Historia y Antropología", "Idioma", "Informática", "Ingeniería Civil", "Ingeniería Electromecánica", "Ingeniería Industrial", "Ingeniería Química", "Letras", "Matemática", "Medicina", "Mercadotecnia", "Micro biología y Parasitología", "Música", "Odontología", "Orientación Profesional", "Orientación y Pedagogía", "Pedagogía", "Psicología", "Publicidad", "Química", "Salud Pública", "Sociología", "Teatro", "Teoría y Gestión Educativa", "Veterinaria", "Zootecnia" }));
        comboBoxListaCarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxListaCarrActionPerformed(evt);
            }
        });

        btnVerListado.setText("VER LISTADO");
        btnVerListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerListadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultaLayout.createSequentialGroup()
                                .addComponent(comboBoxListaCarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerListado))
                            .addComponent(jLabel6))))
                .addContainerGap(478, Short.MAX_VALUE))
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel3)
                .addGap(89, 89, 89)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxListaCarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerListado))
                .addContainerGap(442, Short.MAX_VALUE))
        );

        panelMain.add(panelConsulta, "card4");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setText("AYUDAS");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout panelAyudaLayout = new javax.swing.GroupLayout(panelAyuda);
        panelAyuda.setLayout(panelAyudaLayout);
        panelAyudaLayout.setHorizontalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAyudaLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel4)
                .addContainerGap(602, Short.MAX_VALUE))
        );
        panelAyudaLayout.setVerticalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAyudaLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel4)
                .addContainerGap(592, Short.MAX_VALUE))
        );

        panelMain.add(panelAyuda, "card5");

        panelRegistro.setPreferredSize(new java.awt.Dimension(932, 720));
        panelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Andale Mono", 1, 18)); // NOI18N
        jLabel7.setText("<html><p>* Foto 2x2<p>* Record de notas <p>* Kardex academico <p>* Cedula <p>* Recibo de pago<html>");
        panelRegistro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        jLabel9.setText("NOTA");
        panelRegistro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        panelRegistro.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 400, -1));

        jLabel10.setFont(new java.awt.Font("AppleGothic", 0, 24)); // NOI18N
        jLabel10.setText("Documentos requeridos");
        panelRegistro.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton6.setText("Empezar registro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelRegistro.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 200, 50));

        panelMain.add(panelRegistro, "card6");

        panelProcesoArchivos.setPreferredSize(new java.awt.Dimension(932, 720));
        panelProcesoArchivos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setText("Recibo de pago (copia)");
        panelProcesoArchivos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText("Seleccionar Documentos");
        panelProcesoArchivos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setText("Documentos");
        panelProcesoArchivos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel14.setText("Foto 2x2");
        panelProcesoArchivos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel15.setText("Kardex academico");
        panelProcesoArchivos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel16.setText("Record de notas");
        panelProcesoArchivos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel17.setText("Cédula (escaneada)");
        panelProcesoArchivos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jButton7.setText("Siguiente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, -1, -1));

        btnAgregarFoto.setText("Añadir archivo");
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(btnAgregarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 169, -1, 30));

        btnAgregarKardex.setText("Añadir archivo");
        btnAgregarKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarKardexActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(btnAgregarKardex, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 219, -1, 30));

        btnAgregarNotas.setText("Añadir archivo");
        btnAgregarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNotasActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(btnAgregarNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 269, -1, 30));

        btnAgregarCedula.setText("Añadir archivo");
        btnAgregarCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCedulaActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(btnAgregarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 319, -1, 30));
        panelProcesoArchivos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 530, -1));
        panelProcesoArchivos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 530, -1));
        panelProcesoArchivos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 530, -1));
        panelProcesoArchivos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 530, -1));
        panelProcesoArchivos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 530, -1));

        btnAgregarRecibo.setText("Añadir archivo");
        btnAgregarRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarReciboActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(btnAgregarRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 369, -1, 30));

        jButton13.setText("Atras");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, -1));
        panelProcesoArchivos.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 520, -1));

        textFieldKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldKardexActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(textFieldKardex, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 140, -1));

        textFieldFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFotoActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(textFieldFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 140, -1));

        textFieldRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldReciboActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(textFieldRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 140, -1));

        textFieldNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNotasActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(textFieldNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 140, -1));

        textFieldCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCedulaActionPerformed(evt);
            }
        });
        panelProcesoArchivos.add(textFieldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 140, -1));

        panelMain.add(panelProcesoArchivos, "card7");

        panelProcesoForm.setPreferredSize(new java.awt.Dimension(932, 720));
        panelProcesoForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setText("Correo electronico");
        panelProcesoForm.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel19.setText("FORMULARIO DE INSCRIPCION");
        panelProcesoForm.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel20.setText("Nombres");
        panelProcesoForm.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel21.setText("Apellidos");
        panelProcesoForm.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel23.setText("Matrícula");
        panelProcesoForm.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel24.setText("Dirección");
        panelProcesoForm.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jButton14.setText("Limpiar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        panelProcesoForm.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        jButton20.setText("Atras");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        panelProcesoForm.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, -1));

        jLabel25.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel25.setText("Carrera");
        panelProcesoForm.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 60, 20));

        jLabel26.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel26.setText("Telefono");
        panelProcesoForm.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel27.setText("Nacionalidad");
        panelProcesoForm.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel28.setText("Completo pasantia?");
        panelProcesoForm.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel29.setText("Sede o resinto que estudió");
        panelProcesoForm.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 20));

        jLabel30.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel30.setText("Cédula");
        panelProcesoForm.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        panelProcesoForm.add(tFieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 146, -1));
        panelProcesoForm.add(tFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, 250, -1));
        panelProcesoForm.add(tFieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 210, -1));

        tFieldnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tFieldnombreFocusGained(evt);
            }
        });
        panelProcesoForm.add(tFieldnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 220, -1));

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel31.setText("sector");
        panelProcesoForm.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));
        panelProcesoForm.add(tFieldSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 223, 166, -1));

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel32.setText("Provincia");
        panelProcesoForm.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        radioBtnPasantiaSI.setText("SI");
        radioBtnPasantiaSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPasantiaSIActionPerformed(evt);
            }
        });
        panelProcesoForm.add(radioBtnPasantiaSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 377, -1, -1));

        radioBtnPasantiaNO.setText("NO");
        radioBtnPasantiaNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPasantiaNOActionPerformed(evt);
            }
        });
        panelProcesoForm.add(radioBtnPasantiaNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 377, -1, -1));
        panelProcesoForm.add(tFieldNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 300, 140, -1));
        panelProcesoForm.add(tFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 200, -1));

        btnSiguienteForm.setText("Siguiente");
        btnSiguienteForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteFormActionPerformed(evt);
            }
        });
        panelProcesoForm.add(btnSiguienteForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, -1, -1));

        comboBoxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administración", "Agrimensura", "Agronomía", "Arquitectura", "Artes Plásticas", "Bibliotecología", "Bioanálisis", "Biología", "Ciencias Fisilógicas", "Ciencias Geográficas", "Ciencias Morfológicas", "Cine TV-Fotografía", "Comunicación Social", "Contabilidad", "Crítica e Historia del Arte", "Diseño Industrial y Moda", "Economía", "Educación Infantil y Básicas", "Educación Media", "Enfermería", "Escuela de Idiomas", "Estadística", "Farmacia", "Filosofía", "Física", "Física Y Deporte", "Historia y Antropología", "Idioma", "Informática", "Ingeniería Civil", "Ingeniería Electromecánica", "Ingeniería Industrial", "Ingeniería Química", "Letras", "Matemática", "Medicina", "Mercadotecnia", "Micro biología y Parasitología", "Música", "Odontología", "Orientación Profesional", "Orientación y Pedagogía", "Pedagogía", "Psicología", "Publicidad", "Química", "Salud Pública", "Sociología", "Teatro", "Teoría y Gestión Educativa", "Veterinaria", "Zootecnia" }));
        comboBoxCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCarreraActionPerformed(evt);
            }
        });
        panelProcesoForm.add(comboBoxCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        comboBoxSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baní", "Barahona", "Bonao", "Duvergé", "Hato Mayor", "Higuey", "La Romana", "La Vega", "Nagua", "Neiba", "Puerto Plata", "Samaná", "San Cristóbal", "San Francisco de Macorís", "San Juan de la Maguana", "San Pedro de Macorís", "Santiago", "Santiago Rodríguez", "Santo Domingo", "Valverde-Mao" }));
        panelProcesoForm.add(comboBoxSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, -1));

        try {
            tFieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panelProcesoForm.add(tFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 140, -1));

        try {
            tFieldCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panelProcesoForm.add(tFieldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, -1));

        tFieldProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azua", "Bahoruco", "Barahona", "Dajabón", "Distrito Nacional", "Duarte", "El Seibo", "Elías Piña", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "María Trinidad Sánchez", "Monseñor Nouel", "Monte Plata", "Montecristi", "Pedernales", "Peravia", "Puerto Plata", "Samaná", "San Cristóbal", "San José de Ocoa", "San Juan", "San Pedro de Maco", "Santiago", "Santiago Rodríguez", "Santo Domingo", "Sánchez Ramírez", "Valverde" }));
        panelProcesoForm.add(tFieldProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        panelMain.add(panelProcesoForm, "card7");

        panelConfirmacion.setPreferredSize(new java.awt.Dimension(932, 720));
        panelConfirmacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirmarReg.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnConfirmarReg.setText("Confirmar registro");
        btnConfirmarReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarRegActionPerformed(evt);
            }
        });
        panelConfirmacion.add(btnConfirmarReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 649, -1, 40));

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel22.setText("Revisar y confirmar");
        panelConfirmacion.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        labelProvincia.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelProvincia.setText("provincia");
        panelConfirmacion.add(labelProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 80, -1));

        jLabel34.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel34.setText("INFORMACION DEL ESTUDIANTE");
        panelConfirmacion.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 280, -1));

        editarTelefono.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarTelefono.setForeground(java.awt.Color.blue);
        editarTelefono.setText("Editar");
        editarTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarTelefono.setOpaque(true);
        editarTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarTelefonoMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 60, 20));

        labelCedula.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelCedula.setText("cedula");
        panelConfirmacion.add(labelCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 90, -1));

        labelApellido.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelApellido.setText("apellido");
        panelConfirmacion.add(labelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 90, -1));

        labelNacionalidad.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelNacionalidad.setText("nacionalidad");
        panelConfirmacion.add(labelNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 120, -1));

        labelRecinto.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelRecinto.setText("recinto");
        panelConfirmacion.add(labelRecinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 80, -1));

        labelMatricula.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelMatricula.setText("matricula");
        panelConfirmacion.add(labelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 80, -1));

        labelPasantia.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelPasantia.setText("pasantia");
        panelConfirmacion.add(labelPasantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 90, -1));

        labelCorreo.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelCorreo.setText("email");
        panelConfirmacion.add(labelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 70, -1));

        labelCarrera.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelCarrera.setText("carrera");
        panelConfirmacion.add(labelCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 90, -1));

        labelTelefono.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelTelefono.setText("telefono");
        panelConfirmacion.add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, -1));
        panelConfirmacion.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 230, -1));
        panelConfirmacion.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, -1));

        tfMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMatriculaActionPerformed(evt);
            }
        });
        panelConfirmacion.add(tfMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 230, -1));
        panelConfirmacion.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 230, -1));
        panelConfirmacion.add(tfNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 230, -1));
        panelConfirmacion.add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 230, -1));
        panelConfirmacion.add(tfCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 230, -1));
        panelConfirmacion.add(tfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 230, -1));
        panelConfirmacion.add(tfProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 230, -1));
        panelConfirmacion.add(tfSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 230, -1));

        labelNombre1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelNombre1.setText("nombre");
        panelConfirmacion.add(labelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 80, -1));

        editarCorreo.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarCorreo.setForeground(java.awt.Color.blue);
        editarCorreo.setText("Editar");
        editarCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarCorreo.setOpaque(true);
        editarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarCorreoMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 60, 20));

        editarMatricula.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarMatricula.setForeground(java.awt.Color.blue);
        editarMatricula.setText("Editar");
        editarMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarMatricula.setOpaque(true);
        editarMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMatriculaMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 60, 20));

        editarDireccion.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarDireccion.setForeground(java.awt.Color.blue);
        editarDireccion.setText("Editar");
        editarDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarDireccion.setOpaque(true);
        editarDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarDireccionMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 60, 20));

        editarSector.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarSector.setForeground(java.awt.Color.blue);
        editarSector.setText("Editar");
        editarSector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarSector.setOpaque(true);
        editarSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarSectorMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 60, 20));

        editarProvincia.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarProvincia.setForeground(java.awt.Color.blue);
        editarProvincia.setText("Editar");
        editarProvincia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarProvincia.setOpaque(true);
        editarProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarProvinciaMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 60, 20));

        editarNacionalidad.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarNacionalidad.setForeground(java.awt.Color.blue);
        editarNacionalidad.setText("Editar");
        editarNacionalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNacionalidad.setOpaque(true);
        editarNacionalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNacionalidadMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 250, 60, 20));

        editarRecinto.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarRecinto.setForeground(java.awt.Color.blue);
        editarRecinto.setText("Editar");
        editarRecinto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarRecinto.setOpaque(true);
        editarRecinto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarRecintoMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarRecinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 70, 20));

        editarNombre.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarNombre.setForeground(java.awt.Color.blue);
        editarNombre.setText("Editar");
        editarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNombre.setOpaque(true);
        editarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNombreMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 60, 20));

        editarApellido.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarApellido.setForeground(java.awt.Color.blue);
        editarApellido.setText("Editar");
        editarApellido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarApellido.setOpaque(true);
        editarApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarApellidoMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, 60, 20));

        editarCedula.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarCedula.setForeground(java.awt.Color.blue);
        editarCedula.setText("Editar");
        editarCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarCedula.setOpaque(true);
        editarCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarCedulaMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 60, 20));

        editarCarrera.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarCarrera.setForeground(java.awt.Color.blue);
        editarCarrera.setText("Editar");
        editarCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarCarrera.setOpaque(true);
        editarCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarCarreraMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 60, 20));

        editarPasantia.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editarPasantia.setForeground(java.awt.Color.blue);
        editarPasantia.setText("Editar");
        editarPasantia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarPasantia.setOpaque(true);
        editarPasantia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarPasantiaMouseClicked(evt);
            }
        });
        panelConfirmacion.add(editarPasantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 70, 20));

        labelDireccion.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelDireccion.setText("direccion");
        panelConfirmacion.add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 80, -1));

        labelSector.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        labelSector.setText("sector");
        panelConfirmacion.add(labelSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 90, -1));

        comboBoxCarreraConfirm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administración", "Agrimensura", "Agronomía", "Arquitectura", "Artes Plásticas", "Bibliotecología", "Bioanálisis", "Biología", "Ciencias Fisilógicas", "Ciencias Geográficas", "Ciencias Morfológicas", "Cine TV-Fotografía", "Comunicación Social", "Contabilidad", "Crítica e Historia del Arte", "Diseño Industrial y Moda", "Economía", "Educación Infantil y Básicas", "Educación Media", "Enfermería", "Escuela de Idiomas", "Estadística", "Farmacia", "Filosofía", "Física", "Física Y Deporte", "Historia y Antropología", "Idioma", "Informática", "Ingeniería Civil", "Ingeniería Electromecánica", "Ingeniería Industrial", "Ingeniería Química", "Letras", "Matemática", "Medicina", "Mercadotecnia", "Micro biología y Parasitología", "Música", "Odontología", "Orientación Profesional", "Orientación y Pedagogía", "Pedagogía", "Psicología", "Publicidad", "Química", "Salud Pública", "Sociología", "Teatro", "Teoría y Gestión Educativa", "Veterinaria", "Zootecnia" }));
        comboBoxCarreraConfirm.setOpaque(true);
        comboBoxCarreraConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCarreraConfirmActionPerformed(evt);
            }
        });
        panelConfirmacion.add(comboBoxCarreraConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, -1, -1));

        comboBoxSedeConfirm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baní", "Barahona", "Bonao", "Duvergé", "Hato Mayor", "Higuey", "La Romana", "La Vega", "Nagua", "Neiba", "Puerto Plata", "Samaná", "San Cristóbal", "San Francisco de Macorís", "San Juan de la Maguana", "San Pedro de Macorís", "Santiago", "Santiago Rodríguez", "Santo Domingo", "Valverde-Mao" }));
        panelConfirmacion.add(comboBoxSedeConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, -1));

        radioBtnPasantiaSIConfirm.setText("SI");
        radioBtnPasantiaSIConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPasantiaSIConfirmActionPerformed(evt);
            }
        });
        panelConfirmacion.add(radioBtnPasantiaSIConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        radioBtnPasantiaNOConfirm.setText("NO");
        radioBtnPasantiaNOConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPasantiaNOConfirmActionPerformed(evt);
            }
        });
        panelConfirmacion.add(radioBtnPasantiaNOConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, -1, -1));

        jButton8.setText("jButton8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelConfirmacion.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        panelMain.add(panelConfirmacion, "card9");

        panelCompletado.setPreferredSize(new java.awt.Dimension(932, 720));
        panelCompletado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel33.setText("SE HA REGISTRADO CON EXITO!");
        panelCompletado.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, 60));

        panelMain.add(panelCompletado, "card9");

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 932, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelConsulta);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelInicio);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelInscripcion);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelAyuda);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelRegistro);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        // TODO add your handling code here:
        seleccionarArchivo(textFieldFoto, 0);
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelProcesoArchivos);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //remove all panel
        
        if(textFieldCedula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "La Cedula no pueda estar vacio");
        }else if(textFieldFoto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "La Foto no puede estar Vacio");
        }else if(textFieldKardex.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El Kardex no puede estar vacio");
        }else if(textFieldNotas.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "La Nota no puede estar vacia");
        }else if(textFieldRecibo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El Recibo no puede estar vacio");
        }else{
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelProcesoForm);
        panelMain.repaint();
        panelMain.revalidate();
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelRegistro);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void textFieldKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldKardexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldKardexActionPerformed

    private void textFieldFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFotoActionPerformed

    private void textFieldReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldReciboActionPerformed

    private void textFieldNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNotasActionPerformed

    private void textFieldCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCedulaActionPerformed
        
    }//GEN-LAST:event_textFieldCedulaActionPerformed

    private void radioBtnPasantiaSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPasantiaSIActionPerformed
        // TODO add your handling code here:
        estudiante.setPasantia("SI");
    }//GEN-LAST:event_radioBtnPasantiaSIActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelProcesoArchivos);
        panelMain.repaint();
        panelMain.revalidate();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        limpiarRegistro();

    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnSiguienteFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteFormActionPerformed

        
        // TODO add your handling code here:
        
        if(radioBtnPasantiaSI.isSelected() || radioBtnPasantiaNO.isSelected())
        {
            //PARA GUARDAR DATOS EN EL FORMULARIO EN LA CLASE ESTUDIANTE
            estudiante.setNombre(tFieldnombre.getText());
            estudiante.setApellido(tFieldApellido.getText());
            estudiante.setMatricula(tFieldMatricula.getText());
            estudiante.setDireccion(concatDireccion());
            estudiante.setCedula(tFieldCedula.getText());
            estudiante.setNacionalidad(tFieldNacionalidad.getText());

            String cbCarrera = comboBoxCarrera.getSelectedItem().toString();
            estudiante.setCarrera(cbCarrera);

            String cbSede = comboBoxSede.getSelectedItem().toString();
            estudiante.setSede(cbSede);
            
            estudiante.setTelefono(tFieldTelefono.getText());
            estudiante.setCorreo(tFieldCorreo.getText());
            
          
            //EXTRAER DATOS PARA REVISAR Y CONFIRMAR INFORMACION
            tfNombre.setText(tFieldnombre.getText());
            tfApellido.setText(tFieldApellido.getText());
            tfMatricula.setText(tFieldMatricula.getText());
            tfCedula.setText(tFieldCedula.getText());
            tfDireccion.setText(tFieldDireccion.getText());
            tfSector.setText(tFieldSector.getText());
            tfProvincia.setText(tFieldProvincia.getSelectedItem().toString());
            tfNacionalidad.setText(tFieldNacionalidad.getText());
            comboBoxCarreraConfirm.setSelectedItem(comboBoxCarrera.getSelectedItem());
            comboBoxSedeConfirm.setSelectedItem(comboBoxSede.getSelectedItem());
            radioBtnPasantiaSIConfirm.setSelected(radioBtnPasantiaSI.isSelected());
            radioBtnPasantiaNOConfirm.setSelected(radioBtnPasantiaNO.isSelected());
            tfTelefono.setText(estudiante.getTelefono());
            tfCorreo.setText(estudiante.getCorreo());
                //deshabilitar ediccion de campos en confirmar
                tfNombre.setEnabled(false);
                tfApellido.setEnabled(false);
                tfMatricula.setEnabled(false);
                tfCedula.setEnabled(false);
                tfDireccion.setEnabled(false);
                tfSector.setEnabled(false);
                tfProvincia.setEnabled(false);
                tfNacionalidad.setEnabled(false);
                tfTelefono.setEnabled(false);
                tfCorreo.setEnabled(false);
                radioBtnPasantiaNOConfirm.setEnabled(false);
                radioBtnPasantiaSIConfirm.setEnabled(false);
                comboBoxCarreraConfirm.setEnabled(false);
                comboBoxSedeConfirm.setEnabled(false);
            
            //remove all panel
            panelMain.removeAll();
            panelMain.repaint();
            panelMain.revalidate();

            //ADD PANEL
            panelMain.add(panelConfirmacion);
            panelMain.repaint();
            panelMain.revalidate();
        } else {
            //JOptionPane optionPane = new JOptionPane("thank you for using java",JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null, "Debes seleccionar si completo la pasantia");
        } 
    }//GEN-LAST:event_btnSiguienteFormActionPerformed

    private void btnAgregarKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarKardexActionPerformed
        // TODO add your handling code here:
        seleccionarArchivo(textFieldKardex, 1);
    }//GEN-LAST:event_btnAgregarKardexActionPerformed

    private void btnAgregarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNotasActionPerformed
        // TODO add your handling code here:
        seleccionarArchivo(textFieldNotas, 2);
    }//GEN-LAST:event_btnAgregarNotasActionPerformed

    private void btnAgregarCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCedulaActionPerformed
        // TODO add your handling code here:
        seleccionarArchivo(textFieldCedula, 3);
    }//GEN-LAST:event_btnAgregarCedulaActionPerformed

    private void btnAgregarReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReciboActionPerformed
        // TODO add your handling code here:
        seleccionarArchivo(textFieldRecibo, 4);
    }//GEN-LAST:event_btnAgregarReciboActionPerformed

    private void radioBtnPasantiaNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPasantiaNOActionPerformed
        // TODO add your handling code here:
        estudiante.setPasantia("no");
    }//GEN-LAST:event_radioBtnPasantiaNOActionPerformed

    private void btnConfirmarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarRegActionPerformed
        // TODO add your handling code here:
        LocalizaIdDoc idDoc = new LocalizaIdDoc();
        int idLocalizado = idDoc.auto_increment("SELECT MAX(iddocumentos) FROM documento;");
        estudiante.setIdDocumento(idLocalizado);
        DAOmono DAOForm = new DAOmono();
        guardar_documentos(ruta_archivo);
        DAOForm.agregarFormulario(estudiante);
        
        //remove all panel
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.revalidate();
        
        //ADD PANEL
        panelMain.add(panelCompletado);
        panelMain.repaint();
        panelMain.revalidate();
        
        //Limpiar todos los registros y datos de inscripcion
        limpiarRegistro();
        ruta_nombreArchivo = "";
        ruta_archivo[0] = null;
        ruta_archivo[1] = null;
        ruta_archivo[2] = null;
        ruta_archivo[3] = null;
        ruta_archivo[4] = null;
        
        estudiante = new Estudiante();
        documentos = new ArchivosDoc();
        
        
    }//GEN-LAST:event_btnConfirmarRegActionPerformed

    private void comboBoxCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCarreraActionPerformed

    private void comboBoxListaCarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxListaCarrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxListaCarrActionPerformed

    private void btnVerListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerListadoActionPerformed
        String cbCarreraLista = comboBoxListaCarr.getSelectedItem().toString();

        
        GenerarReportes r = new GenerarReportes();
        try {

            r.generarReporte("reportex.jasper", cbCarreraLista);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

       
    }//GEN-LAST:event_btnVerListadoActionPerformed
 
    private void tFieldnombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tFieldnombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tFieldnombreFocusGained

    private void tfMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMatriculaActionPerformed

    private void comboBoxCarreraConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCarreraConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCarreraConfirmActionPerformed

    private void radioBtnPasantiaSIConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPasantiaSIConfirmActionPerformed

    }//GEN-LAST:event_radioBtnPasantiaSIConfirmActionPerformed

    private void radioBtnPasantiaNOConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPasantiaNOConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnPasantiaNOConfirmActionPerformed
    
    boolean clickEditarNombre = false;
    private void editarNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNombreMouseClicked
        clickEditarNombre = editarConfirmar(tfNombre, editarNombre, clickEditarNombre, "nombre");
    }//GEN-LAST:event_editarNombreMouseClicked
    
    boolean clickEditarMatricula = false;
    private void editarMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMatriculaMouseClicked
       clickEditarMatricula = editarConfirmar(tfMatricula, editarMatricula, clickEditarMatricula, "matricula");
        
    }//GEN-LAST:event_editarMatriculaMouseClicked

    boolean clickEditarDireccion  = false;
    private void editarDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarDireccionMouseClicked
        clickEditarDireccion = editarConfirmar(tfDireccion, editarDireccion, clickEditarDireccion, "direccion" );
    }//GEN-LAST:event_editarDireccionMouseClicked

    boolean clickEditarPasantia = false;
    private void editarPasantiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarPasantiaMouseClicked
         if(clickEditarPasantia == false){
            radioBtnPasantiaNOConfirm.setEnabled(true);
            radioBtnPasantiaSIConfirm.setEnabled(true);
            editarPasantia.setText("Confirmar"); 
            editarPasantia.setBackground(Color.yellow);
            editarPasantia.setForeground(Color.red);
            clickEditarPasantia = true;
        } else {
            clickEditarPasantia = false;
            editarPasantia.setText("Editar");
            editarPasantia.setBackground(null);
            editarPasantia.setForeground(Color.BLUE);
            radioBtnPasantiaNOConfirm.setEnabled(false);
            radioBtnPasantiaSIConfirm.setEnabled(false);
            
            if(radioBtnPasantiaSI.isSelected()){
                estudiante.setPasantia("si");
            } else {
                estudiante.setPasantia("no");
            }
            
        }

         
        
    }//GEN-LAST:event_editarPasantiaMouseClicked
    
    boolean clickEditarRecinto = false;
    private void editarRecintoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarRecintoMouseClicked
        if(clickEditarRecinto == false){
            comboBoxSedeConfirm.setEnabled(true);
            editarRecinto.setText("Confirmar"); 
            editarRecinto.setBackground(Color.yellow);
            editarRecinto.setForeground(Color.red);
            clickEditarRecinto = true;
        } else {
            estudiante.setSede(comboBoxSedeConfirm.getSelectedItem().toString());
            clickEditarRecinto = false;
            editarRecinto.setText("Editar");
            editarRecinto.setBackground(null);
            editarRecinto.setForeground(Color.BLUE);
            comboBoxSedeConfirm.setEnabled(false);
            
        }
    }//GEN-LAST:event_editarRecintoMouseClicked
    
    boolean clickEditarCarrera = false;
    private void editarCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCarreraMouseClicked
        if(clickEditarCarrera == false){
            comboBoxCarreraConfirm.setEnabled(true);
            editarCarrera.setText("Confirmar"); 
            editarCarrera.setBackground(Color.yellow);
            editarCarrera.setForeground(Color.red);
            clickEditarCarrera = true;
        } else {
            estudiante.setCarrera(comboBoxCarreraConfirm.getSelectedItem().toString());
            clickEditarCarrera = false;
            editarCarrera.setText("Editar");
            editarCarrera.setBackground(null);
            editarCarrera.setForeground(Color.BLUE);
            comboBoxCarreraConfirm.setEnabled(false);
            
        }
    }//GEN-LAST:event_editarCarreraMouseClicked

    boolean clickEditarCedula = false;
    private void editarCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCedulaMouseClicked
        clickEditarCedula = editarConfirmar(tfCedula, editarCedula, clickEditarCedula, "cedula");
    }//GEN-LAST:event_editarCedulaMouseClicked

    boolean clickEditarApellido = false;
    private void editarApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarApellidoMouseClicked
        clickEditarApellido = editarConfirmar(tfApellido, editarApellido, clickEditarApellido, "apellido");
    }//GEN-LAST:event_editarApellidoMouseClicked
    
    boolean clickEditarSector = false;
    private void editarSectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarSectorMouseClicked
        clickEditarSector = editarConfirmar(tfSector, editarSector, clickEditarSector, "sector");
    }//GEN-LAST:event_editarSectorMouseClicked

    boolean clickEditarProvincia = false;
    private void editarProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarProvinciaMouseClicked
        clickEditarProvincia = editarConfirmar(tfProvincia, editarProvincia, clickEditarProvincia, "provincia");
    }//GEN-LAST:event_editarProvinciaMouseClicked

    boolean clickEditarNacionalidad = false;
    private void editarNacionalidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNacionalidadMouseClicked
        clickEditarNacionalidad = editarConfirmar(tfNacionalidad, editarNacionalidad, clickEditarNacionalidad, "nacionalidad");
    }//GEN-LAST:event_editarNacionalidadMouseClicked

    boolean clickEditarTelefono = false;
    private void editarTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarTelefonoMouseClicked
        clickEditarTelefono = editarConfirmar(tfTelefono, editarTelefono, clickEditarTelefono, "telefono");
    }//GEN-LAST:event_editarTelefonoMouseClicked

    boolean clickEditarCorreo = false;
    private void editarCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCorreoMouseClicked
        clickEditarCorreo = editarConfirmar(tfCorreo, editarCorreo, clickEditarCorreo, "correo");
    }//GEN-LAST:event_editarCorreoMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        abrirFichero("/Users/elianahgx/Desktop/BASURAS DE INTERNET/TutorialPython3.pdf");
    }//GEN-LAST:event_jButton8ActionPerformed
    
    //metodo para editar y confirmar datos del formulario
    private boolean editarConfirmar(JTextField tf, JLabel labelEditar, boolean clickEditar, String campoAModficar) {                                          
        if(clickEditar == false){
            tf.setEnabled(true);
            labelEditar.setText("Confirmar"); 
            labelEditar.setBackground(Color.yellow);
            labelEditar.setForeground(Color.red);
            clickEditar = true;
        } else {
            
            if(null != campoAModficar)switch (campoAModficar) {
                case "nombre":
                    estudiante.setNombre(tfNombre.getText());
                    break;
                case "apellido":
                    estudiante.setApellido(tfApellido.getText());
                    break;
                case "matricula":
                    estudiante.setMatricula(tfMatricula.getText());
                    break;
                case "cedula":
                    estudiante.setCedula(tfCedula.getText());
                    break;
                case "direccion":
                    estudiante.setDireccion(tfDireccion.getText());
                    break;
                case "sector":
                    estudiante.setSector(tfSector.getText());
                    break;
                case "provincia":
                    estudiante.setProvincia(tfProvincia.getText());
                    break;
                case "nacionalidad":
                    estudiante.setNacionalidad(tfNacionalidad.getText());
                    break;
                case "telefono":
                    estudiante.setTelefono(tfTelefono.getText());
                    break;
                case "correo":
                    estudiante.setCorreo(tfCorreo.getText());
                    break;
              
                default:
                    break; 
                    

                
            }

            clickEditar = false;
            labelEditar.setText("Editar");
            labelEditar.setBackground(null);
            labelEditar.setForeground(Color.BLUE);
            tf.setEnabled(false);     
        }
        return clickEditar;
    }  
    
    public void limpiarRegistro(){
    tFieldApellido.setText("");
    tFieldCedula.setText("");
    tFieldCorreo.setText("");
    tFieldDireccion.setText("");
    tFieldMatricula.setText("");
    tFieldNacionalidad.setText("");
    tFieldProvincia.setSelectedIndex(0);
    tFieldSector.setText("");
    tFieldTelefono.setText("");
    tFieldnombre.setText("");
    textFieldCedula.setText("");
    textFieldFoto.setText("");
    textFieldKardex.setText("");
    textFieldNotas.setText("");
    textFieldRecibo.setText("");
    tfApellido.setText("");
    tfCedula.setText("");
    tfCorreo.setText("");
    tfDireccion.setText("");
    tfMatricula.setText("");
    tfNacionalidad.setText("");
    tfNombre.setText("");
    tfProvincia.setText("");
    tfSector.setText("");
    tfTelefono.setText("");
    comboBoxCarrera.setSelectedIndex(0);
    comboBoxCarreraConfirm.setSelectedIndex(0);
    comboBoxSede.setSelectedIndex(0);
    comboBoxSedeConfirm.setSelectedIndex(0);
    grupoRadio1.clearSelection();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCedula;
    private javax.swing.JButton btnAgregarFoto;
    private javax.swing.JButton btnAgregarKardex;
    private javax.swing.JButton btnAgregarNotas;
    private javax.swing.JButton btnAgregarRecibo;
    private javax.swing.JButton btnConfirmarReg;
    private javax.swing.JButton btnSiguienteForm;
    private javax.swing.JButton btnVerListado;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxCarrera;
    private javax.swing.JComboBox<String> comboBoxCarreraConfirm;
    private javax.swing.JComboBox<String> comboBoxListaCarr;
    private javax.swing.JComboBox<String> comboBoxSede;
    private javax.swing.JComboBox<String> comboBoxSedeConfirm;
    private javax.swing.JLabel editarApellido;
    private javax.swing.JLabel editarCarrera;
    private javax.swing.JLabel editarCedula;
    private javax.swing.JLabel editarCorreo;
    private javax.swing.JLabel editarDireccion;
    private javax.swing.JLabel editarMatricula;
    private javax.swing.JLabel editarNacionalidad;
    private javax.swing.JLabel editarNombre;
    private javax.swing.JLabel editarPasantia;
    private javax.swing.JLabel editarProvincia;
    private javax.swing.JLabel editarRecinto;
    private javax.swing.JLabel editarSector;
    private javax.swing.JLabel editarTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCarrera;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNacionalidad;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelPasantia;
    private javax.swing.JLabel labelProvincia;
    private javax.swing.JLabel labelRecinto;
    private javax.swing.JLabel labelSector;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JPanel panelAyuda;
    private javax.swing.JPanel panelCompletado;
    private javax.swing.JPanel panelConfirmacion;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelInscripcion;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelProcesoArchivos;
    private javax.swing.JPanel panelProcesoForm;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JRadioButton radioBtnPasantiaNO;
    private javax.swing.JRadioButton radioBtnPasantiaNOConfirm;
    private javax.swing.JRadioButton radioBtnPasantiaSI;
    private javax.swing.JRadioButton radioBtnPasantiaSIConfirm;
    private javax.swing.JTextField tFieldApellido;
    private javax.swing.JFormattedTextField tFieldCedula;
    private javax.swing.JTextField tFieldCorreo;
    private javax.swing.JTextField tFieldDireccion;
    private javax.swing.JTextField tFieldMatricula;
    private javax.swing.JTextField tFieldNacionalidad;
    private javax.swing.JComboBox<String> tFieldProvincia;
    private javax.swing.JTextField tFieldSector;
    private javax.swing.JFormattedTextField tFieldTelefono;
    private javax.swing.JTextField tFieldnombre;
    private javax.swing.JTextField textFieldCedula;
    private javax.swing.JTextField textFieldFoto;
    private javax.swing.JTextField textFieldKardex;
    private javax.swing.JTextField textFieldNotas;
    private javax.swing.JTextField textFieldRecibo;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfCedula;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNacionalidad;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfProvincia;
    private javax.swing.JTextField tfSector;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables

    private void Reset(JComboBox<String> comboBoxCarrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
