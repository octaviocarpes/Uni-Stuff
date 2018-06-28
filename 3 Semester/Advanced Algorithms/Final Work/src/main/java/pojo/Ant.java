package pojo;

import dataStructure.Edge;
import dataStructure.Graph;
import dataStructure.Vertex;

import java.util.List;
import java.util.Random;

public class Ant {

    private int pheromone;

    public Ant() {
        this.pheromone = 5;
    }

    public void march(Vertex checkpoint, Graph graph){
        if (checkpoint.getName().equals("A") && checkpoint.isVisited()){
            return;
        }
        int max = checkpoint.getAdjacents().size() + 1;
        Random random = new Random();
        int randomIndex = random.nextInt(max - 1);

        String aName = checkpoint.getName();
        String bName = checkpoint.getAdjacents().get(randomIndex).getName();

//        Go from A to B
//         - Find Edge in edges
//         - Mark B as Visited
//         - Print Path

        Vertex b = getVertexB(bName,graph);

        for (Edge e: graph.getEdges()) {
            if ((aName.equals(e.getA()) && bName.equals(e.getB())) || (aName.equals(e.getB()) && bName.equals(e.getA()))){
                e.setPheromoneIntensity(pheromone + e.getPheromoneIntensity());
                b.setVisited(true);
                System.out.println(checkpoint.getName() + " -> " + b.getName() + " Pheromone Intensity: " + e.getPheromoneIntensity());
           }
        }

        march(b, graph);
    }

    public void followPheromone(Vertex checkpoint, Graph graph){
        if (checkpoint.getName().equals("A") && checkpoint.isVisited()){
            return;
        }

        for (Vertex v: graph.getVertices()) {
            for (Vertex adj: v.getAdjacents()) {
//                TODO: Finish implementation
            }
        }
    }

    private Vertex getVertexB(String bName, Graph graph){
        for (Vertex v: graph.getVertices()) {
            if (bName.equals(v.getName())){
                return v;
            }
        }
        return new Vertex("");
    }
}
