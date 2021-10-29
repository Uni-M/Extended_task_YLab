package xml_parser;

import xml_parser.AppConfig.exeptions.*;
import xml_parser.model.Root;
import xml_parser.parser.SaxParser;

public class Main {
    public static void main(String[] args) throws ArgumentException {

        SaxParser parser = new SaxParser();

        Root root = parser.parse(args);
        root.printByFilter();
    }
}
