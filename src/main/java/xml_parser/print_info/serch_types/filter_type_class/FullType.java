package xml_parser.print_info.serch_types.filter_type_class;

import xml_parser.model.Node;
import xml_parser.print_info.serch_types.Type;

public class FullType implements Type {

    @Override
    public void printToConsole(String arg, Node child) {
        System.out.println(child.getName());
    }
}
