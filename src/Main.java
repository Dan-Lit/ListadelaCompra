
import GUI.Main_Window;
import XML.Writer;
import java.io.File;

public class Main {

    public static void main(String args[]) {
        String URL = "recipebook.xml";
        File file = new File(URL);
        
        if (!file.exists()) Writer.createEmptyXML();
        
        Main_Window v = new Main_Window();
    }

}
