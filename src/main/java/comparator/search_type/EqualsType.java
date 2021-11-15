package comparator.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;

public class EqualsType extends Comparator {
    @Override
    public String printToConsole(String child) {
        if (child.equals(ParameterStore.getMack())){
            return child;
        }
        return null;
    }
}
