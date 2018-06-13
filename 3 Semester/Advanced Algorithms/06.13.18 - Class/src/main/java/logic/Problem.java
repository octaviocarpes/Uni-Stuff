package logic;

public class Problem {

    String name;
    boolean canBeSolved;

    public Problem(String name, boolean canBeSolved) {
        this.name = name;
        this.canBeSolved = canBeSolved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanBeSolved() {
        return canBeSolved;
    }

    public void setCanBeSolved(boolean canBeSolved) {
        this.canBeSolved = canBeSolved;
    }
}
