package xml_parser.print_info.serch_types;

import xml_parser.model.Node;

import java.util.List;

public interface Type {

    default void checkAllNodes(String arg, List<Node> children){
        for (Node node : children){
            printToConsole(arg, node);
        }
    }

    void printToConsole(String arg, Node child);
}
