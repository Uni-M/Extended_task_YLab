package xml_parser;

import xml_parser.exeption.ArgumentException;
import xml_parser.parser.SaxParser;

public class Main {
    public static void main(String[] args) throws ArgumentException {
        SaxParser parser = new SaxParser();
        parser.parse(args);
    }
}
