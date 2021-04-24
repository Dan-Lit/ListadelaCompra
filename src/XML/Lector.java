package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Lector {

    private static String URL = "recetario.xml";

    public static ArrayList<String> listaRecetas() {
        /**
         * Lista el nombre de todas las recetas registradas.
         *
         * @return Devuelve un ArrayList de String que almacena el nombre de las
         * recetas.
         * @author Daniel
         *
         */
        ArrayList<String> list = new ArrayList();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File(URL));

            NodeList listaRecetas = documento.getElementsByTagName("receta");

            for (int i = 0; i < listaRecetas.getLength(); i++) {
                Node nodo = listaRecetas.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;
                    NodeList hijos = e.getChildNodes();
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {

                            if (hijo.getNodeName().equals("nombre")) {
                                String nombreReceta = hijo.getTextContent();
                                list.add(nombreReceta);

                            }

                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<String> listaIngredientes(String nombreReceta) {
        /**
         * Lista los ingredientes de la receta seleccionada.
         *
         * @param nombreReceta Nombre de la receta a buscar.
         * @return Devuelve un ArrayList de String que almacena los ingredientes
         * de la receta seleccionada.
         * @author Daniel.
         */
        ArrayList<String> list = new ArrayList();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(URL));

            XPath xpath = XPathFactory.newInstance().newXPath();
            String XPathExpresion = "/recetario/receta[nombre='" + nombreReceta + "']/ingrediente/text()";
            XPathExpression expr = xpath.compile(XPathExpresion);;
            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) {
                list.add(nodes.item(i).getNodeValue());
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
