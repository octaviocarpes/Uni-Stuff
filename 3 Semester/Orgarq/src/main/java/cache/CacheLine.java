package cache;

public class CacheLine {

    private String tag;
    private String line;

    public CacheLine(String tag, String line) {
        this.tag = tag;
        this.line = line;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
