package xmlparser;

import xmlparser.AppConfig.exeptions.*;
import xmlparser.model.Root;
import xmlparser.parser.SaxParser;

public class Main {
    public static void main(String[] args) throws ArgumentException {

        SaxParser parser = new SaxParser();

        Root root = parser.parse(args);
        root.printByFilter();
    }
}
