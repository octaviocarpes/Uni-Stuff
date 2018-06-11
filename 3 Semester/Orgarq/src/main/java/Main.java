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

        for (String s: memory.getMemory()
             ) {
            System.out.println(s);
        }


    }
}
