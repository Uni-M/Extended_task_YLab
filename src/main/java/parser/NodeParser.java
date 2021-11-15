package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import comparator.Comparator;

import java.util.ArrayList;
import java.util.List;

import static appconfig.constant.XConstant.*;

public class NodeParser extends DefaultHandler {

    private static List<String> folders = new ArrayList<>();

    private String currentValue = "";
    private boolean isFile = false; //XML attribute (~~ is-file="true")
    private boolean isFolder = false;
    private Comparator filter;    //filter for printing


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equals(INCLUDE_NODE)) {
            if (attributes.getValue(IS_FILE).equals(TRUE)){
                isFile = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        switch (qName){
            case ACTIVE_NODE:
                if (!isFile) {
                    addFolderName();
                }
                break;
            case INCLUDE_NODE:
                if (isFile){
                    checkByFilter();
                }
                break;
            case FOLDER_NODE:
                if (folders.size() > 0){
                    folders.remove(folders.size()-1);
                }
                break;
            default:
                if(!qName.equals("node")) throw new IllegalStateException("Unexpected qName: " + qName);
        }
    }


    private void addFolderName(){
        if (!currentValue.equals(SPLIT_DIR)){
            folders.add(currentValue);
        }
        currentValue = "";
    }


    private void checkByFilter(){
        filter.compare(currentValue);
        isFile = false;
        currentValue = "";
    }

    public static List<String> getFolders(){
        return folders;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setComparator(Comparator comparator) {
        filter = comparator;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue += new String(ch, start, length).trim();
    }


}
