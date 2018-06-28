package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacents;

    public Vertex(String name) {
        this.name = name;
        this.adjacents = new ArrayList();
        this.visited = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(List<Vertex> adjacents) {
        this.adjacents = adjacents;
    }

    public void addAdjacent(Vertex vertex){
        adjacents.add(vertex);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjacents.size(); i++) {
            if (i == (adjacents.size() - 1)){
                stringBuilder.append(adjacents.get(i).getName());
            } else {
                stringBuilder.append(adjacents.get(i).getName() + " - ");
            }
        }
        return name + "[ " + stringBuilder.toString() + " ]";
    }
}
