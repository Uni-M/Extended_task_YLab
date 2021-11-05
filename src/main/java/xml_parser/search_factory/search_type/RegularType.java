package xml_parser.search_factory.search_type;

import xml_parser.search_factory.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static xml_parser.appconfig.constant.XConstant.*;

public class RegularType extends Type {

    @Override
    public String printToConsole(String arg, String child) {
        String regex = arg.substring(arg.indexOf(APOSTROPHE1)+1, arg.indexOf(APOSTROPHE2));
        final Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child);
        while (matcher.find()) {
            return child;
        }
        return null;
    }
}
