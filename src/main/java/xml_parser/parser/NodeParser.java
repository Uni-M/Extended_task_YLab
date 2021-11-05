package xml_parser.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import xml_parser.appconfig.argument_parser.ArgumentParser;
import xml_parser.comparator.SearchFactory;
import xml_parser.comparator.AbstractComparator;

import java.util.ArrayList;
import java.util.List;

import static xml_parser.appconfig.argument_parser.FinderArgForFilter.argumentForPrinting;
import static xml_parser.appconfig.constant.XConstant.*;

public class NodeParser extends DefaultHandler {

    private static List<String> folders = new ArrayList<>();

    private String currentValue = "";
    private static boolean isFile = false; //XML attribute (~~ is-file="true")
    AbstractComparator filter;    //filter for printing

    @Override
    public void startDocument() {
        SearchFactory searchFactory = new SearchFactory();
        filter = searchFactory.create(argumentForPrinting());
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
        }
    }


    private void addFolderName(){
        if (!currentValue.equals(SPLIT_DIR)){
            folders.add(currentValue);
        }
        currentValue = "";
    }


    private void checkByFilter(){
        filter.compareFileName(ArgumentParser.getStringToFilter(), currentValue);
        isFile = false;
        currentValue = "";
    }

    public static List<String> getFolders(){
        return folders;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue += new String(ch, start, length).trim();
    }
}
