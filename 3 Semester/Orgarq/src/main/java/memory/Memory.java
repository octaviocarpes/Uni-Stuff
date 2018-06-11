package memory;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private List<String> memory;

    public Memory() {
        this.memory = new ArrayList<>();
    }

    public List<String> getMemory() {
        return memory;
    }
}
