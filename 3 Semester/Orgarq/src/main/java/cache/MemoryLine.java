package cache;

public class MemoryLine {

    private String tag;
    private String line;
    private String word;

    public MemoryLine(String tag, String line, String word) {
        this.tag = tag;
        this.line = line;
        this.word = word;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return tag + " - " + line + " - " + word;
    }
}
