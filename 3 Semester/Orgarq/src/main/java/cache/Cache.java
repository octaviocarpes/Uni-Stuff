package cache;

import reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cache {

    private ArrayList<MemoryLine> memoryLine;
    private HashMap<CacheLine,Words[]> cacheMap;
    private ArrayList<MemoryLine> hitMiss;


    public Cache() {
        this.memoryLine = new ArrayList<>();
        this.cacheMap = new HashMap<>();
        this.hitMiss = new ArrayList<>();
    }

    public void populateMemory(){
        Reader reader = new Reader();
        try {
            reader.getCacheMapping(memoryLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateCacheFromZero(){
        cacheMap.put(new CacheLine("0000"),new Words[4]);
        cacheMap.put(new CacheLine("0001"),new Words[4]);
        cacheMap.put(new CacheLine("0010"),new Words[4]);
        cacheMap.put(new CacheLine("0011"),new Words[4]);
        cacheMap.put(new CacheLine("0100"),new Words[4]);
        cacheMap.put(new CacheLine("0101"),new Words[4]);
        cacheMap.put(new CacheLine("0110"),new Words[4]);
        cacheMap.put(new CacheLine("0111"),new Words[4]);
        cacheMap.put(new CacheLine("1000"),new Words[4]);
        cacheMap.put(new CacheLine("1001"),new Words[4]);
        cacheMap.put(new CacheLine("1010"),new Words[4]);
        cacheMap.put(new CacheLine("1011"),new Words[4]);
        cacheMap.put(new CacheLine("1100"),new Words[4]);
        cacheMap.put(new CacheLine("1101"),new Words[4]);
        cacheMap.put(new CacheLine("1110"),new Words[4]);
        cacheMap.put(new CacheLine("1111"),new Words[4]);
    }

    public ArrayList<MemoryLine> getMemoryLine() {
        return memoryLine;
    }

    public void directMapping(){
        for (MemoryLine memoryLine:this.memoryLine
             ) {
            // TODO refactor implementation
        }
    }

    public HashMap<CacheLine, Words[]> getCacheMap() {
        return cacheMap;
    }

}
