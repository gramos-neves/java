package xpath;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;


public class XpathParseDemo2 {

    public static void main(String[] args) {

         try {
             File inputFile = new File("input2.txt");
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder;

             dBuilder = dbFactory.newDocumentBuilder();

             Document doc = dBuilder.parse(inputFile);
             doc.getDocumentElement().normalize();

             XPath xPath = XPathFactory.newInstance().newXPath();

             HashMap<String, String> prefMap = new HashMap<String, String>() {
                 {
                     put("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
                     put("ns2", "http://url1");
                     put("ns3", "http://url2");
                 }
             };
           //   SimpleNamespaceContext namespaces = new SimpleNamespaceContext(prefMap);
           //  xpath.setNamespaceContext(namespaces);



            // String expression = "/item";

            // String expression = "/SOAP-ENV:Envelope/SOAP-ENV:Header/SOAP-ENV:Body/ns1:ListarFichasAutorizadasResponse/return/item";


             String expression = "/ns1:ListarFichasAutorizadasResponse";

          //   String expression ="/SOAP-ENV:Envelope/SOAP-ENV:Header/SOAP-ENV:Body/multiRef [@*[local-name()='type' and .='ns2:Map']] /item[key]";

             NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

              System.out.println(nodeList.getLength());

             for(int i = 0; i < nodeList.getLength(); i++){
                 Node nNode = nodeList.item(i);
                 System.out.println("\nCurrent Element :" + nNode.getNodeName());

                 if(nNode.getNodeType() == Node.ELEMENT_NODE){
                     Element eElement = (Element) nNode;

                    // System.out.println("Student roll no:" + eElement.getAttribute("rollno"));
                     System.out.println("Fisrt Name:" + eElement.getElementsByTagName("ID_FICHA").item(0).getTextContent());

                 }

             }

         }catch (ParserConfigurationException e){
             e.printStackTrace();
         }catch (SAXException e){
             e.printStackTrace();
         }catch (IOException e){
             e.printStackTrace();
         }catch (XPathExpressionException e){
             e.printStackTrace();
         }

    }


    protected static InputStream convertStringToStream(String s) {
        InputStream in = new ByteArrayInputStream(s.getBytes());
        return in;
    }

}
