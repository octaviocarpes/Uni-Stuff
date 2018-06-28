package dataStructure;

import java.util.List;

public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------Vertices------\n\n");
        for (Vertex v: vertices) {
            sb.append(v);
            sb.append("\n");
        }
        sb.append("\n-------Edges------\n\n");
        for (Edge e: edges) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }


}
