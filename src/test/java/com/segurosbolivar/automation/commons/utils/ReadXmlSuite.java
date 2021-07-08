package com.segurosbolivar.automation.commons.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXmlSuite {

    private static String path;

    public static Integer getSuiteId(String path) throws Exception {
        ReadXmlSuite.path = path;
        Document doc = ReadXmlSuite.loadXmlSuite(path);
        NodeList list = doc.getElementsByTagName("suite");
        Node node = list.item(0);
        Element element = (Element) node;
        return checkSuiteId(element.getAttribute("id"));
    }

    private static Integer checkSuiteId(String id) throws Exception {

        if (id.isEmpty()) {
            throw new Exception("Please provide not empty id to suite tag  in " + path);
        }

        try {
            return Integer.parseInt(id);

        } catch (NumberFormatException ex) {
            throw new Exception("Please provide a numeric id to suite tag  in " + path + " Error: " + ex.getMessage());
        }
    }

    private static Document loadXmlSuite(String path) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            dbf.setValidating(false);
            dbf.setNamespaceAware(true);
            dbf.setFeature("http://xml.org/sax/features/namespaces", false);
            dbf.setFeature("http://xml.org/sax/features/validation", false);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(path));
            doc.getDocumentElement().normalize();
            return doc;
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException ex) {
            throw new Exception(ex);
        }
    }
}
