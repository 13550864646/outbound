package com.youli.outbound.server.transfer.connect;

import com.youli.outbound.util.HttpClientUtil;
import com.youli.outbound.util.PropertiesReader;
import com.youli.outbound.util.XmlObj2Str;
import com.youli.outbound.util.XmlUtil;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 呼叫转接命令服务类
 */
public class ConnectServer {

    /**
     *  语音插播
     * @param outerID
     * @param voicefile
     */
    public void outerToMenu(String outerID, String voicefile) {
        Document doc = XmlUtil.transfer_connect_xml();
        Element outer = doc.createElement("outer");
        outer.setAttribute("id", outerID);
        Element menu = doc.createElement("voicefile");
        menu.setTextContent(voicefile);
        NodeList Transfers = doc.getElementsByTagName("Transfer");
        Node Transfer = Transfers.item(0);
        Transfer.appendChild(outer);
        Transfer.appendChild(menu);

        String str = XmlObj2Str.XmltoString(doc);

        String url = PropertiesReader.getProp("OM_Server");
        HttpClientUtil.sendHttpData(str, url);

    }

}
