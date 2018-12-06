package com.sun.util;

import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DomUtil {


	public static boolean dom(InputStream in) {
        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(in);
            // 通过document对象获取根节点bookstore
            Element root = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
			Iterator it = root.elementIterator();
            // 遍历迭代器，获取根节点中的信息（书籍）
            while (it.hasNext()) {
                Element element = (Element) it.next();
                System.out.println(element.getName()+"======="+element.getStringValue());
                if(element.getName().equals("code") && element.getStringValue().equals("2")) {
                	return true;
                }
            }
            return false;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
	
}
