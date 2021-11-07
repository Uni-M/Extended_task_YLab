package comparator.search_type;

import comparator.AbstractComparator;

public class EqualsType extends AbstractComparator {
    @Override
    public String printToConsole(String arg, String child) {
        if (child.contains(arg)){
            return child;
        }
        return null;
    }
}
