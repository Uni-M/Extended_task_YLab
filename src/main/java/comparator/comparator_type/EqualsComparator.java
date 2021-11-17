package comparator.comparator_type;

import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;

public class EqualsComparator extends Comparator {
    @Override
    public boolean compare(String child) {
        return child.equals(ParameterStore.getMask());
    }
}
