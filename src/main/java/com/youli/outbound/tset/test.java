package com.youli.outbound.tset;

import com.youli.outbound.server.transfer.connect.ConnectServer;
import com.youli.outbound.util.*;
import org.w3c.dom.*;

public class test {
    public static void main (String[] args) throws Exception{
        Document doc = XmlUtil.transfer_connect_xml();
        Element ext = doc.createElement("ext");
        ext.setAttribute("id","800");
        Element outer = doc.createElement("outer");
        outer.setAttribute("to","013550864646");
        NodeList Transfers= doc.getElementsByTagName("Transfer");
        Node Transfer = Transfers.item(0);
        Transfer.appendChild(ext);
        Transfer.appendChild(outer);


        String str = XmlObj2Str.XmltoString(doc);
        System.out.println(str);

        String url = PropertiesReader.getProp("OM_Server");
        String res = HttpClientUtil.sendHttpData(str,url);

        Thread.sleep(10000);

        Document document = XmlStr2Bean.xmlStrToObj(res);
        NodeList outers = document.getElementsByTagName("outer");
        NamedNodeMap attributes = outers.item(0).getAttributes();
        Node id = attributes.getNamedItem("id");
        String nodeValue = id.getNodeValue();
        System.out.println(nodeValue);

        ConnectServer connectServer = new ConnectServer();
        connectServer.outerToMenu(nodeValue,"fring5.dat");


    }
}