package xml_parser.print_info.serch_types;

import xml_parser.model.Node;

public class FullType implements Type{

    @Override
    public void printToConsole(String arg, Node child) {
        System.out.println(child.getName());
    }
}
