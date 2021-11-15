package parser;

import comparator.Comparator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public SaxParser(Comparator comparator, String inputFileName) throws IOException, SAXException, ParserConfigurationException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);

        NodeParser handler = new NodeParser();
        handler.setComparator(comparator);

        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(inputFileName), handler);
    }
}