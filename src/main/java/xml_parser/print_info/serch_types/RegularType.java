package xml_parser.print_info.serch_types;

import xml_parser.model.Node;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static xml_parser.AppConfig.XConstant.APOSTROPHE1;
import static xml_parser.AppConfig.XConstant.APOSTROPHE2;

public class RegularType implements Type{
    @Override
    public void printToConsole(String arg, Node child) {
        String regex = arg.substring(arg.indexOf(APOSTROPHE1)+1, arg.indexOf(APOSTROPHE2));
        final Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child.getName());
        while (matcher.find()) {
            System.out.println(child.getName());
        }
    }
}