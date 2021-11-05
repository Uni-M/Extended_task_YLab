package xml_parser.appconfig.argument_parser;

import xml_parser.search_factory.SearchType;
import static xml_parser.appconfig.constant.XConstant.*;
import static xml_parser.search_factory.SearchType.*;

public class FinderArgForFilter {

    private static final String typeOfFilter = ArgumentParser.getTypeOfFilter();
    private static final String stringToFilter = ArgumentParser.getStringToFilter();


    public static SearchType argumentForPrinting(){

        switch (typeOfFilter){

            case KEY_MACK_REGULAR:               //create class regular_type
                return Regular;
            case KEY_MACK:
                if (stringToFilter.contains("*")){        //if argument contains "*" find look for files with the specified extension
                    return Mask;
                }
                else {
                    return Equals;
                }
            default:
                return Full;
        }
    }
}

