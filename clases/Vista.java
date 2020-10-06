package clases;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import static clases.VistaInterfaz.Abrir;
import static clases.VistaInterfaz.DESENCRIPTAR;
import static clases.VistaInterfaz.ENCRIPTAR;
import static clases.VistaInterfaz.Guardar;
public class Vista extends JFrame {
    private final JTextArea text; 
    private final JButton encriptarJButton;
    private final JButton desencriptarJButton;
    private final JButton GuardarArchivoJButton;
    private final JButton AbrirArchivoJButton;
    private final JTextField fileName;

    public Vista() {
        JPanel fileJPanel;
        JLabel lblFile;
        JPanel buttonJPanel;
        BorderLayout layout;
        layout = new BorderLayout(40, 35);
        setLayout(layout);
        fileJPanel = new JPanel();
        fileJPanel.setLayout(new FlowLayout());
        lblFile = new JLabel("Texto/Archivo:");
        fileJPanel.add(lblFile);
        fileName = new JTextField(20);
        fileJPanel.add(fileName);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(30, 30);
        add(new JScrollPane(text), BorderLayout.CENTER);
        buttonJPanel = new JPanel();
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(6, 3));
        AbrirArchivoJButton = new JButton(Abrir);
        buttonJPanel.add(AbrirArchivoJButton);
        encriptarJButton = new JButton(ENCRIPTAR);
        buttonJPanel.add(encriptarJButton);
        desencriptarJButton = new JButton(DESENCRIPTAR);
        buttonJPanel.add(desencriptarJButton);
        GuardarArchivoJButton = new JButton(Guardar);
        buttonJPanel.add(GuardarArchivoJButton);
        add(buttonJPanel, BorderLayout.EAST);
    }

    public String getFileName() {
        return fileName.getText();
    }

    public String getTexto() {
        return text.getText();
    }

    public void setTexto(String s) {
        text.setText(s);
    }

    public void setControlador (Controlador cont) {
         AbrirArchivoJButton.addActionListener(cont);
       GuardarArchivoJButton.addActionListener(cont);
        encriptarJButton.addActionListener(cont);
        desencriptarJButton.addActionListener(cont);
    }
}
