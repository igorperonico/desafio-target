package com.target.task03;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Solution03 {
    public static void main(String[] args) {
        try {
            File arquivo = new File("dados (2).xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(arquivo);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("row");

            ArrayList<Double> valores = new ArrayList<Double>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) node;
                    double valor = Double.parseDouble(row.getElementsByTagName("valor").item(0).getTextContent());
                    if (valor != 0) valores.add(valor);
                }
            }

            double menor =  arredondar(Collections.min(valores));
            double maior = arredondar(Collections.max(valores));
            double media = media(valores);
            int dias = 0;

            for (double valor : valores) {
                if (valor > media) dias++;
            }

            System.out.println("O menor valor de faturamento ocorrido em um dia do mês: R$ " + formatar(menor) );
            System.out.println("O maior valor de faturamento ocorrido em um dia do mês: R$ " + formatar(maior));
            System.out.println("Número de dias no mês em que o valor de " +
                    "faturamento diário foi superior à média mensal: " + dias + " dias");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static double media(ArrayList<Double> valores) {
        double soma = 0;
        for (double valor : valores) soma += valor;

        return arredondar(soma / valores.size());
    }

    public static double arredondar(double valor) {
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN);

        return bd.doubleValue();
    }

    public static String formatar(double valor) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(valor);

        return string;
    }

}
