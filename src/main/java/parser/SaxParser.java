package parser;

import comparator.Comparator;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public SaxParser(Comparator comparator, String inputFileName){

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);

        NodeParser handler = new NodeParser();
        handler.setComparator(comparator);

        SAXParser parser;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e);
            return;
        }

        try {
            parser.parse(new File(inputFileName),handler);
        } catch (SAXException e) {
            System.out.println("sax parsing error " + e);
        } catch (IOException e) {
            System.out.println("IO parsing error " + e);
        }
    }
}

