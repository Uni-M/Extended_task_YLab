package comparator.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskType extends Comparator {

    String extension = findExtension(ParameterStore.getMack().replaceAll("^'+'+(?!\\S)", ""));
    private final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);

    @Override
    public String printToConsole(String child) {

        Matcher matcher = pattern.matcher(child);

        if (matcher.find()) {
            return child;
        }
        return null;
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
