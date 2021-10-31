package xml_parser.print_info.serch_types.filter_type_class;

import xml_parser.model.Node;
import xml_parser.print_info.serch_types.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static xml_parser.AppConfig.XConstant.APOSTROPHE1;
import static xml_parser.AppConfig.XConstant.APOSTROPHE2;

public class MaskType implements Type {
    @Override
    public void printToConsole(String arg, Node child) {

        String extension = arg.substring(arg.indexOf(APOSTROPHE1), arg.indexOf(APOSTROPHE2));
        final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child.getName());

        if (matcher.find()) {
            System.out.println(child.getName());
        }
    }
}