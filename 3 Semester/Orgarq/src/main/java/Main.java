import cache.Cache;
import memory.Memory;
import reader.Reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Memory memory = new Memory();

        try {
            reader.getCacheMapping(memory.getMemory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Memory Addresses");
        System.out.println();

        for (String s: memory.getMemory()
             ) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Direct Mapping");
        System.out.println();

        Cache cache = new Cache();

        cache.directMapping(memory.getMemory());
        System.out.println();
        System.out.println("Total Attempts: " + cache.getTotalAttempts());
        System.out.println("Hits: " + cache.getHit());
        System.out.println("Misses: " + cache.getMiss());
    }
}
