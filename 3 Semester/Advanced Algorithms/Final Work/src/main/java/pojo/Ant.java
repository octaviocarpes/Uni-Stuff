package pojo;

import dataStructure.Edge;
import dataStructure.Graph;
import dataStructure.Vertex;
import sun.misc.Queue;
import java.util.List;

public class Ant {

    private int pheromone;

    public Ant() {
        this.pheromone = 15;
    }



    public void march(Vertex checkpoint, Graph graph){
        for (Vertex adj: checkpoint.getAdjacents()) {
            Edge currentEdge = getEdge(checkpoint, adj, graph);
            if (currentEdge.isVisited()){
                continue;
            } else {
                currentEdge.setPheromoneIntensity(currentEdge.getPheromoneIntensity() + (pheromone - currentEdge.getDistance()));
                currentEdge.setVisited(true);
            }
        }
    }

    public void followPheromone(Vertex checkpoint, Graph graph){
        if (graph.checkAllVisited()){
            return;
        }
        Edge highestPheromone = new Edge();
        highestPheromone.setPheromoneIntensity(0);
        for (Vertex adj: checkpoint.getAdjacents()) {
            Edge currentEdge = getEdge(checkpoint, adj, graph);
            if (highestPheromone.getPheromoneIntensity() < currentEdge.getPheromoneIntensity()){
                highestPheromone = currentEdge;
            }
        }

        if (highestPheromone.isVisited()){
//            search for unvisited edges of checkpoint
            for (Vertex adj:checkpoint.getAdjacents()) {
                if (adj.isVisited()){
                    continue;
                } else {
                    followPheromone(adj, graph);
                }
            }
        } else {
            highestPheromone.setVisited(true);
            Vertex b = getVertexB(checkpoint, highestPheromone, graph);
            b.setVisited(true);
            int size = graph.getEdges().size() - 1;
            for (int i = 0; i < size; i++) {
                if (highestPheromone.getA() == null){
                    return;
                }
                if ((highestPheromone.getA().equals(graph.getEdges().get(i).getA()) && highestPheromone.getB().equals(graph.getEdges().get(i).getB())) ||
                        (highestPheromone.getA().equals(graph.getEdges().get(i).getB()) && highestPheromone.getB().equals(graph.getEdges().get(i).getA()))){
                    graph.getEdges().remove(i);
                }
            }
            System.out.println(checkpoint.getName() + " -> " + b.getName());
            followPheromone(b, graph);
        }
    }

    private Edge getEdge(Vertex a, Vertex b, Graph graph){
        Edge correspondingEdge = new Edge();
        for (Edge edge:graph.getEdges()) {
             if ((a.getName().equals(edge.getA()) && b.getName().equals(edge.getB()))||
                     (a.getName().equals(edge.getB()) && b.getName().equals(edge.getA()))){
                 correspondingEdge = edge;
             }
        }
        return correspondingEdge;
    }

    private Vertex getVertexB(Vertex checkpoint,Edge edge, Graph graph){
        Vertex response = new Vertex("");
        if (checkpoint.getName().equals(edge.getA())){
            for (Vertex v:graph.getVertices()) {
                if (v.getName().equals(edge.getB())){
                    return v;
                }
            }
        } else {
            for (Vertex v: graph.getVertices()){
                if (v.getName().equals(edge.getA())){
                    return v;
                }
            }
        }
        return response;
    }
}
