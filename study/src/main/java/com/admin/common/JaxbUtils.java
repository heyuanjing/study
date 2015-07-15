package com.admin.common;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * xml与java之间的转换工具
 * @author frank
 *
 */
public class JaxbUtils {

    private JaxbUtils() {

    }
    
    /**
     * 将xml转换成java类对象
     * @param <T>
     * @param xml
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToObject(String xml, Class<T> type) {
        StringReader sr = new StringReader(xml);
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 将java类对象转换成xml对象
     * @param source
     * @return
     */
    public static String convertToXmlString(Object source) {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext jAXBContext = JAXBContext.newInstance(source.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.marshal(source, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
