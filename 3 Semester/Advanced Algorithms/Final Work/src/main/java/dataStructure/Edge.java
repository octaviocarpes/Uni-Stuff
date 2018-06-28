package dataStructure;

public class Edge {

    private int distance;
    private String a;
    private String b;
    private int pheromoneIntensity;

    public Edge(int distance, String a, String b, int pheromoneIntensity) {
        this.distance = distance;
        this.a = a;
        this.b = b;
        this.pheromoneIntensity = pheromoneIntensity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getPheromoneIntensity() {
        return pheromoneIntensity;
    }

    public void setPheromoneIntensity(int pheromoneIntensity) {
        this.pheromoneIntensity = pheromoneIntensity;
    }

    @Override
    public String toString() {
        return getA() + " - " + getB() + " | Distance: " + getDistance() + " | Pheromone itensity: " + pheromoneIntensity;
    }
}
