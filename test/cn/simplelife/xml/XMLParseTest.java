package cn.simplelife.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.InputStream;

/**
 * @ClassName XMLParseTest
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 17:10
 * @Version 1.0
 */

public class XMLParseTest {
    @Test
    public void getDocument() throws Exception {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("contacts.xml");
        // 1、通过DocunmetBuliderFactory.newInstance()得到工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 2、通过工厂对象的newDocunmentBuilder()方法获取DocumentBuilder对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        // 3、通过documentbulider对象的parse方法来进行解析
        Document document = null;
        if (resourceAsStream != null) {
            document = documentBuilder.parse(resourceAsStream);
        }
        System.out.println("document = " + document);
    }

    @Test
    public void getSecondInfo() throws Exception {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("contacts.xml");
        // 1、获取Document对象
        Document document = null;
        if (resourceAsStream != null) {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream);
        }
        // 2、获取跟标签
        Element documentElement = null;
        if (document != null) {
            documentElement = document.getDocumentElement();
        }
        // 3、获取第二个linkman的元素对象
        NodeList linkman = null;
        if (documentElement != null) {
            linkman = (NodeList) documentElement.getElementsByTagName("linkman");
        }
        Element item = null;
        if (linkman != null) {
            item = (Element) linkman.item(1);
        }
        // 4、获取第二个linkman元素的子元素name
        Element node = null;
        if (item != null) {
            node = (Element) item.getElementsByTagName("name").item(0);
        }
        // 5、获取文本
        String textContent = null;
        if (node != null) {
            textContent = node.getTextContent();
        }
        System.out.println(textContent);
    }

    @Test
    public void insertLinkMan() throws Exception {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("contacts.xml");
        // 1、获取文档对象
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream);
        // 2、获取根标签对象
        Element documentElement = document.getDocumentElement();
        // 3、创建一级父元素
        Element linkman = document.createElement("linkman");
        // 4、创建一级父元素的子元素标签
        Element name = document.createElement("name");
        Element email = document.createElement("email");
        Element address = document.createElement("address");
        Element group = document.createElement("group");
        // 5、加入文本
        name.setTextContent("张三");
        email.setTextContent("17565481@qq.com");
        address.setTextContent("地球");
        group.setTextContent("实验室");
        // 6、将子元素作为父元素的子元素
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        // 7、将子元素作为跟元素的子元素
        documentElement.appendChild(linkman);
        // 8、同步操作
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File("F:\\JavaWeb\\day01\\resources\\contacts.xml"));
        transformer.transform(source, result);
    }
}
