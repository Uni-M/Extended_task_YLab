package comparator;

import java.util.ArrayList;
import java.util.List;

import static appconfig.constant.XConstant.SPLIT_DIR;

public class FileStore {

    private static List<String> folders = new ArrayList<>();
    private boolean isFile = false; //XML attribute (~~ is-file="true")

    public void setIsFile(boolean file) {
        isFile = file;
    }

    public boolean isFile(){
        return isFile;
    }

    public void check(String child, boolean isCompare) {
        if (!isFile) {
           addDirectory(child);
        }else if(isCompare){
            System.out.println(getDirectory() + child);
        }
    }

    private void addDirectory(String child){
        folders.add(folders.size() < 1 ? child : child + SPLIT_DIR);
    }

    public String getDirectory() {
        return String.join("", folders);
    }

    public void closeDirectory(){
        if (folders.size() > 0){
            folders.remove(folders.size()-1);
        }
    }
}
