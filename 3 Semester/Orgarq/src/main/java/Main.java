import cache.Cache16Bits;
import cache.Cache32Bits;
import memory.Memory;
import reader.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Memory memory1 = new Memory();

        try {
            reader.getCacheMappingQuestionOne(memory1.getMemory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Memory Addresses");
        System.out.println();

        for (String s: memory1.getMemory()
             ) {
            System.out.println(s);
        }

        Cache16Bits cache16Bits = new Cache16Bits();

        System.out.println();
        System.out.println("Direct Mapping 16 Bits:");
        System.out.println();

        cache16Bits.directMapping(memory1.getMemory());
        System.out.println();
        System.out.println("Total Attempts: " + cache16Bits.getTotalAttempts());
        System.out.println("Hits: " + cache16Bits.getHit());
        System.out.println("Misses: " + cache16Bits.getMiss());


        Reader reader2 = new Reader();
        Memory memory2 = new Memory();

        System.out.println();
        System.out.println("Memory Addresses:");
        System.out.println();

        try {
            reader2.getCacheMappingQuestionTwo(memory2.getMemory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s: memory2.getMemory()
             ) {
            System.out.println(s);
        }


        System.out.println();
        System.out.println("Direct Mapping 32 Bits:");
        System.out.println();

        Cache32Bits cache32Bits = new Cache32Bits();

        cache32Bits.directMapping(memory2.getMemory());

        System.out.println();
        System.out.println("Total Attempts: " + cache32Bits.getTotalAttempts());
        System.out.println("Hits: " + cache32Bits.getHit());
        System.out.println("Misses: " + cache32Bits.getMiss());
    }
}
