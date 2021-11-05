package xml_parser.comparator.search_type;

import xml_parser.comparator.AbstractComparator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static xml_parser.appconfig.constant.XConstant.APOSTROPHE1;

public class MaskType extends AbstractComparator {

    @Override
    public String printToConsole(String arg, String child) {

        String extension = findExtension(arg);
        final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child);

        if (matcher.find()) {
            return child;
        }
        return null;
    }


    private String findExtension (String arg){

        String argWithoutApostrophe = arg.replaceAll("^'+|'+(?!\\S)", "");

        String substring1 = argWithoutApostrophe.substring(argWithoutApostrophe.indexOf(APOSTROPHE1)+1, argWithoutApostrophe.indexOf("*"));
        String substring2 = argWithoutApostrophe.substring(argWithoutApostrophe.indexOf("*")+1, argWithoutApostrophe.length()-1);

        return substring1 + ".*?[ 0-9 a-f A-F ]{0,260}+" + substring2;
    }

}
