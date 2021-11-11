package comparator.search_type;

import comparator.AbstractComparator;

public class EqualsType extends AbstractComparator {
    @Override
    public String printToConsole(String arg, String child) {
        if (child.equals(arg)){
            return child;
        }
        return null;
    }
}
