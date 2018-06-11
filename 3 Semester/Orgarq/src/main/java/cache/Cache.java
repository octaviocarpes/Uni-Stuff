package cache;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private String[] lines;
    private String[] tag;
    private ArrayList<String>[] words;
    private boolean[] hit;
    private int hitCounter;
    private int missCounter;

    public Cache() {
        this.lines = new String[16];
        this.tag = new String[16];
        this.words = new ArrayList[16];
        this.hit = new boolean[16];
        this.hitCounter = 0;
        this.missCounter = 0;

        lines[0] =   "0000"; tag[0] =   "";  words[0] =   new ArrayList<>();  hit[0] =  false;
        lines[1] =   "0001"; tag[1] =   "";  words[1] =   new ArrayList<>();  hit[1] =  false;
        lines[2] =   "0010"; tag[2] =   "";  words[2] =   new ArrayList<>();  hit[2] =  false;
        lines[3] =   "0011"; tag[3] =   "";  words[3] =   new ArrayList<>();  hit[3] =  false;
        lines[4] =   "0100"; tag[4] =   "";  words[4] =   new ArrayList<>();  hit[4] =  false;
        lines[5] =   "0101"; tag[5] =   "";  words[5] =   new ArrayList<>();  hit[5] =  false;
        lines[6] =   "0110"; tag[6] =   "";  words[6] =   new ArrayList<>();  hit[6] =  false;
        lines[7] =   "0111"; tag[7] =   "";  words[7] =   new ArrayList<>();  hit[7] =  false;
        lines[8] =   "1000"; tag[8] =   "";  words[8] =   new ArrayList<>();  hit[8] =  false;
        lines[9] =   "1001"; tag[9] =   "";  words[9] =   new ArrayList<>();  hit[9] =  false;
        lines[10] =  "1010"; tag[10] =  "";  words[10] =  new ArrayList<>();  hit[10] = false;
        lines[11] =  "1011"; tag[11] =  "";  words[11] =  new ArrayList<>();  hit[11] = false;
        lines[12] =  "1100"; tag[12] =  "";  words[12] =  new ArrayList<>();  hit[12] = false;
        lines[13] =  "1101"; tag[13] =  "";  words[13] =  new ArrayList<>();  hit[13] = false;
        lines[14] =  "1110"; tag[14] =  "";  words[14] =  new ArrayList<>();  hit[14] = false;
        lines[15] =  "1111"; tag[15] =  "";  words[15] =  new ArrayList<>();  hit[15] = false;
    }

    public void directMapping(List<String> memory){
        for (String memoryString: memory
             ) {

            if (memoryString.length() > 22){
                String[] memoryData = memoryString.split(" : ");
                String cacheContent = memoryData[0];
                String memoryContent = memoryData[1];
                String instruction = memoryData[2];

                String cacheTag;
                String cacheLine;
                ArrayList<String> cacheWords = new ArrayList<>();

            } else {
                String[] memoryData = memoryString.split(" - ");

                String memoryTag = memoryData[0];
                String memoryLine = memoryData[1];
                String memoryWord = memoryData[2];

                for (int i = 0; i < 16 ; i++) {
                    if (memoryLine.equals(lines[i])){
                        if (memoryTag.equals(tag[i])){
                            if (hit[i]){
                                hitCounter++;
                                if (words[i].size() < 4){
                                    words[i].add(memoryWord);
                                }
                            } else {

                            }
                        } else {
                            missCounter++;
                            tag[i] = memoryTag;
                            if (words[i].size() < 4){
                                words[i].add(memoryWord);
                            }
                            System.out.println(tag[i] + " - " + lines[i] + " - " + words[i] + " : " + hit[i]);
                            hit[i] = true;
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        System.out.println("Hits: " + hitCounter);
        System.out.println("Misses: " + missCounter);
    }




}
