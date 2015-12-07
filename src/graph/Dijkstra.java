package graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

    public static int findShortestPath(Graph graph, Vertex start) {
        start.distance = 0;
        System.out.println("starting vertex distance = " + start.distance);

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>(graph.vertices.size(), new VertexComparator());
        HashSet<Vertex> visited = new HashSet<Vertex>();

        for (String name : graph.vertices.keySet()) {
            Vertex vertex = graph.vertices.get(name);
            System.out.println(vertex.name + " distance = " + vertex.distance);
        }

        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Vertex v = priorityQueue.poll();
            System.out.println("priority queue removed " + v.name);

            Set<Vertex> neighbors = v.getNeighbors();
            for (Vertex neighbor : neighbors) {
                int edgeDistance = v.distance + graph.getWeight(v.name, neighbor.name);
                if (edgeDistance < neighbor.distance)
                    neighbor.distance = edgeDistance;
                System.out.println(neighbor.name + " distance = " + neighbor.distance);
                if (!visited.contains(neighbor))
                    priorityQueue.add(neighbor);
                //todo update priorityQueue
            }

            visited.add(v);
            for (Vertex vertex : visited) {
                System.out.println("visited " + vertex.name);
            }
        }

        //todo calculate shortest path
        return start.distance;
    }

    public static void main(String[] args) {
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
        System.out.println("Dijkstra's shortest path = " + findShortestPath(graph, graph.vertices.get("v1")));
    }
}