package com.youli.outbound.tset;

import com.youli.outbound.util.HttpClientUtil;
import com.youli.outbound.util.PropertiesReader;
import com.youli.outbound.util.XmlObj2Str;
import com.youli.outbound.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MenuTest {
    public static void main (String[] args){
        Document manage_query_xml = XmlUtil.manage_query_xml();
        NodeList manages = manage_query_xml.getElementsByTagName("Manage");
        Element voicefile = manage_query_xml.createElement("voicefile");
        manages.item(0).appendChild(voicefile);

        String str = XmlObj2Str.XmltoString(manage_query_xml);
        System.out.println(str);
        String url = PropertiesReader.getProp("OM_Server");
        HttpClientUtil.sendHttpData(str,url);
    }
}
