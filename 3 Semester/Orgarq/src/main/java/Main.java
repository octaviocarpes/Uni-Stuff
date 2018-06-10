import cache.Cache;
import cache.MemoryLine;

public class Main {
    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.populateMemory();

        for (MemoryLine s:cache.getMemoryLine()
             ) {
            System.out.println(s);
        }



    }
}
