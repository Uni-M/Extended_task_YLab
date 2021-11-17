package comparator;

import appconfig.constant.SearchType;
import comparator.comparator_type.*;

public class FactoryMethod {

    public Comparator create(SearchType filter){
        switch (filter){
            case Regular -> { return new RegularComparator(); }  //create class regular_type
            case Mask    -> { return new MaskComparator();    }  //create class mask_type
            case Equals  -> { return new EqualsComparator();  }  // create class equals_type
            case Full    -> { return new FullComparator();    }  //create class full_type
            default -> throw new IllegalStateException("Unexpected type: " + filter);
        }
    }
}
