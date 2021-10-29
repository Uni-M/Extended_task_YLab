package xml_parser.print_info;

import xml_parser.model.Node;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Printer {

    public static void printToConsole(String[] args, List<Node> children){
        for (Node node : children) {
            String input = node.getName();
            String mArgument = args[args.length-1];


            if(args[args.length-2].equals("-s") || args[args.length-2].equals("-S")){   //if before the last argument the characters -s or -S are looking for a substring

                //MASK_TYPE
                if (mArgument.contains("*.")) {            //if argument contains "*." find look for files with the specified extension
                    String extension = mArgument.substring(2, mArgument.length()-1);
                    final Pattern pattern = Pattern.compile(extension, Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.find()) {
                        System.out.println(input);
                    }

                    //EQUALS_TYPE
                }else if (input.contains(args[args.length-1])){    //look if argument contains part if string or name of file
                    System.out.println(input);



                    //REGULAR_TYPE
                }else {         //look if argument is regular expression
                    String regex = mArgument.substring(1, mArgument.length()-1);
                    final Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
                    //final Pattern pattern = Pattern.compile(".*?[a-z]{4}-\d+\.[a-z]+",Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(input);
                    while (matcher.find()) {
                        System.out.println(input);
                    }
                }




                //FULL_TYPE
            }else {         //print all files
                System.out.println(input);
            }
        }
    }
}
