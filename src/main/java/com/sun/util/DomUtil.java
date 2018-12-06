package com.sun.util;

import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DomUtil {


	public static boolean dom(InputStream in) {
        // ����books.xml�ļ�
        // ����SAXReader�Ķ���reader
        SAXReader reader = new SAXReader();
        try {
            // ͨ��reader�����read��������books.xml�ļ�,��ȡdocuemnt����
            Document document = reader.read(in);
            // ͨ��document�����ȡ���ڵ�bookstore
            Element root = document.getRootElement();
            // ͨ��element�����elementIterator������ȡ������
			Iterator it = root.elementIterator();
            // ��������������ȡ���ڵ��е���Ϣ���鼮��
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
