package logic;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    List<Problem> problems;

    public DataStorage() {
        this.problems = new ArrayList<>();
    }

    public void addProblem(Problem problem){
        problems.add(problem);
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
