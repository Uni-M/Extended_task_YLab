package parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import comparator.Comparator;

import static appconfig.constant.XConstant.*;

public class NodeParser extends DefaultHandler {

    private boolean isActiveNode = false;
    private Comparator comparator;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case ACTIVE_NODE -> isActiveNode = true;
            case INCLUDE_NODE -> comparator.setIsFile(checkIsFile(attributes));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case ACTIVE_NODE -> isActiveNode = false;
            case FOLDER_NODE -> comparator.closeDirectory();
        }
    }

    private boolean checkIsFile(Attributes attributes){
        return attributes.getValue(IS_FILE).equals(TRUE);
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if(isActiveNode){
            String child = new String(ch, start, length).trim();
            comparator.check(child);

            if (comparator.isCompare()){
                System.out.println(comparator.getDirectory() + child);
            }
        }
    }
}