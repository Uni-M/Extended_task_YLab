package comparator;

import java.util.ArrayList;
import java.util.List;

import static appconfig.constant.XConstant.SPLIT_DIR;

public abstract class FileStore {

    private static List<String> folders = new ArrayList<>();
    private boolean isFile = false; //XML attribute (~~ is-file="true")
    private boolean isCompare = false;

    public void setIsFile(boolean file) {
        isFile = file;
    }

    public void check(String child) {
        if (!isFile) {
           addDirectory(child);
           isCompare = false;
        } else {
            isCompare = compare(child);
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

    public abstract boolean compare(String child);

    public boolean isCompare() {
        return isCompare;
    }
}
