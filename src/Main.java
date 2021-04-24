
import GUI.Ventana_Principal;
import XML.Escritura;
import java.io.File;

public class Main {

    public static void main(String args[]) {
        String URL = "recetario.xml";
        File file = new File(URL);
        
        if (!file.exists()) Escritura.crearXMLvacio();
        
        Ventana_Principal v = new Ventana_Principal();
    }

}
