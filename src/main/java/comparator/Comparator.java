package comparator;

import static appconfig.constant.XConstant.SPLIT_DIR;
import static parser.NodeParser.getFolders;


public abstract class Comparator {
    private String mask;

    public void compare(String child){

        String resultOfFilter = printToConsole(child);
        if (resultOfFilter != null && resultOfFilter.length() > 0){
            System.out.print(SPLIT_DIR);
            for (String folder: getFolders()){
                System.out.print(folder + SPLIT_DIR);
            }
            System.out.println(resultOfFilter);
        }
    }

    protected abstract String printToConsole(String child);

    public void setMask(String mack){
        this.mask = mack;
    }
}
