package xmlparser.model;

public class Node {

    private String Name; //XML element (~~ file-77194797.xmml)

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return this.Name;
    }

}
