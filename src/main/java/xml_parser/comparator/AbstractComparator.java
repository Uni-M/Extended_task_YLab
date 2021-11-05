package xml_parser.comparator;

import java.util.List;

import static xml_parser.appconfig.constant.XConstant.SPLIT_DIR;
import static xml_parser.parser.NodeParser.getFolders;


public abstract class AbstractComparator {

    public void compareFileName(String arg, String fileName){

        String resultOfFilter = printToConsole(arg, fileName);
        if (resultOfFilter != null && resultOfFilter.length() > 0){
            System.out.print(SPLIT_DIR);
            for (String folder: getFolders()){
                System.out.print(folder + SPLIT_DIR);
            }
            System.out.println(resultOfFilter);
        }
    }

    protected abstract String printToConsole(String arg, String child);
}
