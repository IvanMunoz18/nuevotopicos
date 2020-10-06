package clases;
public class Prueba {  
    public static void main(String[] args) {
        Modelo m = new Modelo();
        Vista v = new Vista();
        Controlador corrida = new Controlador(m, v);
        corrida.run(); 
    }
}
