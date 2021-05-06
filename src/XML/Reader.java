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

public class Reader {

    private static String URL = "recipebook.xml";

    public static ArrayList<String> listRecipes() {
        /**
         * List every recipe's name.
         *
         * @author Daniel
         *
         */
        ArrayList<String> list = new ArrayList();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File(URL));

            NodeList recipeNodes = documento.getElementsByTagName("receta");

            for (int i = 0; i < recipeNodes.getLength(); i++) {
                Node nodo = recipeNodes.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;
                    NodeList childNode = e.getChildNodes();
                    for (int j = 0; j < childNode.getLength(); j++) {
                        Node child = childNode.item(j);
                        if (child.getNodeType() == Node.ELEMENT_NODE) {

                            if (child.getNodeName().equals("nombre")) {
                                String recipeName = child.getTextContent();
                                list.add(recipeName);

                            }

                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<String> listIngredients(String recipeName) {
        /**
         * List the selected recipe's ingredients.
         *
         * @author Daniel.
         */
        ArrayList<String> list = new ArrayList();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(URL));

            XPath xpath = XPathFactory.newInstance().newXPath();
            String XPathExpresion = "/recetario/receta[nombre='" + recipeName + "']/ingrediente/text()";
            XPathExpression expr = xpath.compile(XPathExpresion);;
            Object result = expr.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) {
                list.add(nodes.item(i).getNodeValue());
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
