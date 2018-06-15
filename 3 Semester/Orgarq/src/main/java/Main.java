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

    }
}
