package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Escritura {

    private static final String URL = "recetario.xml";

    public static void borrarReceta(String nombreReceta) {
        /**
         * Borra una receta del recetario.
         *
         * @param nombreReceta nombre de la receta.
         * @author Daniel
         */
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document;

        try {
            document = dbf.newDocumentBuilder().parse(new File(URL));

            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            String xpathexpr = "//recetario/receta[nombre='" + nombreReceta + "']";
            XPathExpression expression = xpath.compile(xpathexpr);

            Node node = (Node) expression.evaluate(document, XPathConstants.NODE);
            node.getParentNode().removeChild(node);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(document), new StreamResult(new File(URL)));
            System.out.println("XML file updated successfully");

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | TransformerException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void editarReceta(String nombreReceta) {

        /**
         * Edita una receta ya registrada.
         *
         * @param nombreReceta nombre de la receta.
         * @author Daniel
         */
        ArrayList<String> recetasRegistradas = Lector.listaRecetas();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document;

        try {
            document = dbf.newDocumentBuilder().parse(new File(URL));

            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            String xpathexpr = "//recetario/receta[nombre='" + nombreReceta + "']";
            XPathExpression expression = xpath.compile(xpathexpr);

            Node node = (Node) expression.evaluate(document, XPathConstants.NODE);
            node.getParentNode().removeChild(node);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(document), new StreamResult(new File(URL)));
            System.out.println("XML file updated successfully");

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | TransformerException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void crearReceta(String nombreNuevaReceta, ArrayList<String> ingredientes) {
        /**
         * Crea una nueva <receta> con sus respectivos <ingrediente>.
         *
         * @param nombreNuevaReceta Nombre de la receta.
         * @param ingredientes Ingredientes que formarán la receta.
         */
        String filePath = URL;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //Introducir <receta> en el nodo raíz
            Element receta = doc.createElement("receta");
            doc.getFirstChild().appendChild(receta);

            //Crear y nombrar nodo <nombre>
            Element nombre = doc.createElement("nombre");
            receta.appendChild(nombre);
            Text nombreReceta = doc.createTextNode(nombreNuevaReceta);
            nombre.appendChild(nombreReceta);

            //Crear y nombrar nodos <ingrediente> 
            for (int i = 0; i < ingredientes.size(); i++) {
                agregarIngrediente(receta, doc, ingredientes.get(i));
            }

            saveFile(doc);

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }

    public static void crearXMLvacio() {
        /**
         * Si es la primera vez que se ejecuta el programa, se creará un archivo
         * .xml vacío.
         */
        try {

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("recetario");
            document.appendChild(root);

            saveFile(document);

        } catch (TransformerFactoryConfigurationError | TransformerException | IllegalArgumentException | ParserConfigurationException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void saveFile(Document doc) throws TransformerFactoryConfigurationError, TransformerException, IllegalArgumentException, TransformerConfigurationException {
//Escribe el documento actualizado en el archivo 
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(URL));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML file updated successfully");
    }

    private static void agregarIngrediente(Element receta, Document doc, String nombreNuevoIngrediente) {

        Element ingrediente = doc.createElement("ingrediente");
        receta.appendChild(ingrediente);
        Text ingrediente1 = doc.createTextNode(nombreNuevoIngrediente);
        ingrediente.appendChild(ingrediente1);

    }

}
