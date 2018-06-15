package cache;

import java.util.ArrayList;

public class CacheLine {

    private String line;
    private String tag;
    private String[] words;
    private String targetWord;
    private boolean hit;

    public CacheLine(String line) {
        this.line = line;
        this.tag = "";
        this.targetWord = "";
        this.words = new String[4];
        this.hit = false;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public String[] getWords() {
        return words;
    }



    public String getTargetWord() {
        return targetWord;
    }

    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }

    @Override
    public String toString() {
        String hitstring = "";
        if (hit == false){
            hitstring = "Miss!";
        } else {
            hitstring = "Hit!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < words.length ; i++) {
            sb.append(words[i]);
            sb.append(",");
        }
        sb.append(" ]");
        return "Tag: " + tag + " - " + "Line: "+ line + " - "+ "Data Chunk: " + sb.toString() + " - " + " : " + targetWord + " - " + hitstring;
    }
}
