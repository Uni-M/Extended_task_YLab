package xml_parser.print_info.serch_types;

import xml_parser.model.Node;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskType implements Type{
    @Override
    public void printToConsole(String arg, Node child) {

        String extension = arg.substring(2, arg.length()-1);
        final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child.getName());

        if (matcher.find()) {
            System.out.println(child.getName());
        }
    }
}
