package appconfig.argument_parser;

import comparator.search_type.SearchType;
import static appconfig.constant.XConstant.*;
import static comparator.search_type.SearchType.*;

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

