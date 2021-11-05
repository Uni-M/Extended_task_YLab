package xmlparser.print_info.serch_types.filter_type_class;

import xmlparser.model.Node;
import xmlparser.print_info.serch_types.Type;

public class EqualsType implements Type {

    @Override
    public void printToConsole(String arg, Node child) {
        if (child.getName().contains(arg)){
            System.out.println(child.getName());
        }
    }
}
