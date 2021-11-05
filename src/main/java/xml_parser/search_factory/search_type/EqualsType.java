package xml_parser.search_factory.search_type;

import xml_parser.search_factory.Type;

public class EqualsType extends Type {
    @Override
    public String printToConsole(String arg, String child) {
        if (child.contains(arg)){
            return child;
        }
        return null;
    }
}
