package xml_parser.appConfig.argument_parser;

import xml_parser.print_info.serch_types.SearchType;

import static xml_parser.appConfig.XConstant.KEY_MACK;
import static xml_parser.appConfig.XConstant.KEY_MACK_REGULAR;


public class FinderArgForFilter {

    ArgumentParser argumentParser = new ArgumentParser();

    private final String typeOfFilter = argumentParser.getTypeOfFilter();
    private final String stringToFilter = argumentParser.getStringToFilter();


    public SearchType argumentForPrinting(){

        switch (typeOfFilter){

            case KEY_MACK_REGULAR:               //create class regular_type
                return SearchType.Regular;
            case KEY_MACK:
                if (stringToFilter.contains("*.")){        //if argument contains "*." find look for files with the specified extension
                    return SearchType.Mask;
                }
                else {
                    return SearchType.Equals;
                }
            default:
                return SearchType.Full;
        }
    }
}
