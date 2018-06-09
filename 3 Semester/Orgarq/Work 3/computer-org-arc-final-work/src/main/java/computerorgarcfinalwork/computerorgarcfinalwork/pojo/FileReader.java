package computerorgarcfinalwork.computerorgarcfinalwork.pojo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    private BufferedReader fileReader = null;

    public FileReader() {
        try {
            fileReader = new BufferedReader(new java.io.FileReader("/Users/octaviocarpes/Documents/Github/Uni-Stuff/3 Semester/Orgarq/Work 3/computer-org-arc-final-work/memory/lista-acessos.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String st = "";
        while((st = fileReader.readLine()) != null){
            sb.append(st);
        }
        return sb.toString();
    }


}
