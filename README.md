# nuevotopicos
codes

Bienvenidos a mi repositorio de topicos avanzados de programacion!
Este ejercicio es de encriptado y desencriptado de texto!

Problema a resolver:
Se va a crear un programa de cifrado simple. El proceso es muy sencillo. Se divide en dos partes.
 En primer lugar, cada letra mayúscula o minúscula debe desplazarse tres posiciones
hacia la derecha, de acuerdo con la tabla ASCII: la letra ’a’ debe convertirse en la letra
’d’, la letra ’y’ debe convertirse en el carácter ’—’, etc. En segundo lugar, cada línea debe
invertirse. Después de invertir, todos los caracteres de la mitad en adelante (truncado) deben
moverse una posición a la izquierda en ASCII. En este caso, ’b’ se convierte en ’a’ y ’a’ se
convierte en ’‘’.
Por ejemplo, si como entrada tenemos la cadena abcABC1 si la palabra resultante de la
primera parte es ”defDEF1”, las letras ”DEF1”deben moverse una posición a la izquierda.
Sin embargo, si la palabra resultante de la primera parte es ”tesA”, las letras ”sA”serán
desplazadas. El resultado cifrado de la cadena es 1FECedc.


--Algoritmo de encriptado, desencriptado, escribir y guardar el archivo generado.

class Modelo {
    private String c1;
    private String fileName;
    final char shiftup = (char) 3;
    final char shiftdown = (char) 1;
    public void setContenido(String text) {
        c1 = text;
    }

    public String getContenido() {
        return c1;
    }

    public void setFileName(String nombre) {
        fileName = fileName;
    }
    
    public String AbrirArchivo(String AbrirTexto) {
        String c;
        String contenido = "";
        File file = new File("C:\\Users\\LENOVO\\Desktop\\Topicos1"+AbrirTexto);
        try {
            if (file.exists()) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((c = b.readLine()) != null) {
                    c1 = c1 + c + '\n';
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            } catch (IOException ioException) {
           }
        c1= c1;
        return c1;
    }
    public void GuardarArchivo (String Guardar2){
        try {
            FileWriter writer = new FileWriter("Encrypt.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String textToPrint = Guardar2; 
            bufferedWriter.write(textToPrint);
            bufferedWriter.close();
            System.out.println("Texto Guardado");
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    public String Encriptado() {
        String ctext = "";
        for (String line : c1.split("\n")) {
            StringBuilder chain1 = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftup;
                }
                chain1.append(c);
            }

            StringBuilder shift_cadena = new StringBuilder();
            String shifttext = chain1.reverse().toString();

            int h = shifttext.length() / 2;
            for (char c : shifttext.substring(h,
                    shifttext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c -= shiftdown;
                }
                shift_cadena.append(c);
            }
            ctext = ctext + shifttext.substring(0, h) + shift_cadena.toString() + '\n';
        }
        c1 = ctext;
        return ctext;
    }

    public String Desencriptado() {
        String text = "";
        for (String text1 : c1.split("\n")) {
            int h = text1.length() / 2;
            StringBuilder shift_chain = new StringBuilder(text1.substring(0, h));

            for (char c : text1.substring(h, text1.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftdown;
                }
                shift_chain.append(c);
            }
            String shifttext = shift_chain.reverse().toString();
            StringBuilder cadena = new StringBuilder();

            for (char c : shifttext.toCharArray()) {
                if (Character.isLetter(c - 3)) {
                    c -= shiftup;
                }
                cadena.append(c);
            }
            text = text + cadena.toString() + '\n';
        }
        c1= text;
        return text;
    }
    }
    
   // Se pone el nombre del archivo en el textlabel, despues en el textArea se coloca la informacion.
    //El boton 1 sirve para abrir la informacion guardad en el archivo.
    //El boton 2 sirve para encriptar el texto ingresado en el textArea.
    //El boton 3 sirve para desencriptar el texto ingresado en el textArea
    //El boton 4 sirve para guardar la informacion en un archivo.txt
    
    //Pueden utilizar estas cadenas como prueba
/*Texto #3
abcABC1
vxpdylY .ph
vv.xwfxo.fd*/

/*Cadenas resultantes (respectivamente)
3# rvzgV
1FECedc
ks. \n{frzx
gi.r{hyz-xx */

//clase vista
//La clase basicamente sirve para inicializar los botones y relacionarlos con los metodos de encriptar, desencriptar, guardar y abrir los archivos.

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


// clase vistaInterfaz esta clase sirve para crear los botones que se utilizaran por el nombre del boton segun sea requerido
//por el usuario la funcion de cada uno de estos.

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
    
    //clase controlador
    //Esta clase junta los atributos de la clase modelo y de la clase vista para que cada todo funcione y haga las cosas
    // que desee el usuario correctamente, lo separa mediante un switch segun sea el caso une los atributos de las clases
    //antes mencionadas y crea el metodo para la ejecucion.
    
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

//clase de prueba
// La funcion de esta clase es probar el correcto funcionamiento del programa, se importa el constructor de la clase controlador
// y el metodo para la ejecucion del programa.

public class Prueba {  
    public static void main(String[] args) {
        Modelo m = new Modelo();
        Vista v = new Vista();
        Controlador corrida = new Controlador(m, v);
        corrida.run(); 
    }
}



    
