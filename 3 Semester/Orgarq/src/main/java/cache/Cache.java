package cache;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private ArrayList<CacheLine> lines;
    private int hit;
    private int miss;
    private int totalAttempts;

    public Cache() {
        this.hit = 0;
        this.miss = 0;
        this.totalAttempts = 0;
        lines = new ArrayList<>();
        lines.add(new CacheLine("0000"));
        lines.add(new CacheLine("0001"));
        lines.add(new CacheLine("0010"));
        lines.add(new CacheLine("0011"));
        lines.add(new CacheLine("0100"));
        lines.add(new CacheLine("0101"));
        lines.add(new CacheLine("0110"));
        lines.add(new CacheLine("0111"));
        lines.add(new CacheLine("1000"));
        lines.add(new CacheLine("1001"));
        lines.add(new CacheLine("1010"));
        lines.add(new CacheLine("1011"));
        lines.add(new CacheLine("1100"));
        lines.add(new CacheLine("1101"));
        lines.add(new CacheLine("1110"));
        lines.add(new CacheLine("1111"));
    }

    public void directMapping(List<String> memory){
        for (String address: memory) {
            if (address.length() <= 22){
                String[] memoryAdress = address.split(" - ");
                String memorytag = memoryAdress[0];
                String memoryline = memoryAdress[1];
                String targetWord = memoryAdress[2];
                String[] words = {"00","01","10","11"};

                for (CacheLine cacheLine: lines) {
                    if (cacheLine.getLine().equals(memoryline)){
                        if (cacheLine.getTag().equals(memorytag)){
                            hit++;
                            totalAttempts++;
                            cacheLine.setHit(true);
                            cacheLine.setTargetWord(targetWord);
                            for (String word:words
                                 ) {
                                cacheLine.addWord(word);
                            }
                            System.out.println(cacheLine);
                        } else {
                            miss++;
                            totalAttempts++;
                            cacheLine.setTag(memorytag);
                            cacheLine.setHit(false);
                            cacheLine.setTargetWord(targetWord);
                            for (String word:words
                                    ) {
                                cacheLine.addWord(word);
                            }
                            System.out.println(cacheLine);
                        }
                    }
                }
            } else {
                String[]memoryAddress = address.split(" : ");
//                String cacheAddress
//                TODO: Finish implementing direct mapping
            }
        }
    }

    private void mapping(String address){

    }

    private void loadStoreMapping(String address){

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