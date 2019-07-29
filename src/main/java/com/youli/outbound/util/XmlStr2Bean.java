package com.youli.outbound.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XmlStr2Bean {
    public static Document xmlStrToObj(String xmlStr) {
        //字符串转XML
        Document doc = null;
        try {
            xmlStr = new String(xmlStr.getBytes(), "UTF-8");
            StringReader sr = new StringReader(xmlStr);
            InputSource is = new InputSource(sr);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);

        } catch (ParserConfigurationException e) {
            System.err.println(xmlStr);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            System.err.println(xmlStr);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(xmlStr);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return doc;

    }
}
