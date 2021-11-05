package xmlparser.model;

import xmlparser.print_info.PrintInfo;

import java.util.List;

public class Root {

    // List to hold Node objects
    private List<Node> children;

    public List<Node> getChild() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void printByFilter(){
        PrintInfo.printToConsole(getChild());
    }
}
