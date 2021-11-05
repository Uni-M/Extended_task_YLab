package xmlparser.print_info;

import xmlparser.AppConfig.argument_parser.ArgumentParser;
import static xmlparser.AppConfig.argument_parser.FinderArgForFilter.argumentForPrinting;
import xmlparser.model.Node;
import xmlparser.print_info.serch_types.*;
import xmlparser.print_info.serch_types.filter_type_class.EqualsType;
import xmlparser.print_info.serch_types.filter_type_class.FullType;
import xmlparser.print_info.serch_types.filter_type_class.MaskType;
import xmlparser.print_info.serch_types.filter_type_class.RegularType;

import java.util.List;

public class PrintInfo {

    static SearchType searchType = argumentForPrinting();
    static String stringToFilter = ArgumentParser.getStringToFilter();

    public static void printToConsole(List<Node> children) {

        switch (searchType) {
            case Regular -> {              //create class regular_type
                RegularType regularType = new RegularType();
                regularType.checkAllNodes(stringToFilter, children);
            }
            case Mask -> {                  //create class mask_type
                MaskType maskType = new MaskType();
                maskType.checkAllNodes(stringToFilter, children);
            }
            case Equals -> {                // create class equals_type
                EqualsType equalsType = new EqualsType();
                equalsType.checkAllNodes(stringToFilter, children);
            }
            case Full -> {                   //create class full_type
                FullType fullType = new FullType();
                fullType.checkAllNodes(stringToFilter, children);
            }
        }
    }
}
