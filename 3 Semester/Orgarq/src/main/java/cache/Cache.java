package cache;

import reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cache {

    private ArrayList<MemoryLine> memoryLine;
    private HashMap<CacheLine,Words[]> cacheMap;
    private ArrayList<String> sixteenBits;

    public Cache() {
        this.memoryLine = new ArrayList<>();
        this.cacheMap = new HashMap<>();
        this.sixteenBits = new ArrayList<>();
    }

    public void populateMemory(){
        Reader reader = new Reader();
        try {
            reader.getCacheMapping(memoryLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MemoryLine> getMemoryLine() {
        return memoryLine;
    }

    public HashMap<CacheLine, Words[]> getCacheMap() {
        return cacheMap;
    }

}
