
package clases;
public interface VistaInterfaz {
    void setControlador(Controlador c);
    public String getFileName();
    public String getText();
    public void setText(String s);
    static final String Abrir = "Abir Archivo";
    static final String Guardar = "Guardar Texto";
    static final String ENCRIPTAR = "Encriptado";
    static final String DESENCRIPTAR = "Desencriptado";

}
