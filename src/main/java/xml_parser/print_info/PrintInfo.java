package xml_parser.print_info;

import xml_parser.AppConfig.argument_parser.ArgumentParser;
import xml_parser.model.Node;
import xml_parser.print_info.serch_types.*;
import static xml_parser.AppConfig.argument_parser.FinderArgForFilter.argumentForPrinting;

import java.util.List;


public class PrintInfo {

    public static void printToConsole(List<Node> children) {

        SearchType searchType = argumentForPrinting();
        String stringToFilter = ArgumentParser.getStringToFilter();

        switch (searchType){

            case Regular:              //create class regular_type
                RegularType regularType = new RegularType();
                regularType.checkAllNodes(stringToFilter, children);
                break;

            case Mask:                  //create class mask_type
                MaskType maskType = new MaskType();
                maskType.checkAllNodes(stringToFilter, children);
                break;

            case Equals:                // create class equals_type
                EqualsType equalsType = new EqualsType();
                equalsType.checkAllNodes(stringToFilter,children);
                break;

            case Full:                   //create class full_type
                FullType fullType = new FullType();
                fullType.checkAllNodes(stringToFilter, children);
        }
    }
}
