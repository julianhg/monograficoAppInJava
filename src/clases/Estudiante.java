/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;



/**
 *
 * @author elianahgx
 */
public class Estudiante extends Formulario{
    private String nombre;
    private String apellido;
    private String matricula;
    private String direccion;
    private String sector;
    private String provincia;
    private String cedula;
    private String nacionalidad;
    private String carrera;
    private String telefono;
    private String correo;
    private int idDocumento;

    public Estudiante() {
    nombre = "";
    apellido = "";
    matricula = "";
    direccion = "";
    sector = "";
    provincia = "";
    cedula = "";
    nacionalidad = "";
    carrera = "";
    telefono = "";
    correo = "";
    }

    public Estudiante( String sede, String pasantia) {
        super(sede, pasantia);
    }

  
    
    
    public Estudiante(String nombre, String apellido, String matricula, String direccion, String sector, String provincia, String cedula, String nacionalidad, String carrera, String telefono, String correo, int idDoc) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.direccion = direccion;
        this.sector = sector;
        this.provincia = provincia;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.carrera = carrera;
        this.telefono = telefono;
        this.correo = correo;
        this.idDocumento = idDoc;
    }

      

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    
    
    
    
    
    
    
    
    
}
