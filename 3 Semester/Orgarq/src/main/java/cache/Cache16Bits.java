package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache16Bits {

    private ArrayList<CacheLine> lines;
    private HashMap<String, String> associativeMemory;
    private int hit;
    private int miss;
    private int totalAttempts;

    public Cache16Bits() {
        this.hit = 0;
        this.miss = 0;
        this.totalAttempts = 0;
        associativeMemory = new HashMap<>();
        lines = new ArrayList<>();
        lines.add(new CacheLine("0000")); associativeMemory.put("0000","");
        lines.add(new CacheLine("0001")); associativeMemory.put("0001","");
        lines.add(new CacheLine("0010")); associativeMemory.put("0010","");
        lines.add(new CacheLine("0011")); associativeMemory.put("0011","");
        lines.add(new CacheLine("0100")); associativeMemory.put("0100","");
        lines.add(new CacheLine("0101")); associativeMemory.put("0101","");
        lines.add(new CacheLine("0110")); associativeMemory.put("0110","");
        lines.add(new CacheLine("0111")); associativeMemory.put("0111","");
        lines.add(new CacheLine("1000")); associativeMemory.put("1000","");
        lines.add(new CacheLine("1001")); associativeMemory.put("1001","");
        lines.add(new CacheLine("1010")); associativeMemory.put("1010","");
        lines.add(new CacheLine("1011")); associativeMemory.put("1011","");
        lines.add(new CacheLine("1100")); associativeMemory.put("1100","");
        lines.add(new CacheLine("1101")); associativeMemory.put("1101","");
        lines.add(new CacheLine("1110")); associativeMemory.put("1110","");
        lines.add(new CacheLine("1111")); associativeMemory.put("1111","");
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
                            System.out.println(cacheLine);
                        } else {
                            miss++;
                            totalAttempts++;
                            cacheLine.setTag(memorytag);
                            cacheLine.setHit(false);
                            cacheLine.setTargetWord(targetWord);
                            System.out.println(cacheLine);
                            for (String word:words) {
                                cacheLine.addWord(4,word);
                            }
                        }
                    }
                }
            } else {
                String[] words = {"00","01", "10", "11"};
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
                                cacheLine.addWord(4,s);
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