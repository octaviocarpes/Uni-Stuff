package cache;

import com.sun.xml.internal.ws.api.model.MEP;

public class MemoryLine {

    private String tag;
    private String line;
    private String word;
    private String instruction;
    private String instructionData;

    public MemoryLine(String tag, String line, String word) {
        this.tag = tag;
        this.line = line;
        this.word = word;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getInstructionData() {
        return instructionData;
    }

    public void setInstructionData(String instructionData) {
        this.instructionData = instructionData;
    }

    @Override
    public String toString() {
        if(instruction == null || instructionData == null){
            instruction = "";
            instructionData = "";
        }
        return tag + " - " + line + " - " + word + instruction  + instructionData;
    }
}
