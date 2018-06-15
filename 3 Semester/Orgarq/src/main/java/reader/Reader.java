package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private BufferedReader bufferedReader;
    private String FILEPATH = "cache map/hex-address.txt";

    public Reader() {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(FILEPATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getCacheMappingQuestionOne(List<String> memory) throws IOException {
        String st;

        while ((st = bufferedReader.readLine()) != null) {
            Integer integer = Integer.parseInt(st,16);
            String binaryString = Integer.toBinaryString(integer);
            if (binaryString.length() != 16){
                int length = (16 - binaryString.length());
                for (int i = 0; i < length ; i++) {
                    binaryString = "0"+binaryString;
                }
            }
            memory.add(st + " - " + binaryString);
        }
    }

    public void getCacheMappingQuestionTwo(List<String> memory) throws IOException {
        String st;

        while ((st = bufferedReader.readLine()) != null){
            if (st.length() < 16){
                continue;
            } else if(st.length() > 16){
                String[] memoryString = st.split(" - ");

                String cacheTag = memoryString[0].substring(0,10);
                String cacheLine = memoryString[0].substring(10,15);
                String cacheWord = memoryString[0].substring(15,16);

                String memoryTag = memoryString[2].substring(0,10);
                String memoryLine = memoryString[2].substring(10,15);
                String memoryWord = memoryString[2].substring(15,16);

                memory.add(cacheTag + " - " + cacheLine + " - " + cacheWord + " : " + memoryTag + " - " + memoryLine + " - " + memoryWord + " : " + memoryString[1]);

            } else {
                String[] memoryLine = st.split(" - ");

                String tag = memoryLine[0].substring(0,10);
                String line = memoryLine[0].substring(10,15);
                String word = memoryLine[0].substring(15,16);

                memory.add(tag + " - " + line + " - " + word);
            }
        }
    }
}
