import dataStructure.Edge;
import dataStructure.Graph;
import dataStructure.Vertex;
import pojo.Ant;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        a.addAdjacent(b);
        a.addAdjacent(e);

        b.addAdjacent(a);
        b.addAdjacent(c);
        b.addAdjacent(f);

        c.addAdjacent(b);
        c.addAdjacent(d);
        c.addAdjacent(f);

        d.addAdjacent(c);
        d.addAdjacent(e);
        d.addAdjacent(f);

        e.addAdjacent(a);
        e.addAdjacent(d);
        e.addAdjacent(f);

        f.addAdjacent(b);
        f.addAdjacent(c);
        f.addAdjacent(d);
        f.addAdjacent(e);

        ArrayList<Vertex> vertices = new ArrayList<>();

        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(5,"A", "B", 0));
        edges.add(new Edge(3,"A", "E", 0));
        edges.add(new Edge(8,"B", "C", 0));
        edges.add(new Edge(1,"B", "F", 0));
        edges.add(new Edge(1,"C", "F", 0));
        edges.add(new Edge(1,"C", "D", 0));
        edges.add(new Edge(2,"D", "F", 0));
        edges.add(new Edge(1,"D", "E", 0));
        edges.add(new Edge(2,"E", "F", 0));

        Graph graph = new Graph(vertices, edges);

        Ant anthony = new Ant();

        System.out.println("\nAnthony Marching!");
        for (int i = 0; i < graph.getVertices().size(); i++) {
            anthony.march(graph.getVertices().get(i), graph);
        }
        System.out.println(graph.toString());
        graph.clearAllVisited();

        System.out.println();
        System.out.println();

        System.out.println("Follow the Pheromones Anthony!");
        anthony.followPheromone(graph.getVertices().get(0), graph);
    }
}
