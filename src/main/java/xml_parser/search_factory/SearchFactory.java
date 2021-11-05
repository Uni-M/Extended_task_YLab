package xml_parser.search_factory;

import xml_parser.appconfig.argument_parser.FinderArgForFilter;
import xml_parser.search_factory.search_type.*;

public class SearchFactory {

    SearchType filter = FinderArgForFilter.argumentForPrinting();

    public Type create(){
        switch (filter){
            case Regular -> {              //create class regular_type
                return new RegularType();
            }
            case Mask -> {                  //create class mask_type
                return new MaskType();
            }
            case Equals -> {                // create class equals_type
                return new EqualsType();
            }
            case Full -> {                   //create class full_type
                return new FullType();
            }
        }
        return null;
    }
}
