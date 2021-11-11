package comparator;

import comparator.search_type.*;

public class SearchFactory {

    public AbstractComparator create(SearchType filter){
        switch (filter){
            case Regular -> { return new RegularType(); }  //create class regular_type
            case Mask    -> { return new MaskType();    }  //create class mask_type
            case Equals  -> { return new EqualsType();  }  // create class equals_type
            case Full    -> { return new FullType();    }  //create class full_type
            default -> throw new IllegalStateException("Unexpected type: " + filter);
        }
    }
}
