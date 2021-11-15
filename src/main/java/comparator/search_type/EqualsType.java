package comparator.search_type;

import comparator.Comparator;

public class EqualsType extends Comparator {
    @Override
    public String printToConsole(String arg, String child) {
        if (child.equals(arg)){
            return child;
        }
        return null;
    }
}
