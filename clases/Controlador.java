package clases;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class Controlador implements ActionListener {
    private Modelo model;
    private Vista view;
    public Controlador(Modelo m, Vista v) {
        model = m;
        view = v;
        view.setControlador(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case VistaInterfaz.Abrir:
                model.setFileName(view.getFileName());
                view.setTexto(model.AbrirArchivo(view.getFileName()));
                break;
            case VistaInterfaz.ENCRIPTAR:
                model.setContenido(view.getTexto());
                view.setTexto(model.Encriptado());
                break;
            case VistaInterfaz.DESENCRIPTAR:
                model.setContenido(view.getTexto());
                view.setTexto(model.Desencriptado());
                break;
            case VistaInterfaz.Guardar:
                model.setFileName(view.getFileName());
                model.setContenido(view.getTexto());
                model.GuardarArchivo(view.getTexto());
                break;
            default:
                System.err.println("Error");
                break;
        }
    }

    public void run() {
         view.setLocationRelativeTo(null); 
         view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         view.setSize(500, 200);
         view.setVisible(true);
    }
}
