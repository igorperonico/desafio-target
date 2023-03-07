package com.target.leituras;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeituraDoArquivoXML {
    public static void main(String[] args) {
        try {
            File arquivo = new File("dados (2).xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(arquivo);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("row");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) node;
                    System.out.println("Dia: " + row.getElementsByTagName("dia").item(0).getTextContent());
                    System.out.println("Valor: " + row.getElementsByTagName("valor").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}