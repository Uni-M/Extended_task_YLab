package parser;

import appconfig.argument_parser.ParameterStore;
import exception.ArgumentException;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public void parse(String[] args) throws ArgumentException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);

        NodeParser handler = new NodeParser();
        SAXParser parser;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e);
            return;
        }


        File file = new File(ParameterStore.getInputFileName());

        try {
            parser.parse(file,handler);
        } catch (SAXException e) {
            System.out.println("sax parsing error " + e);
        } catch (IOException e) {
            System.out.println("IO parsing error " + e);
        }
    }
}

