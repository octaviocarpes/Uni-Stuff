package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {

    private BufferedReader reader;
    private String PATH;

    public Reader(String path) {
        this.PATH = path;
        try {
            this.reader = new BufferedReader(new FileReader(PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void read(List<String> list) throws IOException {
        String st;
        while ((st = reader.readLine()) != null){
            list.add(st);
        }
    }
}
