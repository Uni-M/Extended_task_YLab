package xmlparser.parser;

import org.xml.sax.SAXException;
import xmlparser.AppConfig.argument_parser.ArgumentParser;
import xmlparser.AppConfig.exeptions.*;
import xmlparser.model.Root;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public Root parse(String[] args) throws ArgumentException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        NodeParser handler = new NodeParser();
        SAXParser parser;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e);
            return null;
        }

        ArgumentParser argumentParser = new ArgumentParser();
        argumentParser.ArgumentProcess(args);

        File file = new File(argumentParser.getInputFileName());

        try {
            parser.parse(file,handler);
        } catch (SAXException e) {
            System.out.println("sax parsing error " + e);
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error " + e);
            return null;
        }

        return handler.getRoot();
    }
}
