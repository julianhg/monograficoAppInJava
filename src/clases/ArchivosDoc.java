
package clases;


public class ArchivosDoc {
    byte[] foto;
    byte[] recNotas;
    byte[] cedula;
    byte[] recibo;
    byte[] kardex;

    public ArchivosDoc() {
        this.foto = null;
        this.recNotas = null;
        this.cedula = null;
        this.recibo = null;
        this.kardex = null;
    }

    
    
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getRecNotas() {
        return recNotas;
    }

    public void setRecNotas(byte[] recNotas) {
        this.recNotas = recNotas;
    }

    public byte[] getCedula() {
        return cedula;
    }

    public void setCedula(byte[] cedula) {
        this.cedula = cedula;
    }

    public byte[] getRecibo() {
        return recibo;
    }

    public void setRecibo(byte[] recibo) {
        this.recibo = recibo;
    }

    public byte[] getKardex() {
        return kardex;
    }

    public void setKardex(byte[] kardex) {
        this.kardex = kardex;
    }
    
    
    


    
    
    
}
