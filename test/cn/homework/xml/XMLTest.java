package cn.homework.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName XMLTest
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 19:49
 * @Version 1.0
 */

public class XMLTest {
    @Test
    public void getUserInfo() throws Exception {
        // 0、利用线程获取类加载器加载资源文件
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("contacts.xml");
        // 1、获取DocumentBuilderFactory对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // 2、获取documentBuilder对象
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        // 3、利用documentBuilder的parse方法解析流文件返回一个doucument对象
        Document document = documentBuilder.parse(resourceAsStream);
        // 4、获取根元素
        Element documentElement = document.getDocumentElement();
        // 5、获取根元素的子元素
        NodeList linkman = documentElement.getElementsByTagName("linkman");
        // 6、获取子元素的第一个元素并转为element类型
        Element item = (Element) linkman.item(1);
        // 7、获取该元素的name标签
        NodeList name = item.getElementsByTagName("name");
        Node item1 = name.item(0);
        System.out.println("name = " + item1.getTextContent());
    }

    @Test
    public void insertTest() throws Exception {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("contacts.xml");
        // 1、获取document对象
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream);
        // 2、获取根元素
        Element documentElement = document.getDocumentElement();
        // 3、在根元素上创建一级父元素
        Element linkman = document.createElement("linkman");
        // 4、创建一级父元素的字元素
        Element name = document.createElement("name");
        Element email = document.createElement("email");
        Element address = document.createElement("address");
        Element group = document.createElement("group");
        // 5、为一级父元素的子元素赋值
        name.setTextContent("李四");
        email.setTextContent("dasikhdoiu@168.com");
        address.setTextContent("外太空");
        group.setTextContent("外星人");
        name.setAttribute("id", "4");
        // 6、将一级父元素的子元素添加到一级父元素节点上
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        // 7、将一级父元素添加到根节点
        documentElement.appendChild(linkman);
        // 8、同步操作
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File("F:\\JavaWeb\\day01\\resources\\contacts.xml"));
        transformer.transform(source, result);
    }
}
