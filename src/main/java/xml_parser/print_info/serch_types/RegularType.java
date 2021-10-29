package xml_parser.print_info.serch_types;

import xml_parser.model.Node;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularType implements Type{
    @Override
    public void printToConsole(String arg, Node child) {
        String regex = arg.substring(1, arg.length()-1);
        final Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
        //final Pattern pattern = Pattern.compile(".*?[a-z]{4}-\d+\.[a-z]+",Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child.getName());
        while (matcher.find()) {
            System.out.println(child.getName());
        }
    }
}
