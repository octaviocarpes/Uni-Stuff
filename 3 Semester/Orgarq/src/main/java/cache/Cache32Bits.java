package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache32Bits {
    private ArrayList<CacheLine> lines;
    private int hit;
    private int miss;
    private int totalAttempts;
    private HashMap<String, String> associativeMemory;

    public Cache32Bits() {
        this.hit = 0;
        this.miss = 0;
        this.totalAttempts = 0;
        associativeMemory = new HashMap<>();
        lines = new ArrayList<>();
        lines.add(new CacheLine("00000"));
        lines.add(new CacheLine("00001"));
        lines.add(new CacheLine("00010"));
        lines.add(new CacheLine("00011"));
        lines.add(new CacheLine("00100"));
        lines.add(new CacheLine("00101"));
        lines.add(new CacheLine("00110"));
        lines.add(new CacheLine("00111"));
        lines.add(new CacheLine("01000"));
        lines.add(new CacheLine("01001"));
        lines.add(new CacheLine("01010"));
        lines.add(new CacheLine("01011"));
        lines.add(new CacheLine("01100"));
        lines.add(new CacheLine("01101"));
        lines.add(new CacheLine("01110"));
        lines.add(new CacheLine("01111"));
        lines.add(new CacheLine("10000"));
        lines.add(new CacheLine("10001"));
        lines.add(new CacheLine("10010"));
        lines.add(new CacheLine("10011"));
        lines.add(new CacheLine("10100"));
        lines.add(new CacheLine("10101"));
        lines.add(new CacheLine("10110"));
        lines.add(new CacheLine("10111"));
        lines.add(new CacheLine("11000"));
        lines.add(new CacheLine("11001"));
        lines.add(new CacheLine("11010"));
        lines.add(new CacheLine("11011"));
        lines.add(new CacheLine("11100"));
        lines.add(new CacheLine("11101"));
        lines.add(new CacheLine("11110"));
        lines.add(new CacheLine("11111"));
    }

    public void directMapping(List<String> memory){

    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getMiss() {
        return miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public void setTotalAttempts(int totalAttempts) {
        this.totalAttempts = totalAttempts;
    }
}
