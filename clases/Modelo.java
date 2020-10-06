package clases;
import java.io.BufferedReader;             //LIBRERIAS UTILIZADAS
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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