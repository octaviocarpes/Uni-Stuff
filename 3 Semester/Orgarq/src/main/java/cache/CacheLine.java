package cache;

import java.util.ArrayList;

public class CacheLine {

    private String line;
    private String tag;
    private ArrayList<String> words;
    private String targetWord;
    private boolean hit;

    public CacheLine(String line) {
        this.line = line;
        this.tag = "";
        this.targetWord = "";
        this.words = new ArrayList<>();
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

    public ArrayList<String> getWords() {
        return words;
    }

    public void addWord(String word){
        if (words.size() < 4){
            words.add(word);
        }
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
        return "Tag: " + tag + " - " + "Line: "+ line + " - "+ "Data Chunk: " + words + " - " + " : " + targetWord + " - " + hitstring;
    }
}
