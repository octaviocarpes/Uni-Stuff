package cache;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache16Bits {

    private ArrayList<CacheLine> lines;
    private HashMap<String, String> associativeMemory;
    private int hit;
    private int miss;
    private int totalAttempts;

    public Cache16Bits() {
        this.hit = 0;
        this.miss = 0;
        this.totalAttempts = 0;
        associativeMemory = new HashMap<>();
        lines = new ArrayList<>();
        lines.add(new CacheLine("0000"));
        lines.add(new CacheLine("0001"));
        lines.add(new CacheLine("0010"));
        lines.add(new CacheLine("0011"));
        lines.add(new CacheLine("0100"));
        lines.add(new CacheLine("0101"));
        lines.add(new CacheLine("0110"));
        lines.add(new CacheLine("0111"));
        lines.add(new CacheLine("1000"));
        lines.add(new CacheLine("1001"));
        lines.add(new CacheLine("1010"));
        lines.add(new CacheLine("1011"));
        lines.add(new CacheLine("1100"));
        lines.add(new CacheLine("1101"));
        lines.add(new CacheLine("1110"));
        lines.add(new CacheLine("1111"));

    }

    public void directMapping(List<String> memory) {
        for (String s : memory) {
            String[] memoryData = s.split(" - ");
            String hex = memoryData[0];
            String bin = memoryData[1];

            String tag = bin.substring(0, 9);
            String line = bin.substring(9, 13);
            String word = bin.substring(13, 16);
            String wordPosition = word.substring(0, 2);

//            System.out.println(hex + " - " + tag + " - " + line + " - " + word + " - " + wordPosition);

            for (CacheLine cache : lines) {
                if (line.equals(cache.getLine())) {
                    if (tag.equals(cache.getTag())) {
                        for (int i = 0; i < 4; i++) {
                            if (cache.getWords()[i].equals(hex)) {
                                // Hit!
                                hit++;
                                cache.setHit(true);
                            }
                        }
                    } else {
                        // Miss!
                        cache.setTag(tag);
                        switch (wordPosition) {
                            case "00":
                                int decimal2 = Integer.parseInt(hex, 16) + 2;
                                String hex2 = Integer.toHexString(decimal2);
                                hex2 = formatHexString(hex2);

                                int decimal3 = Integer.parseInt(hex, 16) + 4;
                                String hex3 = Integer.toHexString(decimal3);
                                hex3 = formatHexString(hex3);

                                int decimal4 = Integer.parseInt(hex, 16) + 6;
                                String hex4 = Integer.toHexString(decimal4);
                                hex4 = formatHexString(hex4);

                                cache.getWords()[0] = hex;
                                cache.getWords()[1] = hex2;
                                cache.getWords()[1] = hex3;
                                cache.getWords()[1] = hex4;
                                break;
                            case "01":
                                int decimal1 = Integer.parseInt(hex, 16) - 2;
                                String hex1 = Integer.toHexString(decimal1);
                                formatHexString(hex1);

                                decimal3 = Integer.parseInt(hex, 16) + 2;
                                hex3 = Integer.toHexString(decimal3);
                                formatHexString(hex3);

                                decimal4 = Integer.parseInt(hex, 16) + 4;
                                hex4 = Integer.toHexString(decimal4);
                                formatHexString(hex4);

                                cache.getWords()[0] = hex1;
                                cache.getWords()[1] = hex;
                                cache.getWords()[2] = hex3;
                                cache.getWords()[3] = hex4;
                                break;
                            case "10":
                                decimal1 = Integer.parseInt(hex, 16) - 4;
                                hex1 = Integer.toHexString(decimal1);
                                formatHexString(hex1);

                                decimal2 = Integer.parseInt(hex, 16) - 2;
                                hex2 = Integer.toHexString(decimal2);
                                formatHexString(hex2);

                                decimal4 = Integer.parseInt(hex, 16) + 2;
                                hex4 = Integer.toHexString(decimal4);
                                formatHexString(hex4);

                                cache.getWords()[0] = hex1;
                                cache.getWords()[1] = hex2;
                                cache.getWords()[2] = hex;
                                cache.getWords()[3] = hex4;
                                break;
                            case "11":
                                decimal1 = Integer.parseInt(hex, 16) - 6;
                                hex1 = Integer.toHexString(decimal1);
                                formatHexString(hex1);

                                decimal2 = Integer.parseInt(hex, 16) - 4;
                                hex2 = Integer.toHexString(decimal2);
                                formatHexString(hex2);

                                decimal3 = Integer.parseInt(hex, 16) - 2;
                                hex3 = Integer.toHexString(decimal3);
                                formatHexString(hex3);

                                cache.getWords()[0] = hex1;
                                cache.getWords()[1] = hex2;
                                cache.getWords()[2] = hex3;
                                cache.getWords()[3] = hex;
                                break;
                        }
                        miss++;
                        cache.setHit(false);
                    }
                }
                System.out.println(cache);
            }
        }
    }


    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getMiss() {
        return miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public void setTotalAttempts(int totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    private String formatHexString(String hex) {
        if (hex.length() < 4) {
            int length = 4 - hex.length();
            for (int i = 0; i < length; i++) {
                hex = "0" + hex;
            }
        }
        return hex;
    }
}