package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class Writer {

    private static final String URL = "recipebook.xml";

    public static void deleteRecipe(String recipeName) {
        /**
         * Deletes a recipe from the recipe book.
         *
         * @author Daniel
         */
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document;

        try {
            document = dbf.newDocumentBuilder().parse(new File(URL));

            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            String xpathexpr = "//recetario/receta[nombre='" + recipeName + "']";
            XPathExpression expression = xpath.compile(xpathexpr);

            Node node = (Node) expression.evaluate(document, XPathConstants.NODE);
            node.getParentNode().removeChild(node);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(document), new StreamResult(new File(URL)));
            System.out.println("XML file updated successfully");

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | TransformerException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void createRecipe(String recipeName, ArrayList<String> ingredients) {
        /**
         * Creates a new recipe in the recipe book.
         *
         */
        String filePath = URL;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //Creates <receta> (Translation EN: recipe)  
            Element recipe = doc.createElement("receta");
            doc.getFirstChild().appendChild(recipe);

            //Creates <nombre> (EN: name) 
            Element nombre = doc.createElement("nombre");
            recipe.appendChild(nombre);
            Text nombreReceta = doc.createTextNode(recipeName);
            nombre.appendChild(nombreReceta);

            //Creates <ingredientes> (EN: ingredients)
            for (int i = 0; i < ingredients.size(); i++) {
                addIngredient(recipe, doc, ingredients.get(i));
            }

            saveFile(doc);

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }

    public static void createEmptyXML() {
        /**
         * If it's the first time you run the program, an empty XML file will be
         * created.
         */
        try {

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("recetario");
            document.appendChild(root);

            saveFile(document);

        } catch (TransformerFactoryConfigurationError | TransformerException | IllegalArgumentException | ParserConfigurationException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void saveFile(Document doc) throws TransformerFactoryConfigurationError, TransformerException, IllegalArgumentException, TransformerConfigurationException {
        //Writes the updated file
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(URL));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML file updated successfully");
    }

    private static void addIngredient(Element receta, Document doc, String newIngredientName) {

        Element ingredientNode = doc.createElement("ingrediente");
        receta.appendChild(ingredientNode);
        Text ingredient = doc.createTextNode(newIngredientName);
        ingredientNode.appendChild(ingredient);

    }

}
