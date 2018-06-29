package pojo;

import dataStructure.Edge;
import dataStructure.Graph;
import dataStructure.Vertex;
import sun.misc.Queue;

import java.util.List;
import java.util.Random;

public class Ant {

    private int pheromone;

    public Ant() {
        this.pheromone = 15;
    }


//    TODO: FIx null pointer at line 90
    public void march(Vertex checkpoint, Graph graph){
        if (checkpoint.getName().equals("A") && checkpoint.isVisited()){
            return;
        }
//        int max = checkpoint.getAdjacents().size() + 1;
//        Random random = new Random();
//        int randomIndex = random.nextInt(max - 1);
//
//        String aName = checkpoint.getName();
//        String bName = checkpoint.getAdjacents().get(randomIndex).getName();
//
////        Go from A to B
////         - Find Edge in edges
////         - Mark B as Visited
////         - Print Path
//
//        Vertex b = getVertexB(bName,graph);
//
//        for (Edge e: graph.getEdges()) {
//            if ((aName.equals(e.getA()) && bName.equals(e.getB())) || (aName.equals(e.getB()) && bName.equals(e.getA()))){
//                e.setPheromoneIntensity(e.getPheromoneIntensity() + (pheromone - e.getDistance()));
//                b.setVisited(true);
//                System.out.println(checkpoint.getName() + " -> " + b.getName() + " Pheromone Intensity: " + e.getPheromoneIntensity());
//           }
//        }
//
//        march(b, graph);

        Queue<Vertex> queue = new Queue();

        for (Vertex adj: checkpoint.getAdjacents()) {
            if (!adj.isVisited()){
                queue.enqueue(adj);
            }
        }

        while (!queue.isEmpty()){
            try {
                Edge edge = new Edge();
                Vertex vertex = queue.dequeue();
                vertex.setVisited(true);
//                Find corresponding edge
                for (Edge e: graph.getEdges()) {
                    if ((checkpoint.getName().equals(e.getA()) && vertex.getName().equals(e.getB())) ||
                            (checkpoint.getName().equals(e.getB()) && vertex.getName().equals(e.getA()))){
                        edge = e;
                    }
                }

                Vertex b = getVertexB(edge.getB(), graph);
                for (Vertex adj: b.getAdjacents()) {
                    queue.enqueue(adj);
                }
                System.out.println(b);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void followPheromone(Vertex checkpoint, Graph graph){
        if (checkpoint.getName().equals("A") && checkpoint.isVisited()){
            return;
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
