package comparator.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularComparator extends Comparator {

    String regex = ParameterStore.getMask().replaceAll("^'+|'+(?!\\S)", "");
    private final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);

    @Override
    public boolean compare(String child) {
        Matcher matcher = pattern.matcher(child);
        return matcher.find();
    }
}
