package xml_parser.parser;

import org.xml.sax.SAXException;
import xml_parser.appconfig.argument_parser.ArgumentParser;
import xml_parser.exeption.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public void parse(String[] args) throws ArgumentException {

        ArgumentParser argumentParser = new ArgumentParser();
        argumentParser.argumentProcess(args);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        NodeParser handler = new NodeParser();
        SAXParser parser;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e);
            return;
        }


        File file = new File(argumentParser.getInputFileName());

        try {
            parser.parse(file,handler);
        } catch (SAXException e) {
            System.out.println("sax parsing error " + e);
        } catch (IOException e) {
            System.out.println("IO parsing error " + e);
        }
    }
}

