package xml_parser.print_info.serch_types;

import xml_parser.model.Node;

public class EqualsType implements Type{

    @Override
    public void printToConsole(String arg, Node child) {
        if (child.getName().contains(arg)){
            System.out.println(child.getName());
        }
    }
}
