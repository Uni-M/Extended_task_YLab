package comparator.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularType extends Comparator {

    String regex = ParameterStore.getMack().replaceAll("^'+|'+(?!\\S)", "");
    private final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);

    @Override
    public String printToConsole(String child) {
        Matcher matcher = pattern.matcher(child);
        if (matcher.find()) {
            return child;
        }
        return null;
    }
}
