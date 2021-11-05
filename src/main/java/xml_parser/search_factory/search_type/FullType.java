package xml_parser.search_factory.search_type;

import xml_parser.search_factory.Type;

public class FullType extends Type {

    @Override
    public String printToConsole(String arg, String child) {
        return child;
    }
}
