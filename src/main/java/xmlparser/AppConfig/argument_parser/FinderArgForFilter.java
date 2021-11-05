package xmlparser.AppConfig.argument_parser;

import xmlparser.print_info.serch_types.SearchType;

import static xmlparser.AppConfig.XConstant.KEY_MACK;
import static xmlparser.AppConfig.XConstant.KEY_MACK_REGULAR;


public class FinderArgForFilter {

    private static final String typeOfFilter = ArgumentParser.getTypeOfFilter();
    private static final String stringToFilter = ArgumentParser.getStringToFilter();


    public static SearchType argumentForPrinting(){

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
