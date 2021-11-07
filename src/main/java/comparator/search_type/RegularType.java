package comparator.search_type;

import comparator.AbstractComparator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularType extends AbstractComparator {

    @Override
    public String printToConsole(String arg, String child) {
        String regex = arg.replaceAll("^'+|'+(?!\\S)", "");
        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child);
        if (matcher.find()) {
            return child;
        }
        return null;
    }
}
