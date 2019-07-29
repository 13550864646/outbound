package com.youli.outbound.util;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * 将xml Element装换为String字符串
 */
public class XmlObj2Str {

    private static TransformerFactory transformerFactory;
    private static Transformer transformer;
    private static StringWriter writer;

    /**
     * 初始化xml转换工具类
     */
    static {
        try {
            //创建一个 TransformerFactory，通过静态方法调用类的newInstance()方法
            transformerFactory = TransformerFactory.newInstance();
            //创建一个 Transformer，可以将 XML 文档转换成其他格式
            transformer = transformerFactory.newTransformer();
            //如果想让XML数据通过网络传播，需要转换成字符串，使用 Writer接收
            writer = new StringWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将xml对象转换为String字符串
     * @param document
     * @return
     */
    public static String XmltoString(Document document) {
        try {
            transformer.transform(new DOMSource(document), new StreamResult(writer));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
