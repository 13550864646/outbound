package com.youli.outbound.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * xml工具类
 */
public class XmlUtil {

    //根元素标签
    private static String control_root_tag = "Control";//  控制命令
    private static String transfer_root_tag = "Transfer";// 呼叫转接命令
    private static String manage_root_tag = "Manage";//   语音管理命令
    private static String notify_root_tag = "Notify";//   来电受理

    //元素名称
    private static String tag_attribute = "attribute";

    //控制命令（Control）属性
    private static String control_query_attr = "Query";//查询
    private static String control_assign_attr = "Assign";//配置
    private static String control_hold_attr = "Hold";//呼叫保持
    private static String control_unhold_attr = "Unhold";//呼叫接回
    private static String control_mute_attr = "Mute";//开启静音
    private static String control_unmute_attr = "Unmute";//解除静音
    private static String control_monitor_attr = "Monitor";//监听
    private static String control_talk_attr = "Talk";//从监听到插播状态变换
    private static String control_listen_attr = "Listen";//从插播到监听状态变换
    private static String control_bargein_attr = "Bargein";//强插
    private static String control_clear_attr = "Clear";//强拆

    //呼叫转接命令（Transfer）属性
    private static String transfer_connect_attr = "Connect";//连接
    private static String transfer_queue_attr = "Queue";//队列
    private static String transfer_conference_attr = "Conference";//会议

    //语音管理命令(Manage)属性
    private static String manage_query_attr = "Query";//查询语音文件
    private static String manage_remove_attr = "Remove";//删除语音文件

    //来电受理（Notify）属性
    private static String notify_accept_attr = "Accept";//来电受理


    //xml创建工具类
    public static DocumentBuilderFactory factory = null;
    public static DocumentBuilder builder = null;
    public static Document document = null;


    //控制命令（Control）各属性静态对象
    public static Element control_query_ele;//查询
    public static Element control_assign_ele;//配置
    public static Element control_hold_ele;//呼叫保持
    public static Element control_unhold_ele;//呼叫接回
    public static Element control_mute_ele;//开启静音
    public static Element control_unmute_ele;//解除静音
    public static Element control_monitor_ele;//监听
    public static Element control_talk_ele;//从监听到插播状态变换
    public static Element control_listen_ele;//从插播到监听状态变换
    public static Element control_bargein_ele;//强插
    public static Element control_clear_ele;//强拆

    //呼叫转接命令（Transfer）各属性静态对象
    public static Element transfer_connect_ele;//连接
    public static Element transfer_queue_ele;//队列
    public static Element transfer_conference_ele;//会议

    //语音管理命令(Manage)各属性各静态对象
    public static Element manage_query_ele;//查询语音文件
    public static Element manage_remove_ele;//删除语音文件

    //来电受理（Notify）各属性静态对象
    public static Element notify_accept_ele;//来电受理


    /**
     * 初始化 xml 各属性对象
     *
     * @return
     */
    static {
        try {
            //创建一个新的 DocumentBuilderFactory，
            //使用静态方法调用 newInstance()方法，创建一个新的实例
            factory = DocumentBuilderFactory.newInstance();
            //创建一个 DocumentBuilder
            builder = factory.newDocumentBuilder();
            //创建一个全新的 XML 文档：Document
            document = builder.newDocument();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建一个全新的 XML 文档：Document
     * @return
     */
    public static Document docBuilder(){
        return builder.newDocument();
    }

    /**
     * 创建control xml对象
     * 根元素对象
     * @return
     */
    public static Element control_xml(){
        return document.createElement(control_root_tag);
    }

    /**
     * 创建transfer xml对象
     * 根元素对象
     * @return
     */
    public static Element transfer_xml(){
        return document.createElement(transfer_root_tag);
    }

    /**
     * 创建cmanage xml对象
     * 根元素对象
     * @return
     */
    public static Element manage_xml(){
        return document.createElement(manage_root_tag);
    }

    /**
     * 创建notify xml对象
     * 根元素对象
     * @return
     */
    public static Element notify_xml(){
        return document.createElement(notify_root_tag);
    }

    /**
     * 创建control_query_xml对象
     * 查询
     * @return
     */
    public static Document control_query_xml(){
        Document doc = docBuilder();
        control_query_ele = doc.createElement(control_root_tag);
        control_query_ele.setAttribute(tag_attribute, control_query_attr);
        doc.appendChild(control_query_ele);
        return doc;
    }

    /**
     * 创建control_assign_xml对象
     * 配置
     * @return
     */
    public static Document control_assign_xml(){
        Document doc = docBuilder();
        control_assign_ele = doc.createElement(control_root_tag);
        control_assign_ele.setAttribute(tag_attribute, control_assign_attr);
        doc.appendChild(control_assign_ele);
        return doc;
    }

    /**
     * 创建control_hold_xml对象
     * 呼叫保持
     * @return
     */
    public static Document control_hold_xml(){
        Document doc = docBuilder();
        control_hold_ele = doc.createElement(control_root_tag);
        control_hold_ele.setAttribute(tag_attribute, control_hold_attr);
        doc.appendChild(control_hold_ele);
        return doc;
    }

    /**
     * 创建control_unhold_xml对象
     * 呼叫接回
     * @return
     */
    public static Document control_unhold_xml(){
        Document doc = docBuilder();
        control_unhold_ele = doc.createElement(control_root_tag);
        control_unhold_ele.setAttribute(tag_attribute, control_unhold_attr);
        doc.appendChild(control_unhold_ele);
        return doc;
    }

    /**
     * 创建control_mute_xml对象
     * 开启静音
     * @return
     */
    public static Document control_mute_xml(){
        Document doc = docBuilder();
        control_mute_ele = doc.createElement(control_root_tag);
        control_mute_ele.setAttribute(tag_attribute, control_mute_attr);
        doc.appendChild(control_mute_ele);
        return doc;
    }

    /**
     * 创建control_unmute_xml对象
     * 解除静音
     * @return
     */
    public static Document control_unmute_xml(){
        Document doc = docBuilder();
        control_unmute_ele = doc.createElement(control_root_tag);
        control_unmute_ele.setAttribute(tag_attribute, control_unmute_attr);
        doc.appendChild(control_unmute_ele);
        return doc;
    }

    /**
     * 创建control_monitor_xml对象
     * 监听
     * @return
     */
    public static Document control_monitor_xml(){
        Document doc = docBuilder();
        control_monitor_ele = doc.createElement(control_root_tag);
        control_monitor_ele.setAttribute(tag_attribute, control_monitor_attr);
        doc.appendChild(control_monitor_ele);
        return doc;
    }

    /**
     * 创建control_talk_xml对象
     * 从监听到插播状态变换
     * @return
     */
    public static Document control_talk_xml(){
        Document doc = docBuilder();
        control_talk_ele = doc.createElement(control_root_tag);
        control_talk_ele.setAttribute(tag_attribute, control_talk_attr);
        doc.appendChild(control_talk_ele);
        return doc;
    }

    /**
     * 创建control_isten_xml对象
     * 从插播到监听状态变换
     * @return
     */
    public static Document control_isten_xml(){
        Document doc = docBuilder();
        control_listen_ele = doc.createElement(control_root_tag);
        control_listen_ele.setAttribute(tag_attribute, control_listen_attr);
        doc.appendChild(control_listen_ele);
        return doc;
    }

    /**
     * 创建control_argein_xml对象
     * 强插
     * @return
     */
    public static Document control_argein_xml(){
        Document doc = docBuilder();
        control_bargein_ele = doc.createElement(control_root_tag);
        control_bargein_ele.setAttribute(tag_attribute, control_bargein_attr);
        doc.appendChild(control_bargein_ele);
        return doc;
    }

    /**
     * 创建control_lear_xml对象
     * 强拆
     * @return
     */
    public static Document control_lear_xml(){
        Document doc = docBuilder();
        control_clear_ele = doc.createElement(control_root_tag);
        control_clear_ele.setAttribute(tag_attribute, control_clear_attr);
        doc.appendChild(control_clear_ele);
        return doc;
    }

    /**
     * 创建transfer_connect_xml对象
     * 连接
     * @return
     */
    public static Document transfer_connect_xml(){
        Document doc = docBuilder();
        transfer_connect_ele = doc.createElement(transfer_root_tag);
        transfer_connect_ele.setAttribute(tag_attribute, transfer_connect_attr);
        doc.appendChild(transfer_connect_ele);
        return doc;
    }

    /**
     * 创建transfer_conference_xml对象
     * 队列
     * @return
     */
    public static Document transfer_queue_xml(){
        Document doc = docBuilder();
        transfer_queue_ele = doc.createElement(transfer_root_tag);
        transfer_queue_ele.setAttribute(tag_attribute, transfer_queue_attr);
        doc.appendChild(transfer_queue_ele);
        return doc;
    }

    /**
     * 创建transfer_conference_xml对象
     * 会议
     * @return
     */
    public static Document transfer_conference_xml(){
        Document doc = docBuilder();
        transfer_conference_ele = doc.createElement(transfer_root_tag);
        transfer_conference_ele.setAttribute(tag_attribute, transfer_conference_attr);
        doc.appendChild(transfer_conference_ele);
        return doc;
    }

    /**
     * 创建manage_query_xml对象
     * 查询语音文件
     * @return
     */
    public static Document manage_query_xml(){
        Document doc = docBuilder();
        manage_query_ele = doc.createElement(manage_root_tag);
        manage_query_ele.setAttribute(tag_attribute, manage_query_attr);
        doc.appendChild(manage_query_ele);
        return doc;
    }

    /**
     * 创建manage_remove_xml对象
     * 删除语音文件
     * @return
     */
    public static Document manage_remove_xml(){
        Document doc = docBuilder();
        manage_remove_ele = doc.createElement(transfer_root_tag);
        manage_remove_ele.setAttribute(tag_attribute, manage_remove_attr);
        doc.appendChild(manage_remove_ele);
        return doc;
    }

    /**
     * 创建notify_accept_xml对象
     * 来电受理
     * @return
     */
    public static Document notify_accept_xml(){
        Document doc = docBuilder();
        notify_accept_ele = doc.createElement(notify_root_tag);
        notify_accept_ele.setAttribute(tag_attribute, notify_accept_attr);
        doc.appendChild(notify_accept_ele);
        return doc;
    }


}
