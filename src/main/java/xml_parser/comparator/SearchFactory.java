package xml_parser.comparator;

import xml_parser.comparator.search_type.*;

public class SearchFactory {

    public AbstractComparator create(SearchType filter){
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
            default -> throw new IllegalStateException("Unexpected type: " + filter);
        }
    }
}
