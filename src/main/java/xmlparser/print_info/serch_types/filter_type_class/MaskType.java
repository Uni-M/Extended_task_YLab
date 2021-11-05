package xmlparser.print_info.serch_types.filter_type_class;

import xmlparser.model.Node;
import xmlparser.print_info.serch_types.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static xmlparser.AppConfig.XConstant.APOSTROPHE1;

public class MaskType implements Type {

    @Override
    public void printToConsole(String arg, Node child) {

        String extension = findExtension(arg);
        final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(child.getName());

        if (matcher.find()) {
            System.out.println(child.getName());
        }
    }


    private String findExtension (String arg){

        String argWithoutApostrophe = arg.replaceAll("^'+|'+(?!\\S)", "");

        String substring1 = argWithoutApostrophe.substring(argWithoutApostrophe.indexOf(APOSTROPHE1)+1, argWithoutApostrophe.indexOf("*"));
        String substring2 = argWithoutApostrophe.substring(argWithoutApostrophe.indexOf("*")+1, argWithoutApostrophe.length()-1);

        return substring1 + ".*?[ 0-9 a-f A-F ]{0,260}+" + substring2;
    }
}