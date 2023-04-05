package XMLExamples.XMLExample1;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XmlExample {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        File xmlFile = new File("C:\\Users\\Konstantin\\IdeaProjects\\infinnoHomeworks\\src\\animals.xml");
        Document document = documentBuilder.parse(xmlFile);

        NodeList docNodeList = document.getElementsByTagName("dog");

        for (int i = 0; i < docNodeList.getLength(); i++) {
            Element docElement = (Element) docNodeList.item(i);
            String id = docElement.getAttribute("id");
            String dogName = docElement.getElementsByTagName("name").item(0).getTextContent();
            String dogAge = docElement.getElementsByTagName("age").item(0).getTextContent();

            System.out.println("id " + id + ", name and age - " + dogName + " " + dogAge);

            NodeList properties = docElement.getElementsByTagName("property");
            for (int j = 0; j < properties.getLength(); j++) {
                Element property = (Element) properties.item(j);
                String code = property.getAttribute("code");
                String propertyTextContent = property.getTextContent();

                System.out.println(code + " property: " + propertyTextContent);
            }
        }
    }
}
