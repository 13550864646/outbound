package com.youli.outbound.controller;

import com.youli.outbound.server.transfer.connect.ConnectServer;
import com.youli.outbound.util.XmlStr2Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 时间报告接收服务
 */
@Controller
public class RevController {

    @RequestMapping(value = "/bussDataReceive")
    public void bussDataReceive(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收xml数据流
        String result = "";
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        //xml报告流转xml报告对象
        Document document = XmlStr2Bean.xmlStrToObj(result);
        //获取Event xml
        NodeList Events = document.getElementsByTagName("Event");
        Node Event = Events.item(0);
        NamedNodeMap attributes = Event.getAttributes();
        //获取attribute属性
        Node attribute = attributes.getNamedItem("attribute");
        String Value = attribute.getNodeValue();

        //创建node集合，存储所有node
        List<String> nodelist = new ArrayList<String>();

        //判断报告类型
        if("ANSWERED".equals(Value)){//呼叫被应答事件(ANSWERED)
            NodeList childNodes = Event.getChildNodes();
            for(int i=1;i<=childNodes.getLength();i++){
                String nodeName = childNodes.item(i).getNodeName();
                nodelist.add(nodeName);
            }
            if(nodelist.contains("outer") && nodelist.contains("ext")){
                Document doc = XmlStr2Bean.xmlStrToObj(result);
                NodeList outers = doc.getElementsByTagName("outer");
                NamedNodeMap attrs = outers.item(0).getAttributes();
                Node id = attrs.getNamedItem("id");
                String outerID = id.getNodeValue();
                System.out.println(outerID);

                ConnectServer connectServer = new ConnectServer();
                connectServer.outerToMenu(outerID,"fring5.dat");
            }

        }
//        else if(){
//
//        }

    }

}
