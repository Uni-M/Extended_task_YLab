package comparator.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskComparator extends Comparator {

    String extension = findExtension(ParameterStore.getMask().replaceAll("^'+|'+(?!\\S)", ""));
    private final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);

    @Override
    public boolean compare(String child) {
        Matcher matcher = pattern.matcher(child);
        return matcher.find();
    }

    private String findExtension(String arg) {

        StringBuilder extension = new StringBuilder();

        char[] chars = arg.toCharArray();
        for (char ch : chars) {
            switch (ch) {
                case '.' -> {
                    extension.append("\\.");
                }
                case '*' -> {
                    extension.append(".*");
                }
                default -> extension.append(ch);
            }
        }

        return extension.toString();
    }
}
