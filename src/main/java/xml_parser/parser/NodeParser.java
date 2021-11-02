package xml_parser.parser;

import xml_parser.model.Node;
import xml_parser.model.Root;
import static xml_parser.AppConfig.XConstant.*;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class NodeParser extends DefaultHandler {

    Root root = new Root();

    private List<Node> children = new ArrayList<>();

    private String currentValue = "";
    private ArrayList<String> fileInDirectory = new ArrayList<>();

    private static boolean isFile = false; //XML attribute (~~ is-file="true")

    public Root getRoot(){
        return root;
    }

    @Override
    public void endDocument() {
        root.setChildren(children);
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
                addFolderName();
                break;
            case INCLUDE_NODE:
                if (isFile == true){
                    addFileName();
                }
                break;
            case FOLDER_NODE:
                if (fileInDirectory.size() > 0){
                    fileInDirectory.remove(fileInDirectory.size()-1);
                }
        }
    }


    private void addFolderName(){
        if (!currentValue.equals(SPLIT_DIR)){
            fileInDirectory.add(currentValue);
        }
        currentValue = "";
    }


    private void addFileName(){
        Node node = new Node();
        StringBuilder fname = new StringBuilder();

        for (String s : fileInDirectory) {
            fname.append(SPLIT_DIR).append(s);
        }
        node.setName(fname.toString());
        children.add(node);
        isFile = false;
        fileInDirectory.remove(fileInDirectory.size()-1);
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue += new String(ch, start, length).trim();
    }
}
