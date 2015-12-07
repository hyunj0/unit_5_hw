package graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graphs {

    private static Graph makeTestGraph() {
        Graph graph = new Graph();
        graph.addVertices("v1", "v2", "v3", "v4", "v5", "v6", "v7");
        graph.addDirectedEdge("v1", "v2", 2);
        graph.addDirectedEdge("v1", "v4", 1);
        graph.addDirectedEdge("v2", "v4", 3);
        graph.addDirectedEdge("v2", "v5", 10);
        graph.addDirectedEdge("v3", "v1", 4);
        graph.addDirectedEdge("v3", "v6", 5);
        graph.addDirectedEdge("v4", "v3", 2);
        graph.addDirectedEdge("v4", "v5", 2);
        graph.addDirectedEdge("v4", "v6", 8);
        graph.addDirectedEdge("v4", "v7", 4);
        graph.addDirectedEdge("v5", "v7", 6);
        graph.addDirectedEdge("v7", "v6", 1);
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = makeTestGraph();

        System.out.println("# vertices = " + graph.vertices.size());
        System.out.println("cost from v1 to v2 = " + graph.getWeight("v1", "v2"));
        System.out.println("cost from v1 to v6 = " + graph.getWeight("v1", "v6"));
        System.out.println("neighbors of v4 = " + graph.getNeighbors("v4"));
        System.out.println("neighbors of v6 = " + graph.getNeighbors("v6"));

        System.out.println("cost from v1 to v1 = " + graph.getWeight("v1", "v1"));
    }
}

class Graph {

    Map<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<String, Vertex>();
    }

    public void addVertices(String... names) {
        for(String name : names) {
            addVertex(name);
        }
    }

    public void addVertex(String name) {
        vertices.put(name, new Vertex(name));
    }

    public void addUndirectedEdge(String from, String to, int weight) {
        addDirectedEdge(from, to, weight);
        addDirectedEdge(to, from, weight);
    }

    public void addDirectedEdge(String from, String to, int weight) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if(v1 == null || v2 == null) throw new IllegalStateException();
        v1.neighborsToWeights.put(v2, weight);
    }

    public Set<Vertex> getNeighbors(String name) {
        Vertex v = vertices.get(name);
        if(v == null) return Collections.EMPTY_SET;

        return v.getNeighbors();
    }

    public int getWeight(String from, String to) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if(v1 == null || v2 == null) return - 1;
        Integer weight = v1.neighborsToWeights.get(v2);
        if(weight == null) return Integer.MAX_VALUE;
        return weight;
    }

}

class Vertex
{
    String name;

    Map<Vertex, Integer> neighborsToWeights;

    int distance;

    public Vertex(String name) {
        this.name = name;
        this.neighborsToWeights = new HashMap<Vertex, Integer>();
        this.distance = Integer.MAX_VALUE;
    }

    public Set<Vertex> getNeighbors() {
        return this.neighborsToWeights.keySet();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name;
    }
}

class VertexComparator implements Comparator<Vertex> {
    @Override
    public int compare(Vertex o1, Vertex o2) {
        if (o1.distance > o2.distance)
            return 1;
        else if (o1.distance < o2.distance)
            return -1;
        else
            return 0;
    }
}