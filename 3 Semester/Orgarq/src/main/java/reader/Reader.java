package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private BufferedReader bufferedReader;
    private String FILEPATH = "cache map/lista-acessos.txt";

    public Reader() {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(FILEPATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getCacheMapping(List<String> memory) throws IOException {
        String st;

        while ((st = bufferedReader.readLine()) != null){
            if (st.length() < 16){
                continue;
            } else if(st.length() > 16){
                String[] memoryString = st.split(" - ");

                String cacheTag = memoryString[0].substring(0,10);
                String cacheLine = memoryString[0].substring(10,14);
                String cacheWord = memoryString[0].substring(14,16);

                String memoryTag = memoryString[2].substring(0,10);
                String memoryLine = memoryString[2].substring(10,14);
                String memoryWord = memoryString[2].substring(14,16);

                memory.add(cacheTag + " - " + cacheLine + " - " + cacheWord + " : " + memoryTag + " - " + memoryLine + " - " + memoryWord + " : " + memoryString[1]);

            } else {
                String[] memoryLine = st.split(" - ");

                String tag = memoryLine[0].substring(0,10);
                String line = memoryLine[0].substring(10,14);
                String word = memoryLine[0].substring(14,16);

                memory.add(tag + " - " + line + " - " + word);
            }
        }
    }
}
