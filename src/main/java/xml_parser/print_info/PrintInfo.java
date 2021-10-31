package xml_parser.print_info;

import xml_parser.appConfig.argument_parser.ArgumentParser;
import xml_parser.appConfig.argument_parser.FinderArgForFilter;
import xml_parser.model.Node;
import xml_parser.print_info.serch_types.*;

import java.util.List;

public class PrintInfo {

    private static final FinderArgForFilter faff = new FinderArgForFilter();
    private static final SearchType searchType = faff.argumentForPrinting();

    private static final ArgumentParser argumentParser = new ArgumentParser();
    private static final String stringToFilter = argumentParser.getStringToFilter();


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
