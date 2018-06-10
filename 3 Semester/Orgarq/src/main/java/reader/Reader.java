package reader;

import cache.MemoryLine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    public void getCacheMapping(ArrayList<MemoryLine> cacheMap) throws IOException {
        String st;

        while ((st = bufferedReader.readLine()) != null){
            if (st.length() == 0){
                continue;
            }

            if (st.length() > 16){
                StringBuilder sb = new StringBuilder();
                String[] instructions = st.split(" - ");
                sb.append(instructions[0].charAt(0));
                sb.append(instructions[0].charAt(1));
                sb.append(instructions[0].charAt(2));
                sb.append(instructions[0].charAt(3));
                sb.append(instructions[0].charAt(4));
                sb.append(instructions[0].charAt(5));
                sb.append(instructions[0].charAt(6));
                sb.append(instructions[0].charAt(7));
                sb.append(instructions[0].charAt(8));
                sb.append(instructions[0].charAt(9));

                String tag = sb.toString();

                sb = new StringBuilder();

                sb.append(instructions[0].charAt(10));
                sb.append(instructions[0].charAt(11));
                sb.append(instructions[0].charAt(12));
                sb.append(instructions[0].charAt(13));

                String line = sb.toString();

                sb = new StringBuilder();

                sb.append(instructions[0].charAt(14));
                sb.append(instructions[0].charAt(15));

                String word = sb.toString();

                sb = new StringBuilder();

                sb.append(instructions[2].charAt(0));
                sb.append(instructions[2].charAt(1));
                sb.append(instructions[2].charAt(2));
                sb.append(instructions[2].charAt(3));
                sb.append(instructions[2].charAt(4));
                sb.append(instructions[2].charAt(5));
                sb.append(instructions[2].charAt(6));
                sb.append(instructions[2].charAt(7));
                sb.append(instructions[2].charAt(8));
                sb.append(instructions[2].charAt(9));

                String instructionDataTag = sb.toString();

                sb = new StringBuilder();

                sb.append(instructions[2].charAt(10));
                sb.append(instructions[2].charAt(11));
                sb.append(instructions[2].charAt(12));
                sb.append(instructions[2].charAt(13));

                String instructionDataLine = sb.toString();

                sb = new StringBuilder();

                sb.append(instructions[2].charAt(14));
                sb.append(instructions[2].charAt(15));

                String instructionDataWord = sb.toString();

                MemoryLine memoryLine = new MemoryLine(tag,line,word);
                memoryLine.setInstruction( " : "  + instructions[1] + " - ");
                memoryLine.setInstructionData(instructionDataTag + " - " + instructionDataLine + " - " + instructionDataWord);

                cacheMap.add(memoryLine);
            }

            StringBuilder sb = new StringBuilder();

            sb.append(st.charAt(0));
            sb.append(st.charAt(1));
            sb.append(st.charAt(2));
            sb.append(st.charAt(3));
            sb.append(st.charAt(4));
            sb.append(st.charAt(5));
            sb.append(st.charAt(6));
            sb.append(st.charAt(7));
            sb.append(st.charAt(8));
            sb.append(st.charAt(9));

            String tag = sb.toString();

            sb = new StringBuilder();

            sb.append(st.charAt(10));
            sb.append(st.charAt(11));
            sb.append(st.charAt(12));
            sb.append(st.charAt(13));

            String line  = sb.toString();

            sb = new StringBuilder();

            sb.append(st.charAt(14));
            sb.append(st.charAt(15));

            String word = sb.toString();

            cacheMap.add(new MemoryLine(tag,line,word));
        }
    }
}
