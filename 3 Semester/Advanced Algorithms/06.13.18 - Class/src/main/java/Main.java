import logic.ThreeCnfSat;
import reader.Reader;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        ThreeCnfSat cbs = new ThreeCnfSat();
        ThreeCnfSat uf20 = new ThreeCnfSat();

        for (int i = 0; i < 1000; i++) {
            String path = "CBS_k3_n100_m403_b90/CBS_k3_n100_m403_b90_"+i+".cnf";
            Reader reader = new Reader(path);
            try {
                reader.read(cbs.getFileLines());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        


        for (int i = 1; i < 1001; i++) {
            String path = "uf20-91/uf20-0"+i+".cnf";
            Reader reader = new Reader(path);
            try {
                reader.read(uf20.getFileLines());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
