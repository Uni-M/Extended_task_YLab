package xml_parser.search_factory;

import xml_parser.parser.NodeParser;

import java.util.List;

import static xml_parser.appconfig.constant.XConstant.SPLIT_DIR;

public abstract class Type {

    public void checkAllNodes(String arg, String node){

        List <String> folders = NodeParser.getFolders();

        String resultOfFilter = printToConsole(arg, node);
        if (resultOfFilter != null && resultOfFilter.length() > 0){
            System.out.print(SPLIT_DIR);
            for (String folder: folders){
                System.out.print(folder + SPLIT_DIR);
            }
            System.out.println(resultOfFilter);
        }
    }

    protected abstract String printToConsole(String arg, String child);
}
