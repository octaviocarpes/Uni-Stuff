package cache;

import java.util.ArrayList;
import java.util.List;

public class Cache32Bits {
    private ArrayList<CacheLine> lines;
    private int hit;
    private int miss;
    private int totalAttempts;

    public Cache32Bits() {
        this.hit = 0;
        this.miss = 0;
        this.totalAttempts = 0;
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
        for (String address: memory) {
            if (address.length() <= 22){
                String[] memoryAdress = address.split(" - ");
                String memorytag = memoryAdress[0];
                String memoryline = memoryAdress[1];
                String targetWord = memoryAdress[2];
                String[] words = {"0","1"};

                for (CacheLine cacheLine: lines) {
                    if (cacheLine.getLine().equals(memoryline)){
                        if (cacheLine.getTag().equals(memorytag)){
                            hit++;
                            totalAttempts++;
                            cacheLine.setHit(true);
                            cacheLine.setTargetWord(targetWord);
                            System.out.println(cacheLine);
                        } else {
                            miss++;
                            totalAttempts++;
                            cacheLine.setTag(memorytag);
                            cacheLine.setHit(false);
                            cacheLine.setTargetWord(targetWord);
                            System.out.println(cacheLine);
                            for (String word:words) {
                                cacheLine.addWord(2,word);
                            }
                        }
                    }
                }
            } else {
                String[] words = {"0","1"};
                String[]memoryAddress = address.split(" : ");
                String cacheAddress = memoryAddress[1];
                String[] cacheData = cacheAddress.split(" - ");
                String tag = cacheData[0];
                String line = cacheData[1];
                String word = cacheData[2];
                for (CacheLine cacheLine:lines) {
                    if (cacheLine.getLine().equals(line)){
                        if (cacheLine.getTag().equals(tag)){
                            hit++;
                            hit++;
                            totalAttempts++;
                            cacheLine.setHit(true);
                            cacheLine.setTargetWord(word);
                            System.out.println(cacheLine);
                        } else {
                            miss++;
                            totalAttempts++;
                            cacheLine.setTag(tag);
                            cacheLine.setHit(false);
                            System.out.println(cacheLine);
                            for (String s: words) {
                                cacheLine.addWord(2,s);
                            }
                        }
                    }
                }

            }
        }
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
