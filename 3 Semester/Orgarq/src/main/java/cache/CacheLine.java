package cache;

public class CacheLine {

    private String tag;
    private String line;
    private boolean hit;

    public CacheLine(String line) {
        this.line = line;
        this.hit = false;
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

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
