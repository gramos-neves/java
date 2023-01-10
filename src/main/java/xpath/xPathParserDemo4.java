package xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class xPathParserDemo4 {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("input2.xml");


        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        //XPathExpression expr = xpath.compile("//book[@year>1995]/title/text()");
      //  XPathExpression expr = xpath.compile("//return/item/value/item/item/value/text()");
       //XPathExpression expr = xpath.compile("//return");
/*
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for(int i = 0; i < nodes.getLength(); i++){
            System.out.println(nodes.item(i).getNodeValue());
        }*/


      //  XPathExpression   expr = xpath.compile("//return/item[contains(key,'DADOS_FICHAS')]");
        XPathExpression expr = xpath.compile("//return/item/value/item/item/value/text()");
        Object  result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;


        for(int i = 0; i < nodes.getLength(); i++){
            System.out.println(nodes.item(i).getNodeValue());
        }


       /*
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i)
                    .getChildNodes()
                    .item(1)        //node <title> is on first index
                    .getTextContent());
        }*/





    }
}
