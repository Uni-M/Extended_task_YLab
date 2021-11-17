package comparator;


public abstract class Comparator extends FileStore{
    private String mask;

    public void setMask(String mask){
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }

    public abstract boolean compare(String child);
}
