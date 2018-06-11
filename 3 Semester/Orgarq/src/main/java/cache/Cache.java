package cache;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private String[] lines;
    private String[] tag;
    private ArrayList<String>[] words;

    public Cache() {
        this.lines = new String[16];
        this.tag = new String[16];
        this.words = new ArrayList[16];

        lines[0] =   "0000"; tag[0] =   "";  words[0] =   new ArrayList<String>();
        lines[1] =   "0001"; tag[1] =   "";  words[1] =   new ArrayList<String>();
        lines[2] =   "0010"; tag[2] =   "";  words[2] =   new ArrayList<String>();
        lines[3] =   "0011"; tag[3] =   "";  words[3] =   new ArrayList<String>();
        lines[4] =   "0100"; tag[4] =   "";  words[4] =   new ArrayList<String>();
        lines[5] =   "0101"; tag[5] =   "";  words[5] =   new ArrayList<String>();
        lines[6] =   "0110"; tag[6] =   "";  words[6] =   new ArrayList<String>();
        lines[7] =   "0111"; tag[7] =   "";  words[7] =   new ArrayList<String>();
        lines[8] =   "1000"; tag[8] =   "";  words[8] =   new ArrayList<String>();
        lines[9] =   "1001"; tag[9] =   "";  words[9] =   new ArrayList<String>();
        lines[10] =  "1010"; tag[10] =  "";  words[10] =  new ArrayList<String>();
        lines[11] =  "1011"; tag[11] =  "";  words[11] =  new ArrayList<String>();
        lines[12] =  "1100"; tag[12] =  "";  words[12] =  new ArrayList<String>();
        lines[13] =  "1101"; tag[13] =  "";  words[13] =  new ArrayList<String>();
        lines[14] =  "1110"; tag[14] =  "";  words[14] =  new ArrayList<String>();
        lines[15] =  "1111"; tag[15] =  "";  words[15] =  new ArrayList<String>();
    }

    public void fillCache(List<String> memory){
        for (String memoryString: memory
             ) {

            String[] memoryData = memoryString.split(" - ");

            String memoryTag = memoryData[0];
            String memoryLine = memoryData[1];
            String memoryWord = memoryData[2];


        }
    }
}
